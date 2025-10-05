package com.userService.UserService.impl;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String user) {
        return userRepository.findById(user)
                .orElseThrow(() -> new ResourceNotFoundException("User with given id not found on server !! " + user));
    }
}