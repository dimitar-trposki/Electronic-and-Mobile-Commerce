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
        return dishRepository.findAll();
    }

    @Override
    public Optional<Dish> findById(Long id) {
        return dishRepository.findById(id);
    }

    @Override
    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Optional<Dish> update(Long id, Dish dish) {
        return dishRepository.findById(id)
                .map(existingDish -> {
                    existingDish.setName(dish.getName());
                    existingDish.setDescription(dish.getDescription());
                    existingDish.setQuantity(dish.getQuantity());
                    existingDish.setPrice(dish.getPrice());
                    existingDish.setRestaurant(dish.getRestaurant());
                    return dishRepository.save(existingDish);
                });
    }

    @Override
    public Optional<Dish> deleteById(Long id) {
        Optional<Dish> dish = dishRepository.findById(id);
        dishRepository.deleteById(id);
        return dish;
    }

    @Override
    public Order addToOrder(Dish dish, Order order) {
        if (dish.getQuantity() <= 0) {
            throw new DishOutOfStockException(dish.getId());
        }
        dish.decreaseQuantity();
        order.getDishes().add(dish);
        return orderRepository.save(order);
    }

    @Override
    public Order removeFromOrder(Dish dish, Order order) {
        dish.increaseQuantity();
        order.getDishes().remove(dish);
        return orderRepository.save(order);
    }

}
