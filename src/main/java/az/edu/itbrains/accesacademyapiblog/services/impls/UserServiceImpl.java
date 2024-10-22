package az.edu.itbrains.accesacademyapiblog.services.impls;

import az.edu.itbrains.accesacademyapiblog.models.User;
import az.edu.itbrains.accesacademyapiblog.repositories.UserRepository;
import az.edu.itbrains.accesacademyapiblog.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByEmail(String email) {
        User user= userRepository.findByEmail(email);
        return user;
    }
}
