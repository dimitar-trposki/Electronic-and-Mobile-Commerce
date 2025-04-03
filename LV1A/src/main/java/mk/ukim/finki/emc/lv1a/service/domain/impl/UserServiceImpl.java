package mk.ukim.finki.emc.lv1a.service.domain.impl;

import mk.ukim.finki.emc.lv1a.model.domain.Book;
import mk.ukim.finki.emc.lv1a.model.domain.User;
import mk.ukim.finki.emc.lv1a.model.enumerations.Role;
import mk.ukim.finki.emc.lv1a.repository.UserRepository;
import mk.ukim.finki.emc.lv1a.service.domain.BookService;
import mk.ukim.finki.emc.lv1a.service.domain.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final BookService bookService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, BookService bookService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.bookService = bookService;
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
    public List<Book> addBookToWhishlist(String username, Long bookId) {
        Book book = bookService.findById(bookId).get();
        User user = findByUsername(username);
        if (book.getAvailableCopies() >= 1) {
            user.getWishlistBooks().add(book);
            userRepository.save(user);
            return user.getWishlistBooks();
        }
        throw new RuntimeException("Book could not be added to user. No available copies found.");
    }

    @Override
    public List<Book> getUserWishlist(String username) {
        return userRepository.findByUsername(username).get().getWishlistBooks();
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
            throw new RuntimeException("Username or password cannot be empty");
        if (!password.equals(repeatPassword)) throw new RuntimeException("Passwords do not match");
        if (userRepository.findByUsername(username).isPresent())
            throw new RuntimeException("Username is already in use");
        User user = new User(username, passwordEncoder.encode(password), name, surname, userRole);
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new RuntimeException("Username or password cannot be empty");
        }
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(
                RuntimeException::new);
    }

}
