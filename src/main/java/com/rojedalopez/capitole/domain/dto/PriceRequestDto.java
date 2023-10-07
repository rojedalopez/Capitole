package com.rojedalopez.capitole.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PriceRequestDto {
  @JsonProperty("date_time")
  private LocalDateTime dateTime;
  @JsonProperty("product_id")
  private String productId;
  @JsonProperty("brand_id")
  private long brandId;
}