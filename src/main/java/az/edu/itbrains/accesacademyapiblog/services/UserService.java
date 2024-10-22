package az.edu.itbrains.accesacademyapiblog.services;

import az.edu.itbrains.accesacademyapiblog.models.User;

public interface UserService {
    User getUserByEmail(String email);
}
