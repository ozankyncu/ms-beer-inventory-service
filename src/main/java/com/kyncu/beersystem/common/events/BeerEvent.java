package com.kyncu.beersystem.common.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeerEvent implements Serializable {

    static final long serialVersionUID = -5781515597148163111L;

    private BeerDto beerDto;
}
