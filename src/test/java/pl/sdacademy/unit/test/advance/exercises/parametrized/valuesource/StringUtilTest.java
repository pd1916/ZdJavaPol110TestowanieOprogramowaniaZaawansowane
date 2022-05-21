package pl.sdacademy.unit.test.advance.exercises.parametrized.valuesource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    /*
    true:
    null
    ""
    " "

    false:
    programowanie
    " a "
     */

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     "})
    void shouldReturnTrueIfStringIsBlank(String input){
        //when
        boolean result = StringUtil.isBlank(input);
        //then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"programowanie", " java", "java ", " java "})
    void shouldReturnFalseIfStringIsNotBlank(String input){
        //when
        boolean result = StringUtil.isBlank(input);
        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnTrueIfStringIsNull() {
        //given
        String input = null;
        //when
        boolean result = StringUtil.isBlank(input);
        //then
        assertThat(result).isTrue();
    }
}