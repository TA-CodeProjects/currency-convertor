package com.jb.currencyconvertor.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyCache {
    private Map<String, Map<String, Double>> cacheRates = new HashMap<>();
}
