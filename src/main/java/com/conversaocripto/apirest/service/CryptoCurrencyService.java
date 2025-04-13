package com.conversaocripto.apirest.service;

import com.conversaocripto.apirest.entities.CryptoCurrency;
import com.conversaocripto.apirest.repository.CryptoCurrencyRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CryptoCurrencyService {

    private CryptoCurrencyRepository cryptoCurrencyRepository;

    List<CryptoCurrency> cryptoCurrencyList = new ArrayList<>();

    public List<CryptoCurrency> mostRelevantCrypto() throws IOException, InterruptedException {

        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.coinpaprika.com/v1/coins")).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            cryptoCurrencyList = mapper.readValue(response.body(), new TypeReference<List<CryptoCurrency>>() {});

        } catch(Exception e){

            System.out.println(e.getMessage());;
        }

        return cryptoCurrencyList.stream().limit(10).toList();
    }
}
