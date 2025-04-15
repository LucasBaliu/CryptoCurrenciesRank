package com.conversaocripto.apirest.repository;

import com.conversaocripto.apirest.entities.CryptoPrices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoPricesRepository extends JpaRepository<CryptoPrices, String> {


}
