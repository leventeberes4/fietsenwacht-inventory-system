package com.fietsenwachtapp.demo;

import com.fietsenwachtapp.demo.entities.InventoryItem;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class MongoConfiguration extends AbstractMongoClientConfiguration {
    @Override
    protected void configureConverters(MongoCustomConversions.MongoConverterConfigurationAdapter adapter) {
        adapter.registerConverter(new InventoryListToMapConverter());
        adapter.registerConverter(new InventoryMapToListConverter());
    }
    @ReadingConverter
    static class InventoryListToMapConverter implements Converter<List<InventoryItem>, Map<UUID, InventoryItem>> {
        @Override
        public Map<UUID, InventoryItem> convert(List<InventoryItem> source) {
            if (source == null) return Collections.emptyMap();
            return source.stream()
                    .collect(Collectors.toMap(
                            InventoryItem::getSKU_ID, // Ensure this returns UUID
                            Function.identity()
                    ));
        }
    }
    @WritingConverter
    static class InventoryMapToListConverter implements Converter<Map<UUID, InventoryItem>, List<InventoryItem>> {
        @Override
        public List<InventoryItem> convert(Map<UUID, InventoryItem> source) {
            if (source == null) return Collections.emptyList();
            return new ArrayList<>(source.values());
        }
    }


    @Override
    protected String getDatabaseName() {
        return "database";
    }
}
