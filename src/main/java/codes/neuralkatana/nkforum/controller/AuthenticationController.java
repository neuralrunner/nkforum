package codes.neuralkatana.nkforum.controller;

import codes.neuralkatana.nkforum.config.security.TokenService;
import codes.neuralkatana.nkforum.dto.TokenDTO;
import codes.neuralkatana.nkforum.form.LoginForm;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Profile("prod")
public class AuthenticationController {

    private final AuthenticationManager authManager;

    private final TokenService tokenService;

    public AuthenticationController(AuthenticationManager authManager, TokenService tokenService) {
        this.authManager = authManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<TokenDTO> authenticate(@RequestBody @Valid LoginForm form){
        //Converts a LoginForm to a UsernamePasswordAuthenticationToken object
        UsernamePasswordAuthenticationToken loginData = form.converter();
        try{
            Authentication authentication = authManager.authenticate(loginData);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
        }catch (AuthenticationException e){
            //in case not authenticated, creates a badRequest
            return ResponseEntity.badRequest().build();
        }
    }
}
