package com.rojedalopez.capitole.domain.mapper;

import com.rojedalopez.capitole.domain.dto.PriceDto;
import com.rojedalopez.capitole.domain.dto.PriceResponseDto;
import com.rojedalopez.capitole.infrestructure.jpa.PriceEntity;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PriceMapper {

  @Named("toPriceDto")
  PriceDto toDto(PriceEntity entity);

  PriceResponseDto toResponseDto(PriceEntity entity);

  PriceEntity toEntity(PriceDto dto);

  @IterableMapping(qualifiedByName = "toPriceDto")
  List<PriceDto> toListDto(List<PriceEntity> entities);
}
