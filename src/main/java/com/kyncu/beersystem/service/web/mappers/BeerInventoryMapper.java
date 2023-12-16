package com.kyncu.beersystem.service.web.mappers;

import com.kyncu.beersystem.service.domain.BeerInventory;
import com.kyncu.beersystem.brewery.model.BeerInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO);

    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
