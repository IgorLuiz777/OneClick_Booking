package br.com.oneclick.booking.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        if (userRepository.findById(user.getId()).isPresent()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "The ID is auto increment. Don't pass it in the request body!");
        return userRepository.save(user);
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User user) {
        if (userRepository.findById(id).isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "User not found with id: " + id);
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        if (!userRepository.findById(id).isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "User not found with id: " + id);
        userRepository.deleteById(id);
    }

}
