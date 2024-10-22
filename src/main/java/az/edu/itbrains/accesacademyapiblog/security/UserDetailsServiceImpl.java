package az.edu.itbrains.accesacademyapiblog.security;

import az.edu.itbrains.accesacademyapiblog.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        az.edu.itbrains.accesacademyapiblog.models.User user = userRepository.findByEmail(username);
        if (user != null){
            org.springframework.security.core.userdetails.User loginUser = new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    user.getRoles().stream().map(m-> new SimpleGrantedAuthority(m.getName())).collect(Collectors.toList())
            );
            return loginUser;
        }else{
            throw  new UsernameNotFoundException("User not found");
        }
    }
}
