package pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    /*
    0, 0
    1, 1
    4, 3
    6, 8
    8, 21
     */

    @ParameterizedTest
    @MethodSource("pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource.provider.FibonacciProviderData#provideData")
    void shouldReturnCorrectValue(int index, int expectedResult) {
        //when
        int result = Fibonacci.getValueFromIndex(index);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

}