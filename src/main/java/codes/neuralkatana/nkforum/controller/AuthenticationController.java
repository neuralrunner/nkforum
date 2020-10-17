package codes.neuralkatana.nkforum.controller;

import codes.neuralkatana.nkforum.config.security.TokenService;
import codes.neuralkatana.nkforum.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody @Valid LoginForm form){
        UsernamePasswordAuthenticationToken loginData = form.converter();
        try{
            Authentication authentication = authManager.authenticate(loginData);
            String token = tokenService.generateToken(authentication);
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }
}
