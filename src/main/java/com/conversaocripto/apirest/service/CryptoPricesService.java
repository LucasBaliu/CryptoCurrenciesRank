package com.conversaocripto.apirest.service;

import com.conversaocripto.apirest.entities.CryptoCurrency;
import com.conversaocripto.apirest.entities.CryptoPrices;
import com.conversaocripto.apirest.repository.CryptoCurrencyRepository;
import com.conversaocripto.apirest.repository.CryptoPricesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CryptoPricesService {

    public List<String> getAllSymbolsOne(List<CryptoCurrency> cryptoCurrencyList) {

        List<String> list = new ArrayList<>();

        list.addAll(cryptoCurrencyList.stream().map(CryptoCurrency::getSymbol).toList());

        return list;
    }

    public List<CryptoCurrency> getMostRelevantCryptoPrice(List<CryptoCurrency> cryptoCurrency, String coin){

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.coinlayer.com/live?access_key=e900d6ef4950e9f14c4d0c9fab59c5c0&" +
                            "target=" + coin + "&symbols=" + String.join("," , getAllSymbolsOne(cryptoCurrency)))).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            CryptoPrices cryptoPrices = mapper.readValue(response.body(), CryptoPrices.class);

            for (CryptoCurrency object : cryptoCurrency) {

                object.setPrice(cryptoPrices.getRates().get(object.getSymbol()));
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return cryptoCurrency;
    }
}
