package com.dip.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {
    private final int jerseyNumber;
    private final String name;
}
