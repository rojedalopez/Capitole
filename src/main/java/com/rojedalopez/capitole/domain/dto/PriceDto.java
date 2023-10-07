package com.rojedalopez.capitole.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceDto {
  private long priceList;
  private int brandId;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private String productId;
  private int priority;
  private BigDecimal price;
  private String curr;
}
