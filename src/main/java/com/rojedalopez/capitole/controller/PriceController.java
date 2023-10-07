package com.rojedalopez.capitole.controller;

import com.rojedalopez.capitole.domain.dto.PriceDto;
import com.rojedalopez.capitole.domain.dto.PriceRequestDto;
import com.rojedalopez.capitole.domain.dto.PriceResponseDto;
import com.rojedalopez.capitole.service.PriceService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class PriceController {
  private final PriceService priceService;

  @GetMapping
  public Flowable<PriceDto> getAll() {
    return priceService.get();
  }

  @PostMapping
  public Single<PriceResponseDto> getPrice(@RequestBody PriceRequestDto requestDto) {
    return priceService.getPrice(requestDto);
  }
}
