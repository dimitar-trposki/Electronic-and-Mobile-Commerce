package mk.ukim.finki.emc.lv1a.service.application.impl;

import mk.ukim.finki.emc.lv1a.dto.CreateUserDto;
import mk.ukim.finki.emc.lv1a.dto.DisplayBookDto;
import mk.ukim.finki.emc.lv1a.dto.DisplayUserDto;
import mk.ukim.finki.emc.lv1a.dto.LoginUserDto;
import mk.ukim.finki.emc.lv1a.model.domain.Book;
import mk.ukim.finki.emc.lv1a.model.domain.User;
import mk.ukim.finki.emc.lv1a.service.application.UserApplicationService;
import mk.ukim.finki.emc.lv1a.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {
    private final UserService userService;

    public UserApplicationServiceImpl(UserService userService) {
        this.userService = userService;
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
    public Optional<DisplayUserDto> login(LoginUserDto loginUserDto) {
        return Optional.of(DisplayUserDto.from(userService.login(
                loginUserDto.username(),
                loginUserDto.password()
        )));
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

