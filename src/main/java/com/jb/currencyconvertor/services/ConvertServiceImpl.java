package com.jb.currencyconvertor.services;

import com.jb.currencyconvertor.models.MoneyCache;
import com.jb.currencyconvertor.models.MoneyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ConvertServiceImpl implements ConvertService {
    private final RestTemplate restTemplate;
    private final MoneyCache moneyCache;
    @Value("${convertApi.url}")
    private String url;

    @Override
    public double MoneyConvert(String from, String to, int amount) {
        if (!moneyCache.getCacheRates().containsKey(from)) {
            MoneyResponse response = restTemplate.getForObject(url + "/" + from, MoneyResponse.class);
           if (response == null){
               throw new RuntimeException("invalid parameters");
           }
            Map<String, Double> rates = response.getRates();
            cacheRates(from, rates);
        }
        double rate = moneyCache.getCacheRates().get(from).get(to);
        return rate * amount;
    }

    @Override
    public void cacheRates(String from, Map<String, Double> rates) {
        moneyCache.getCacheRates().put(from, rates);
    }
}
