package com.conversaocripto.apirest;

import com.conversaocripto.apirest.entities.CryptoCurrency;
import com.conversaocripto.apirest.entities.CryptoPrices;
import com.conversaocripto.apirest.service.CryptoCurrencyService;
import com.conversaocripto.apirest.service.CryptoPricesService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class RankCriptoMoedasApplication {
	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(RankCriptoMoedasApplication.class, args);

    }
}
