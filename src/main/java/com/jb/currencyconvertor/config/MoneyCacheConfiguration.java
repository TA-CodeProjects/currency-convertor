package com.jb.currencyconvertor.config;

import com.jb.currencyconvertor.models.MoneyCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MoneyCacheConfiguration {
    @Bean
    public MoneyCache moneyCache(){
        return new MoneyCache();
    }
}
