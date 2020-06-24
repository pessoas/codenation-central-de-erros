package br.com.codenation.centraldeerros.controller;

import br.com.codenation.centraldeerros.controller.advice.ResourceNotFoundException;
import br.com.codenation.centraldeerros.entity.Log;
import br.com.codenation.centraldeerros.entity.User;
import br.com.codenation.centraldeerros.projection.UserEmailOnly;
import br.com.codenation.centraldeerros.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody User user){
        return new ResponseEntity<>(this.userService.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        User user = this.userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for ID: " + id));
        this.userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<UserEmailOnly>> getAll() {
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for ID: " + id)), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(this.userService.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for email: " + email)), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> update(@Valid @RequestBody User user) {
        return new ResponseEntity<>(this.userService.save(user), HttpStatus.ACCEPTED);
    }
}
