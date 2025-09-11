package mk.ukim.finki.emc.lv1b.service.domain.impl;

import mk.ukim.finki.emc.lv1b.model.domain.User;
import mk.ukim.finki.emc.lv1b.model.enumerations.Role;
import mk.ukim.finki.emc.lv1b.repository.UserRepository;
import mk.ukim.finki.emc.lv1b.service.domain.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws RuntimeException {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException(
                username));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException(
                username));
    }

    @Override
    public User register(
            String username,
            String password,
            String repeatPassword,
            String name,
            String surname,
            Role userRole
    ) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new RuntimeException();
        if (!password.equals(repeatPassword)) throw new RuntimeException();
        if (userRepository.findByUsername(username).isPresent())
            throw new RuntimeException(username);
        User user = new User(username, passwordEncoder.encode(password), name, surname, userRole);
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new RuntimeException();
        }
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(
                RuntimeException::new);
    }

}
