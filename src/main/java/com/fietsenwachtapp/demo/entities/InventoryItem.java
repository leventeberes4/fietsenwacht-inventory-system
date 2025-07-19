package com.fietsenwachtapp.demo.entities;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class InventoryItem {
        @Id
        private UUID SKU_ID;
        private int quantity;

        public InventoryItem(UUID itemId, int quantity) {
            this.SKU_ID = itemId;
            this.quantity = quantity;
        }

        public InventoryItem() {}

        public UUID getSKU_ID() {
            return SKU_ID;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
}
