package com.playtika.fourth.hw;

import com.playtika.fourth.hw.Text;
import org.junit.Before;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;



public class TextTest {

    private Text text;
    private String txt = "! x y z a Andrew a A b c !";

    @Before
    public void setUp() throws Exception {
        text = new Text(txt);
    }

    @Test
    public void shouldReturnTopUniqueWordsOrderedAlphabetically() {
        assertThat(text.getTopWords(5)).containsSequence("a", "andrew", "b", "c", "x")
                .hasSize(5);
    }


    @Test
    public void shouldThrownExceptionIfCountZeroAndLess() {
        assertThatThrownBy(() -> text.getTopWords(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("returnedCountOfTopWords can not be 0 or less");
    }

    @Test
    public void shouldReturnOnlyWordsForGetTopWords() {
        String txt = ".1. 2, 3! 4? |' [ ] s32 3 dda 2 a1 3f s123 !";

        assertThat(new Text(txt).getTopWords(1))
                .doesNotContain(".", ",", "!", "1", "}", "[", "4?", ".1.");
    }

    @Test
    public void shouldContainLowerCaseWordsOnly() {

        assertThat(text.getTopWords(5)).doesNotContain("A");
    }

    @Test
    public void shouldReturnCorrectLenght() {
        assertThat(text.getLengthInChars()).isEqualTo(14);
    }

    @Test
    public void shouldNotCountLengthOfSpecificSymbolsAndNumbers() {
        assertThat(new Text(". $a,./{}%    !  ? 1 2 2? ").getLengthInChars()).isEqualTo(1);
    }

    @Test
    public void shouldNotCountSpacesNewLinesTabsCarriageReturningForGetLengthInChars() {
        assertThat(new Text("\n\t\r     ").getLengthInChars()).isEqualTo(0);
    }

    @Test
    public void shouldCountWordFrequenciesForOnlyWords() {
        String txt = ".1. 2, 3! 4? |' [ ]  3  2 a1   a! b b b v v ";
        Map<String, Long> expected = new HashMap<>();
        expected.put("a", 2L);
        expected.put("b", 3L);
        expected.put("v", 2L);
        assertThat(new Text(txt).getWordFrequencies()).containsAllEntriesOf(expected);

    }

    @Test
    public void shouldContainLowerCaseWordsOnlyForGetWordFrequencies() {
        String txt = "!a Abc aDc adF";

        assertThat(new Text(txt).getWordFrequencies()).containsOnly(
                entry("a", 1L),
                entry("abc", 1L),
                entry("adc", 1L),
                entry("adf", 1L));
    }

    @Test
    public void shouldReturnWordFrequenciesForText() {
        assertThat(new Text("hello Hello %hellO %").getWordFrequencies()).containsEntry("hello", 3L);
    }

    @Test
    public void shouldReturnEmptyMapForTextWithOnlySpaces() {
        Map<String, Long> expected = new HashMap<>();
        assertThat(new Text("        ").getWordFrequencies()).hasSize(expected.size());
    }

    @Test
    public void shouldNotCountSpacesNewLinesTabsCarriageReturningForGetWordFrequencies() {
        Map<String, Long> expected = new HashMap<>();

        assertThat(new Text("\n\t\r     ").getWordFrequencies()).hasSize(expected.size());
    }
}
