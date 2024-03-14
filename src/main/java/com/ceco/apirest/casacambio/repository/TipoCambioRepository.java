package com.ceco.apirest.casacambio.repository;

import com.ceco.apirest.casacambio.model.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambio, Long> {

    @Query("SELECT tc.valorCambio FROM TipoCambio  tc WHERE tc.Pais = :monedaDestino")
   Double findTipoCambioBy(@Param("monedaDestino") String monedaDestino);
}
