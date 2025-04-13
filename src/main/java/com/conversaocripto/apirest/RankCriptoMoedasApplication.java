package com.conversaocripto.apirest;

import com.conversaocripto.apirest.entities.CryptoCurrency;
import com.conversaocripto.apirest.service.CryptoCurrencyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class RankCriptoMoedasApplication {

	public static void main(String[] args) {
		SpringApplication.run(RankCriptoMoedasApplication.class, args);

		CryptoCurrencyService cryptoCurrencyService = new CryptoCurrencyService();

		try{

			List<CryptoCurrency> cryptoCurrency = cryptoCurrencyService.mostRelevantCrypto();
			System.out.println(cryptoCurrency);


		}catch(IOException e){

			throw new RuntimeException(e);

		} catch(InterruptedException e){

			throw new RuntimeException(e);
		}



	}

}
