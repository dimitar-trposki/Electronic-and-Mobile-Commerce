package mk.ukim.finki.emc.lv1a.web;

import mk.ukim.finki.emc.lv1a.model.Book;
import mk.ukim.finki.emc.lv1a.model.dto.BookDto;
import mk.ukim.finki.emc.lv1a.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto book) {
        return bookService.save(book)
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody BookDto book) {
        return bookService.update(id, book)
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (bookService.findById(id).isPresent()) {
            bookService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
