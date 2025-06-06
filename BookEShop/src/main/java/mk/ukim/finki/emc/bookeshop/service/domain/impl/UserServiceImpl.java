package mk.ukim.finki.emc.bookeshop.service.domain.impl;

import mk.ukim.finki.emc.bookeshop.model.domain.User;
import mk.ukim.finki.emc.bookeshop.model.enumerations.Role;
import mk.ukim.finki.emc.bookeshop.repository.UserRepository;
import mk.ukim.finki.emc.bookeshop.service.domain.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                username));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
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
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException(username));
        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new RuntimeException();
        return user;
    }

}
