package pl.sdacademy.unit.test.advance.exercises.task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {
    private static final Animal ANIMAL = new Animal(1L, "mammal", "cat");

    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AnimalService animalService;

    @Test
    void shouldReturnAnimalById() {
        //given
        when(animalRepository.findById(anyLong())).thenReturn(Optional.of(ANIMAL));
        //when
        Animal result = animalService.getById(1L);
        //then
        assertThat(result).isEqualTo(ANIMAL);
    }

    @Test
    void shouldThrowExceptionWhenUserNotExist() {
        //given
        when(animalRepository.findById(anyLong())).thenReturn(Optional.empty());
        //when & then
        assertThatThrownBy(() -> animalService.getById(2L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Animal not exist with id 2");
    }

    @Test
    void shouldAddAnimal() {
        //given
        when(animalRepository.add(any())).thenReturn(ANIMAL);
        //when
        Animal result = animalService.add("mammal", "cat");
        //then
        assertThat(result).isEqualTo(ANIMAL);
    }

}