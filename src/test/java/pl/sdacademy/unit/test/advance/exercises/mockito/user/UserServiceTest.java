package pl.sdacademy.unit.test.advance.exercises.mockito.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    private static final User USER = new User(1L, "Jan", "Kowalski");

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserValidator userValidator;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnUserById() {
        //given
        when(userRepository.findById(any())).thenReturn(Optional.of(USER));
        //when
        User result = userService.getUserById(5L);
        //then
        assertThat(result).isEqualTo(USER);
    }

    @Test
    void shouldThrowExceptionWhenUserNotExist() {
        //given
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        //when & then
        assertThatThrownBy(() -> userService.getUserById(1L))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void shouldCreateUser() {
        //given
        when(userValidator.isUserValid(any())).thenReturn(true);
        when(userRepository.addUser(any())).thenReturn(true);
        //when
        boolean result = userService.createUser(USER);
        //then
        assertThat(result).isTrue();
    }

    @Test
    void shouldThrowExceptionWhenUserIsNotValid() {
        //given
        when(userValidator.isUserValid(any())).thenReturn(false);
        //when & then
        assertThatThrownBy(() -> userService.createUser(USER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User is invalid");
        verifyNoInteractions(userRepository);
    }

}