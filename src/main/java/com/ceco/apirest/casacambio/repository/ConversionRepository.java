package com.ceco.apirest.casacambio.repository;

import com.ceco.apirest.casacambio.model.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionRepository extends JpaRepository<Conversion, Long> {


}
