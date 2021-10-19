package checkers.controllers;

import checkers.logic.UserLogic;
import checkers.model.User;
import checkers.response.AuthenticationRequest;
import checkers.response.AuthenticationResponse;
import checkers.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.AccessDeniedException;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/account")
@RestController
public class UserController {

    @Autowired
    private UserLogic userLogic;

    @Autowired
    private JwtUtil jwtTokenUtil;

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
