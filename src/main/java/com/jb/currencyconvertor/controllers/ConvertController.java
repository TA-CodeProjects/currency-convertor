package com.jb.currencyconvertor.controllers;

import com.jb.currencyconvertor.services.ConvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ConvertController {
    private final ConvertService convertService;

    @GetMapping("convert")
    public double convert(@RequestParam String from, @RequestParam String to, @RequestParam int amount) {
        return convertService.MoneyConvert(from, to, amount);
    }
}
