package microservice.users_service.controller;

import microservice.users_service.dto.UserResponseDto;
import microservice.users_service.entity.User;
import microservice.users_service.repository.UserRepository;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@RequestBody User user) {
        user.setCreatedAt(LocalDateTime.now());
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(new UserResponseDto(savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> loginUser(@RequestBody User user) {
        // Authentication logic should be here (omitted for simplicity)
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword())
                .map(foundUser -> ResponseEntity.ok(new UserResponseDto(foundUser)))
                .orElse(ResponseEntity.status(401).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> ResponseEntity.ok(new UserResponseDto(user)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(userDetails.getUsername());
                    user.setEmail(userDetails.getEmail());
                    user.setPassword(userDetails.getPassword());
                    user.setCreatedAt(LocalDateTime.now());
                    User updatedUser = userRepository.save(user);
                    return ResponseEntity.ok(new UserResponseDto(updatedUser));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
