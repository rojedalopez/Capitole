package com.rojedalopez.capitole.service.impl;

import com.rojedalopez.capitole.domain.dto.PriceDto;
import com.rojedalopez.capitole.domain.dto.PriceRequestDto;
import com.rojedalopez.capitole.domain.dto.PriceResponseDto;
import com.rojedalopez.capitole.domain.exception.PriceException;
import com.rojedalopez.capitole.domain.mapper.PriceMapper;
import com.rojedalopez.capitole.infrestructure.jpa.PriceEntity;
import com.rojedalopez.capitole.infrestructure.jpa.repositories.BrandRepository;
import com.rojedalopez.capitole.infrestructure.jpa.repositories.PriceRepository;
import com.rojedalopez.capitole.service.PriceService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.Comparator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.adapter.rxjava.RxJava3Adapter;
import reactor.core.publisher.Mono;


@Service
@Slf4j
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

  private final PriceRepository prices;
  private final BrandRepository brands;
  private final PriceMapper priceMapper;

  @Override
  public Observable<PriceDto> get() {
    return RxJava3Adapter.fluxToObservable(
            prices.findAll()
            .map(priceMapper::toDto));
  }

  @Override
  public Single<PriceResponseDto> getPrice(PriceRequestDto requestDto) {
    return RxJava3Adapter.monoToSingle(
        prices.findByFilters(requestDto.getProductId(), requestDto.getDateTime())
            .sort(Comparator.comparingInt(PriceEntity::getPriority))
            .switchIfEmpty(Mono.defer(() ->
                Mono.error(new PriceException("404","No se encuentra precio"))))
            .last()
            .flatMap(entity -> brands.findById(Long.valueOf(entity.getBrandId()))
                .map(mono -> {
                  entity.setBrand(mono);
                  return entity;
                }))
            .map(priceMapper::toResponseDto)

    );
  }
}
