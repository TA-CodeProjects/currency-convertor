package com.jb.currencyconvertor.services;

import java.util.Map;

public interface ConvertService {
    double MoneyConvert(String from, String to, int amount);
    void cacheRates(String from, Map<String, Double> rates);

}
