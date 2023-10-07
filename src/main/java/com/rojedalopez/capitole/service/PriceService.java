package com.rojedalopez.capitole.service;

import com.rojedalopez.capitole.domain.dto.PriceDto;
import com.rojedalopez.capitole.domain.dto.PriceRequestDto;
import com.rojedalopez.capitole.domain.dto.PriceResponseDto;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

public interface PriceService {
  Flowable<PriceDto> get();

  Single<PriceResponseDto> getPrice(PriceRequestDto requestDto);
}
