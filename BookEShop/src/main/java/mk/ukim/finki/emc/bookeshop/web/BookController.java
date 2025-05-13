package mk.ukim.finki.emc.bookeshop.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.ukim.finki.emc.bookeshop.dto.CreateBookDto;
import mk.ukim.finki.emc.bookeshop.dto.DisplayBookDto;
import mk.ukim.finki.emc.bookeshop.service.application.BookApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book API", description = "Endpoints for managing books")
public class BookController {

    private final BookApplicationService bookApplicationService;

    public BookController(BookApplicationService bookApplicationService) {
        this.bookApplicationService = bookApplicationService;
    }

    @Operation(
            summary = "Get all books",
            description = "Retrieves a list of all available books."
    )
    @GetMapping
    public List<DisplayBookDto> findAll() {
        return bookApplicationService.findAll();
    }

    @Operation(summary = "Add a new book", description = "Creates a new book.")
    @PostMapping("/add")
    public ResponseEntity<DisplayBookDto> save(@RequestBody CreateBookDto book) {
        return bookApplicationService.save(book)
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get book by ID", description = "Finds a book by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<DisplayBookDto> findById(@PathVariable Long id) {
        return bookApplicationService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update an existing book", description = "Updates a book by ID.")
    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayBookDto> update(@PathVariable Long id, @RequestBody CreateBookDto book) {
        return bookApplicationService.update(id, book)
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a book", description = "Deletes a book by its ID.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (bookApplicationService.findById(id).isPresent()) {
            bookApplicationService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(
            summary = "Get top 10 newest books",
            description = "Retrieves a list of the top 10 books by date created in descending order."
    )
    @GetMapping("/findTopTenBooks")
    public List<DisplayBookDto> findTopTenBooks() {
        return bookApplicationService.findTopTenBooks();
    }

}