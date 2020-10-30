package online.devises.visionmatetask.service;

import online.devises.visionmatetask.model.User;
import online.devises.visionmatetask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getUsers() {

        return userRepository.findAll();
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    public void updateUser(Integer userId, User user) {
        userRepository.findById(userId)
                .map(oldRole -> {
                    oldRole.setLogin(user.getLogin());
                    oldRole.setPassword(user.getPassword());
                    oldRole.setRole(user.getRole());
                    return userRepository.save(oldRole);
                })
                .orElseGet(() -> {
                    user.setId(userId);
                    return userRepository.save(user);
                });
    }
}
