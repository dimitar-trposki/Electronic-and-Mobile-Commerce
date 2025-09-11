package mk.ukim.finki.emc.lv1b.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.emc.lv1b.model.domain.User;
import mk.ukim.finki.emc.lv1b.model.dto.BookingDto;
import mk.ukim.finki.emc.lv1b.service.application.BookingApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
@Tag(name = "Booking API", description = "Endpoints for managing the booking")
public class BookingController {

    private final BookingApplicationService bookingApplicationService;

    public BookingController(BookingApplicationService bookingApplicationService) {
        this.bookingApplicationService = bookingApplicationService;
    }

    @Operation(
            summary = "Get active booking",
            description = "Retrieves the active booking for the logged-in user"
    )
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "Booking retrieved successfully"
            ), @ApiResponse(responseCode = "404", description = "Booking not found")}
    )
    @GetMapping
    public ResponseEntity<BookingDto> getActiveShoppingCart(HttpServletRequest req) {
        String username = req.getRemoteUser();
        return bookingApplicationService.getActiveBooking(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Add accommodation to booking.",
            description = "Adds an accommodation to the booking for the logged-in user"
    )
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200", description = "Accommodation added to booking successfully"
            ), @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            ), @ApiResponse(responseCode = "404", description = "Accommodation not found")}
    )
    @PostMapping("/add-product/{id}")
    public ResponseEntity<BookingDto> addProductToShoppingCart(
            @PathVariable Long id,
            Authentication authentication
    ) {
        try {
            User user = (User) authentication.getPrincipal();
            return bookingApplicationService.addAccommodationToBooking(user.getUsername(), id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Void> bookBooking(Authentication authentication) {
        try {
            User user = (User) authentication.getPrincipal();
            bookingApplicationService.bookBooking(user.getUsername());
            return ResponseEntity.ok().build();
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Void> cancelBooking(Authentication authentication) {
        try {
            User user = (User) authentication.getPrincipal();
            bookingApplicationService.cancelBooking(user.getUsername());
            return ResponseEntity.ok().build();
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }
    }
}
