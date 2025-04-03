package mk.ukim.finki.emc.lv1a.service.application;

import mk.ukim.finki.emc.lv1a.dto.CreateUserDto;
import mk.ukim.finki.emc.lv1a.dto.DisplayBookDto;
import mk.ukim.finki.emc.lv1a.dto.DisplayUserDto;
import mk.ukim.finki.emc.lv1a.dto.LoginUserDto;

import java.util.List;
import java.util.Optional;

public interface UserApplicationService {
    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<DisplayUserDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);

    List<DisplayBookDto> addBookToWhishlist(String username, Long bookId);

    List<DisplayBookDto> getUserWishlist(String username);

    List<DisplayBookDto> loanWishlistedBooks(String username);
}
