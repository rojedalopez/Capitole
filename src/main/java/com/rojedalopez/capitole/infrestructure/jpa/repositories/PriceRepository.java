package com.rojedalopez.capitole.infrestructure.jpa.repositories;

import com.rojedalopez.capitole.infrestructure.jpa.PriceEntity;
import java.time.LocalDateTime;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;

public interface PriceRepository extends R2dbcRepository<PriceEntity, Long> {
  @Query("select a.* from prices a where a.product_id = :productId "
      + "and :dateTime between a.start_date and a.end_date ")
  Flux<PriceEntity> findByFilters(
      @Param("productId") String productId,
      @Param("dateTime") LocalDateTime dateTime);
}
