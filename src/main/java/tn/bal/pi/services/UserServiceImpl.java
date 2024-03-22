package tn.bal.pi.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.bal.pi.entities.User;
import tn.bal.pi.repositories.UserRepository;

@AllArgsConstructor
@Service
public class UserServiceImpl implements IUserService{
    UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
