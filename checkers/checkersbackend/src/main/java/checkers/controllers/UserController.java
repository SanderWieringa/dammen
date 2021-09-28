package checkers.controllers;

import checkers.Logic.UserLogic;
import checkers.Model.User;
import checkers.Response.AuthenticationRequest;
import checkers.Response.AuthenticationResponse;
import checkers.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.AccessDeniedException;

@RestController
public class UserController {

    @Autowired
    private UserLogic userLogic;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping(value = "/hi")
    public String sayHello() {
        return "hoi";
    }

    @CrossOrigin("http://localhost:3000/")
    @PostMapping(value = "/register")
    public ResponseEntity<AuthenticationResponse> addUser(@RequestBody User user) {
        try {
            userLogic.addUser(user);
            return new ResponseEntity(HttpStatus.OK);
        }  catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Something went wrong"
            );
        }
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping(value="/authenticate")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            userLogic.login(authenticationRequest);
        } catch (AccessDeniedException e) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "Incorrect credentials"
            );
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Something went wrong"
            );
        }

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) userLogic.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(user);
        System.out.println(jwt);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
