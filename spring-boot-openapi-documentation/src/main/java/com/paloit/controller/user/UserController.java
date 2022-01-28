package com.paloit.controller.user;

import com.paloit.controller.user.model.ErrorModel;
import com.paloit.controller.user.model.User;
import com.paloit.controller.user.util.UserHelper;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController implements UserApi {

    private Map<Long, User> users;

    UserController() {
        users = new ConcurrentHashMap<>();
        for(int i=0; i<5; i++) {
            var generatedUser = UserHelper.generateUser();
            users.put(generatedUser.getId(), generatedUser);
        }
    }

    @GetMapping(
        value = "/users",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(
            users.values().stream().collect(Collectors.toList())
        );
    }

    @GetMapping(
        value = "/users/{userId}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        var user = users.get(userId);
        if(user != null) {
            return ResponseEntity.ok(user);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(
        value = "/users/{userId}"
    )
    @Override
    public ResponseEntity<User> deleteUserById(@PathVariable Long userId) {
        if(users.containsKey(userId)) {
            users.remove(userId);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(
        value = "/users",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        user.setId(UserHelper.generateRandomUserId());
        users.put(user.getId(), user);
        return ResponseEntity.ok(user);
    }

    @PutMapping(
        value = "/users/{userId}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public ResponseEntity<User> updateUserById(@PathVariable Long userId, @Valid @RequestBody User userUpdate) {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }
}
