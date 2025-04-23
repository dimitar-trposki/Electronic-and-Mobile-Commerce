package mk.ukim.finki.emc.lv1a.service.application.impl;

import mk.ukim.finki.emc.lv1a.dto.*;
import mk.ukim.finki.emc.lv1a.model.domain.Book;
import mk.ukim.finki.emc.lv1a.model.domain.User;
import mk.ukim.finki.emc.lv1a.service.application.UserApplicationService;
import mk.ukim.finki.emc.lv1a.service.domain.UserService;
import org.springframework.stereotype.Service;
import mk.ukim.finki.emc.lv1a.security.JwtHelper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {
    private final UserService userService;
    private final JwtHelper jwtHelper;

    public UserApplicationServiceImpl(UserService userService, JwtHelper jwtHelper) {
        this.userService = userService;
        this.jwtHelper = jwtHelper;
    }

    @Override
    public Optional<DisplayUserDto> register(CreateUserDto createUserDto) {
        User user = userService.register(
                createUserDto.username(),
                createUserDto.password(),
                createUserDto.repeatPassword(),
                createUserDto.name(),
                createUserDto.surname(),
                createUserDto.role()
        );
        return Optional.of(DisplayUserDto.from(user));
    }

    @Override
    public Optional<LoginResponseDto> login(LoginUserDto loginUserDto) {
        User user = userService.login(
                loginUserDto.username(),
                loginUserDto.password()
        );

        String token = jwtHelper.generateToken(user);

        return Optional.of(new LoginResponseDto(token));
    }

    @Override
    public Optional<DisplayUserDto> findByUsername(String username) {
        return Optional.of(DisplayUserDto.from(userService.findByUsername(username)));
    }

    @Override
    public List<DisplayBookDto> addBookToWhishlist(String username, Long bookId) {
        User user = userService.findByUsername(username);
        userService.addBookToWhishlist(username, bookId);
        List<Book> books = user.getWishlistBooks();
        return books.stream().map(DisplayBookDto::from).collect(Collectors.toList());
    }

    @Override
    public List<DisplayBookDto> getUserWishlist(String username) {
        return userService.getUserWishlist(username).stream().map(DisplayBookDto::from).collect(Collectors.toList());
    }

    @Override
    public List<DisplayBookDto> loanWishlistedBooks(String username) {
        return List.of();
    }

}

