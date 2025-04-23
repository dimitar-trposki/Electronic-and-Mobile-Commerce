package mk.ukim.finki.emc.lv1a.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.emc.lv1a.dto.*;
import mk.ukim.finki.emc.lv1a.service.application.UserApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User API", description = "Endpoints for user authentication and registration")
public class UserController {
    private final UserApplicationService userApplicationService;

    public UserController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @Operation(summary = "Register a new user", description = "Creates a new user account")
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "User registered successfully"
            ), @ApiResponse(
                    responseCode = "400", description = "Invalid input or passwords do not match"
            )}
    )
    @PostMapping("/register")
    public ResponseEntity<DisplayUserDto> register(@RequestBody CreateUserDto createUserDto) {
        try {
            return userApplicationService.register(createUserDto)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "User login", description = "Authenticates a user and starts a session")
    @ApiResponses(
            value = {@ApiResponse(
                    responseCode = "200",
                    description = "User authenticated successfully"
            ), @ApiResponse(responseCode = "404", description = "Invalid username or password")}
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginUserDto loginUserDto) {
        try {
            return userApplicationService.login(loginUserDto)
                    .map(ResponseEntity::ok)
                    .orElseThrow(RuntimeException::new);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

//    @Operation(summary = "User logout", description = "Ends the user's session")
//    @ApiResponse(responseCode = "200", description = "User logged out successfully")
//    @GetMapping("/logout")
//    public void logout(HttpServletRequest request) {
//        request.getSession().invalidate();
//    }

    @Operation(summary = "User wishlist")
    @GetMapping("/my_wishlist")
    public List<DisplayBookDto> getUserWishlist() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userApplicationService.getUserWishlist(username);
        //return userApplicationService.getUserWishlist(username);
    }

    @Operation(summary = "Add book to wishlist")
    @PostMapping("/add_to_wishlist")
    public List<DisplayBookDto> addBookToWhishlist(@RequestBody Long bookId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userApplicationService.addBookToWhishlist(username, bookId);
        //        return userApplicationService.addBookToWhishlist(username, bookId);
    }

    @Operation(summary = "Loan wishlisted books")
    @GetMapping("/loan_wishlist")
    public List<DisplayBookDto> loanUserWishlist() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userApplicationService.loanWishlistedBooks(username);
        //return userApplicationService.loanWishlistedBooks(username);
    }
}
