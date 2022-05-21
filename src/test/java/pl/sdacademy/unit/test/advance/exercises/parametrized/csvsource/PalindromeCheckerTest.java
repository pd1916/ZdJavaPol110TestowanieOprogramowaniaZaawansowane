package pl.sdacademy.unit.test.advance.exercises.parametrized.csvsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    /*
    true:
    kajak
    sedes
    kobyla ma maly bok

    false:
    programowanie
    java
    sda
    "  "
     */

    // na potrzeby nauki stworzyliśmy jedną metodę testową
    // ale normalnie powinno się zrobić dwie oddzielne dla true i false
    @ParameterizedTest
    @CsvSource({
            "kajak, true",
            "sedes, true",
            "kobyla ma maly bok, true",
            "programowanie, false",
            "java, false",
            "sda, false",
            "'  ', true"})
    void shouldVerifyIfStringIsPalindrome(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/palindrome.csv")
    void shouldVerifyIfStringIsPalindrome_CsvFileSource(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }
}