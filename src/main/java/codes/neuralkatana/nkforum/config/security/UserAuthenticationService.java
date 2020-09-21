package codes.neuralkatana.nkforum.config.security;

import codes.neuralkatana.nkforum.model.User;
import codes.neuralkatana.nkforum.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthenticationService implements UserDetailsService {

    private UserRepository repository;

    public UserAuthenticationService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(userName);
        if(user.isPresent()){
            return user.get();
        }
        throw new UsernameNotFoundException("Username or Password invalid!");
    }
}
