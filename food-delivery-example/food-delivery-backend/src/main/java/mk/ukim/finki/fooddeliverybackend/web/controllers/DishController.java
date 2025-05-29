package mk.ukim.finki.fooddeliverybackend.web.controllers;

import mk.ukim.finki.fooddeliverybackend.dto.domain.CreateDishDto;
import mk.ukim.finki.fooddeliverybackend.dto.domain.DisplayDishDetailsDto;
import mk.ukim.finki.fooddeliverybackend.dto.domain.DisplayDishDto;
import mk.ukim.finki.fooddeliverybackend.dto.domain.DisplayOrderDto;
import mk.ukim.finki.fooddeliverybackend.model.domain.User;
import mk.ukim.finki.fooddeliverybackend.service.application.DishApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    private final DishApplicationService dishApplicationService;

    public DishController(
            DishApplicationService dishApplicationService
    ) {
        this.dishApplicationService = dishApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<DisplayDishDto>> findAll() {
        // TODO: Implement this.
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayDishDto> findById(@PathVariable Long id) {
        return dishApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<DisplayDishDetailsDto> findByIdWithDetails(@PathVariable Long id) {
        // TODO: Implement this.
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayDishDto> save(@RequestBody CreateDishDto createMenuItemDto) {
        // TODO: Implement this.
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayDishDto> update(@PathVariable Long id, @RequestBody CreateDishDto createMenuItemDto) {
        // TODO: Implement this.
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayDishDto> deleteById(@PathVariable Long id) {
        // TODO: Implement this.
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/add-to-order")
    public ResponseEntity<DisplayOrderDto> addToOrder(@PathVariable Long id, @AuthenticationPrincipal User user) {
        // TODO: Implement this.
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/remove-from-order")
    public ResponseEntity<DisplayOrderDto> removeFromOrder(@PathVariable Long id, @AuthenticationPrincipal User user) {
        // TODO: Implement this.
        return ResponseEntity.ok().build();
    }

}
