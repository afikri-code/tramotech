package de.tramotech;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MiscKatasTest {

    MiscKatas app = new MiscKatas();

    @ParameterizedTest
    @MethodSource("longestSubstringDataProvider")
    void longestSubstring(String s, int k, int expected) {


        int actual = app.longestSubstring(s, k);

        assertThat(actual).isEqualTo(expected);
    }

    static Collection<Object[]> longestSubstringDataProvider() {
        return List.of(new Object[][] {
                { "aabbcc", 2, 4},
                { "aabbcc", 1, 2 },
                { "aabbcc", 3, 6 },
                { "aaabbb", 3, 0 },
                { "aaabbbbcccc", 2, 8},
                { "abababba", 2, 8},
        });
    }




}