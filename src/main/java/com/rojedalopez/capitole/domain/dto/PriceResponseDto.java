package com.rojedalopez.capitole.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PriceResponseDto {
  @JsonProperty("product_id")
  private String productId;
  @JsonProperty("brand")
  private BrandDto brand;
  private BigDecimal price;
  @JsonProperty("price_list")
  private int priceList;
  @JsonProperty("start_date")
  private LocalDateTime startDate;
  @JsonProperty("end_date")
  private LocalDateTime endDate;
}
