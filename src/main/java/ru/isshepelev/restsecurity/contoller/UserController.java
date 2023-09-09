package ru.isshepelev.restsecurity.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.isshepelev.restsecurity.entity.UserRequest;
import ru.isshepelev.restsecurity.entity.Users;
import ru.isshepelev.restsecurity.repository.UserRepository;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRequest userRequest) {
        if (userRepository.findByUsername(userRequest.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Пользователь с таким именем уже существует");
        }

        String encodedPassword = passwordEncoder.encode(userRequest.getPassword());

        Users newUser = new Users();
        newUser.setUsername(userRequest.getUsername());
        newUser.setPassword(encodedPassword);

        userRepository.save(newUser);

        return ResponseEntity.ok("Пользователь успешно зарегистрирован");
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Привет, мир!");
    }
    @GetMapping("/bye")
    public ResponseEntity<String> bye() {
        return ResponseEntity.ok("Пока, мир!");
    }
    @GetMapping("/")
    public ResponseEntity<String> howAreYou() {
        return ResponseEntity.ok("Как ты?!");
    }
}
