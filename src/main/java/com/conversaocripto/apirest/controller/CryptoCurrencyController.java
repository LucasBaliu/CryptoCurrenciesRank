package com.conversaocripto.apirest.controller;

import com.conversaocripto.apirest.entities.CryptoCurrency;
import com.conversaocripto.apirest.service.CryptoCurrencyService;
import com.conversaocripto.apirest.service.CryptoPricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cryptocurrencyrank")
public class CryptoCurrencyController {

    @Autowired
    private CryptoCurrencyService cryptoCurrencyService;

    @Autowired
    private CryptoPricesService cryptoPricesService;

    @GetMapping(value = "/{coin}")
    public ResponseEntity<List<CryptoCurrency>> findByCoin(@PathVariable String coin) throws IOException, InterruptedException {

        List<CryptoCurrency> updatedRankList = new ArrayList<>();

        try {

            List<CryptoCurrency> rankCrypto = cryptoCurrencyService.mostRelevantCrypto();

            List<String> rankList = new ArrayList<>();

            updatedRankList = cryptoPricesService.getMostRelevantCryptoPrice(rankCrypto, coin);

        } catch (RuntimeException e) {

            e.printStackTrace();
        }

        return ResponseEntity.ok().body(updatedRankList);
    }
}
