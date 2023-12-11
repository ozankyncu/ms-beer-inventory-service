package com.kyncu.beersystem.service.services;

import com.kyncu.beersystem.brewery.model.events.AllocateOrderRequest;
import com.kyncu.beersystem.brewery.model.events.AllocateOrderResult;
import com.kyncu.beersystem.service.config.JmsConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class AllocationListener {
    private final AllocationService allocationService;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.ALLOCATE_ORDER_QUEUE)
    private void listen(AllocateOrderRequest request) {
        AllocateOrderResult.AllocateOrderResultBuilder builder = AllocateOrderResult.builder();
        builder.beerOrderDto(request.getBeerOrderDto());

        try {
            Boolean allocationResult = allocationService.allocateOrder(request.getBeerOrderDto());
            if (allocationResult) {
                builder.pendingInventory(false);
            } else {
                builder.pendingInventory(true);
            }
            builder.allocationError(false);
        }catch (Exception e) {
            log.error("Allocation failed for Order Id: " + request.getBeerOrderDto().getId());
            builder.allocationError(true);
        }

        jmsTemplate.convertAndSend(JmsConfig.ALLOCATE_ORDER_RESPONSE_QUEUE,
                builder.build());

    }
}
