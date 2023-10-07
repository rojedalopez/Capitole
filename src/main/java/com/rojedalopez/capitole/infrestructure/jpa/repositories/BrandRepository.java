package com.rojedalopez.capitole.infrestructure.jpa.repositories;

import com.rojedalopez.capitole.infrestructure.jpa.BrandEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface BrandRepository extends R2dbcRepository<BrandEntity, Long> {
}
