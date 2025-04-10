package com.conversaocripto.apirest.repository;

import com.conversaocripto.apirest.entities.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, String> {
}
