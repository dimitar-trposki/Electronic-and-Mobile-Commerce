package mk.ukim.finki.fooddeliverybackend.service.domain.impl;

import mk.ukim.finki.fooddeliverybackend.model.domain.Dish;
import mk.ukim.finki.fooddeliverybackend.model.domain.Order;
import mk.ukim.finki.fooddeliverybackend.model.exceptions.DishOutOfStockException;
import mk.ukim.finki.fooddeliverybackend.repository.DishRepository;
import mk.ukim.finki.fooddeliverybackend.repository.OrderRepository;
import mk.ukim.finki.fooddeliverybackend.service.domain.DishService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    private final OrderRepository orderRepository;

    public DishServiceImpl(DishRepository dishRepository, OrderRepository orderRepository) {
        this.dishRepository = dishRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Dish> findAll() {
        // TODO: Implement this.
        return new ArrayList<>();
    }

    @Override
    public Optional<Dish> findById(Long id) {
        return dishRepository.findById(id);
    }

    @Override
    public Dish save(Dish dish) {
        // TODO: Implement this.
        return null;
    }

    @Override
    public Optional<Dish> update(Long id, Dish dish) {
        // TODO: Implement this.
        return Optional.empty();
    }

    @Override
    public Optional<Dish> deleteById(Long id) {
        // TODO: Implement this.
        return Optional.empty();
    }

    @Override
    public Order addToOrder(Dish dish, Order order) {
        // TODO: Implement this.
        return null;
    }

    @Override
    public Order removeFromOrder(Dish dish, Order order) {
        // TODO: Implement this.
        return null;
    }

}
