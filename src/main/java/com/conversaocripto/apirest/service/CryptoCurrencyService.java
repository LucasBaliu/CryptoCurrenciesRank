package com.conversaocripto.apirest.service;

import com.conversaocripto.apirest.entities.CryptoCurrency;
import com.conversaocripto.apirest.entities.CryptoPrices;
import com.conversaocripto.apirest.repository.CryptoCurrencyRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CryptoCurrencyService {

    private CryptoCurrencyRepository cryptoCurrencyRepository;

    List<CryptoCurrency> cryptoCurrencyList = new ArrayList<>();

    CryptoPrices cryptoPrices = new CryptoPrices();

    public List<CryptoCurrency> mostRelevantCrypto() throws IOException, InterruptedException {

        List<CryptoCurrency> top10 = new ArrayList<>();

        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.coinpaprika.com/v1/coins")).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            cryptoCurrencyList = mapper.readValue(response.body(), new TypeReference<List<CryptoCurrency>>() {});

            top10 = cryptoCurrencyList.stream().limit(10).toList();

        } catch(Exception e){

            System.out.println(e.getMessage());;
        }

        return top10;
    }

    public List<String> getAllSymbolsOne(List<CryptoCurrency> cryptoCurrencyList) {

        List<String> list = new ArrayList<>();

        list.addAll(cryptoCurrencyList.stream().map(CryptoCurrency::getSymbol).toList());

        return list;
    }
}
