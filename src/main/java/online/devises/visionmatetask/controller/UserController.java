package online.devises.visionmatetask.controller;

import online.devises.visionmatetask.model.User;
import online.devises.visionmatetask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    @ResponseBody
    public Iterable<User> getAllUsers() {
        return userService.getUsers();
    }

    @PostMapping("/users")
    @ResponseBody
    public void createUser(@RequestBody User user)
    {
        userService.createUser(user);
    }

    @DeleteMapping("/users/{userId}")
    @ResponseBody
    public void deleteUser(@PathVariable Integer userId)
    {
        userService.deleteUser(userId);
    }

    @PutMapping("/users/{userId}")
    @ResponseBody
    public void updateUser(@PathVariable Integer userId, @RequestBody User user)
    {
        userService.updateUser(userId, user);
    }
}
