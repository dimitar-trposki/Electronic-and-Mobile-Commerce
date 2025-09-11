package mk.ukim.finki.emc.lv1b.model.dto;

import mk.ukim.finki.emc.lv1b.model.domain.User;
import mk.ukim.finki.emc.lv1b.model.enumerations.Role;

public record CreateUserDto(
        String username,
        String password,
        String repeatPassword,
        String name,
        String surname,
        Role role
) {

    public User toUser() {
        return new User(username, password, name, surname, role);
    }
}

