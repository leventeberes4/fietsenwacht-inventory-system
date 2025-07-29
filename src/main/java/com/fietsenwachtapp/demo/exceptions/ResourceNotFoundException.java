package com.fietsenwachtapp.demo.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String warehouseNotFound) {
        super(warehouseNotFound);
    }
}
