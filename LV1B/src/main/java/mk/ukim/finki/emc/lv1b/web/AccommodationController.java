package mk.ukim.finki.emc.lv1b.web;

import mk.ukim.finki.emc.lv1b.model.Accommodation;
import mk.ukim.finki.emc.lv1b.model.dto.AccommodationDto;
import mk.ukim.finki.emc.lv1b.service.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {

    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping
    public List<Accommodation> findAll() {
        return accommodationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> findById(@PathVariable Long id) {
        return accommodationService.findById(id)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Accommodation> add(@RequestBody AccommodationDto accommodationDto) {
        return accommodationService.save(accommodationDto)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Accommodation> update(@PathVariable Long id, @RequestBody AccommodationDto accommodationDto) {
        return accommodationService.update(id, accommodationDto)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Accommodation> delete(@PathVariable Long id) {
        if (accommodationService.findById(id).isPresent()) {
            accommodationService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/rent/{id}")
    public ResponseEntity<Accommodation> rent(@PathVariable Long id) {
        accommodationService.rented(id);
        return ResponseEntity.ok().build();
    }
}
