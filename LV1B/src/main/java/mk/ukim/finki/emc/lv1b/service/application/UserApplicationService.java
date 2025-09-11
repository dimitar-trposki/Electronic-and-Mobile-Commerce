package mk.ukim.finki.emc.lv1b.service.application;

import mk.ukim.finki.emc.lv1b.model.dto.CreateUserDto;
import mk.ukim.finki.emc.lv1b.model.dto.DisplayUserDto;
import mk.ukim.finki.emc.lv1b.model.dto.LoginUserDto;

import java.util.Optional;

public interface UserApplicationService {

    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<DisplayUserDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);

}
