package mk.ukim.finki.emc.lv1a.web;

import mk.ukim.finki.emc.lv1a.model.Country;
import mk.ukim.finki.emc.lv1a.model.dto.CountryDto;
import mk.ukim.finki.emc.lv1a.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> findAll() {
        return countryService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Country> save(@RequestBody CountryDto country) {
        return countryService.save(country)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id) {
        return countryService.findById(id)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> update(@PathVariable Long id, @RequestBody CountryDto country) {
        return countryService.update(id, country)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (countryService.findById(id).isPresent()) {
            countryService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
