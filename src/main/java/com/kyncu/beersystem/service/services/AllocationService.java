package com.kyncu.beersystem.service.services;


import com.kyncu.beersystem.brewery.model.BeerOrderDto;

public interface AllocationService {
    Boolean allocateOrder(BeerOrderDto beerOrderDto);
}
