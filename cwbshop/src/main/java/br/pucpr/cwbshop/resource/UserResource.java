package br.pucpr.cwbshop.resource;


import br.pucpr.cwbshop.domain.entity.User;
import br.pucpr.cwbshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The type User resource.
 */
@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    private UserService userService;

    /**
     * Gets users.
     *
     * @return the users
     */
    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.findAll();
    }

    /**
     * Save response entity.
     *
     * @param user the user
     * @return the response entity
     */
    @PostMapping("/user")
    public ResponseEntity<User>
    save(@Valid @RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok(user);
    }


    /**
     * Update response entity.
     *
     * @param user the user
     * @return the response entity
     */
    @PutMapping("/user")
    public ResponseEntity update(@Valid @RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok().body(user);
    }


    /**
     * Delete response entity.
     *
     * @param user the user
     * @return the response entity
     */
    @DeleteMapping("/user")
    public ResponseEntity<String> delete(@Valid @RequestBody User user) {
        userService.delete(user);
        return  ResponseEntity.ok().body("User excluded ID: " + user.getId());

    }

    /**
     * Delete by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().body("User excluded ID: " + id);
    }
}
