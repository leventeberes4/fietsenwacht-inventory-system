package com.fietsenwachtapp.demo.entities;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class InventoryItem {
        @Id
        private UUID skuId;
        private int quantity;

        public InventoryItem(UUID itemId, int quantity) {
            this.skuId = itemId;
            this.quantity = quantity;
        }

        public InventoryItem() {}

        public UUID getSkuId() {
            return skuId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
}
