package pl.sdacademy.unit.test.advance.exercises.mockito.user;

public class UserService {
    private final UserRepository userRepository;
    private final UserValidator userValidator;

    public UserService(final UserRepository userRepository, final UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    public User getUserById(final Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public boolean createUser(final User user) {
        if (userValidator.isUserValid(user)) {
            return userRepository.addUser(user);
        }
        throw new IllegalArgumentException("User is invalid");
    }
}