package br.pucpr.cwbshop.resource;


import br.pucpr.cwbshop.domain.entity.User;
import br.pucpr.cwbshop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "/api", tags = "User", description = "User")
public class UserResource {

    @Autowired
    private UserService userService;

    /**
     * Gets users.
     *
     * @return the users
     */
    @GetMapping("/user")
    @ApiOperation(value = "Retorna uma lista de Usuarios")
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
    @ApiOperation(value = "Cria um Usuario")
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
    @ApiOperation(value = "Atualiza um Usuario")
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
    @ApiOperation(value = "Deleta Usuario pelo ID")
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
    @ApiOperation(value = "Deleta Usuario pelo ID")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().body("User excluded ID: " + id);
    }
}
