package com.fietsenwachtapp.demo.exceptions;

import java.util.List;
import java.util.UUID;

public class SkuIdsDontExistException extends RuntimeException {
    private final List<UUID> invalidIds;

    public SkuIdsDontExistException(List<UUID> invalidIds) {
        super("Invalid SKU IDs");
        this.invalidIds = invalidIds;
    }

    public List<UUID> getInvalidIds() {
        return invalidIds;
    }
}
