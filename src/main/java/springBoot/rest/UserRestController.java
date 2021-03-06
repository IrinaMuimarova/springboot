package springBoot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springBoot.model.User;
import springBoot.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    // autowire the UserService
    @Autowired
    private UserService userService;

    //add mapping for GET / users

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    // add mapping for GET /users/{userID}

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    // add mapping for POST /users - add new User

    @PostMapping("/users")
    public ResponseEntity<User> addCustomer(@RequestBody User theUser) {
        userService.saveUser(theUser);
        return new ResponseEntity<>(theUser, HttpStatus.OK);
    }

    // add mapping for PUT /users - update existing user
    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User theUser) {
        userService.existUser(theUser.getId());
        userService.saveUser(theUser);
        return new ResponseEntity<>(theUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.existUser(userId);
        userService.deleteUser(userId);
        return new ResponseEntity<>("Delete user id - " + userId, HttpStatus.OK);
    }

    @GetMapping("/users/auth/{login}")
    public ResponseEntity<User> getUserByLogin(@PathVariable String login) {
        return new ResponseEntity<>(userService.getUserByLogin(login), HttpStatus.OK);
    }
}
