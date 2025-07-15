package com.fietsenwachtapp.demo.entities;

public class InventoryItem {
        private String itemId;
        private int quantity;

        public InventoryItem(String itemId, int quantity) {
            this.itemId = itemId;
            this.quantity = quantity;
        }

        public String getItemId() {
            return itemId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
}
