package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.User;
import kr.co.fastcampus.eatgo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User addUser(String email, String name) {
        User user = User.builder()
                .email(email)
                .name(name)
                .level(1L)
                .build();

        return userRepository.save(user);
    }

    public User updateUser(Long id, String email, String name, Long level) {
        User user = userRepository.findById(id).orElseGet(null);

        user.setEmail(email);
        user.setName(name);
        user.setLevel(level);

        return user;
    }

    public User deactivateUser(Long id) {
        User user = userRepository.findById(id).orElseGet(null);
        user.deactivate();

        return user;
    }
}
