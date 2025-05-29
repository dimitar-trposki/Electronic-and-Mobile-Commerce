package mk.ukim.finki.fooddeliverybackend.service.application.impl;

import mk.ukim.finki.fooddeliverybackend.dto.domain.DisplayOrderDto;
import mk.ukim.finki.fooddeliverybackend.service.application.OrderApplicationService;
import mk.ukim.finki.fooddeliverybackend.service.domain.OrderService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderApplicationServiceImpl implements OrderApplicationService {

    private final OrderService orderService;

    public OrderApplicationServiceImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public DisplayOrderDto findOrCreatePending(String username) {
        // TODO: Implement this.
        return null;
    }

    @Override
    public Optional<DisplayOrderDto> confirm(String username) {
        // TODO: Implement this.
        return Optional.empty();
    }

    @Override
    public Optional<DisplayOrderDto> cancel(String username) {
        // TODO: Implement this.
        return Optional.empty();
    }

}
