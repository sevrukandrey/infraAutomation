package com.playtika.third.hw;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class TextTest {

    Text text;
    String txt = getDefaultText();

    public TextTest() throws IOException {
    }

    @Before
    public void setUp() throws Exception {
        text = new Text(txt);
    }

    @Test
    public void shouldReturnTopUniqueWordsOrderedAlphabetically() {
        assertThat(text.getTopWords(5)).containsSequence("a", "andrew", "x", "y", "z").hasSize(5);
    }


    @Test
    public void shouldThrownExceptionIfCountZeroAndLess() {
        assertThatThrownBy(() -> text.getTopWords(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("returnedCountOfTopWords can not be 0 or less");
    }

    @Test
    public void shouldReturnOnlyWordsForGetTopWords() {
        String txt = null;
        try {
            txt = getSpecificElements();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(new Text(txt).getTopWords(100)).doesNotContain(".", ",", "!", "1", "}", "[", "4?", ".1.");
    }

    @Test
    public void shouldContainLowerCaseWordsOnly() {

        assertThat(text.getTopWords(5)).doesNotContain("A");
    }

    @Test
    public void shouldNotCountSpacesNewLinesTabsCarriageReturningForGetTopWords() {

        String txt = null;
        try {
            txt = getSpecificElements();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(new Text(txt).getLengthInChars()).isEqualTo(7);
    }


    /**************************************************************************************************************************************************************/

    @Test
    public void shouldCountWordFrequenciesForOnlyWords() {
        String txt = null;
        try {
            txt = getSpecificSymbolsNumbersAndWords();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 2);
        expected.put("b", 3);
        expected.put("v", 2);
        assertThat(new Text(txt).getWordFrequencies()).containsAllEntriesOf(expected);

    }

    @Test
    public void shouldContainLowerCaseWordsOnlyForGetWordFrequencies() {
        String txt = null;
        try {
            txt = getWordsInDifferentCase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(new Text(txt).getWordFrequencies()).containsOnly(
                entry("abc", 4));
    }

    @Test
    public void shouldReturnEmptyMapForTextWithOnlySpaces() {
        String txt = null;
        try {
            txt = getEmptyText();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Integer> expected = new HashMap<>();
        assertThat(new Text(txt).getWordFrequencies()).hasSize(expected.size());
    }

    @Test
    public void shouldNotCountSpacesNewLinesTabsCarriageReturningForGetWordFrequencies() {
        String txt = null;
        try {
            txt = getSpecificSymbolsNumbersAndWords();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(new Text(txt).getWordFrequencies()).containsExactly(entry("a", 2), entry("b", 3), entry("v", 2));
    }


    /**************************************************************************************************************************************************************/

    @Test
    public void shouldReturnCorrectLenght() {
        assertThat(text.getLengthInChars()).isEqualTo(12);
    }


    @Test
    public void shouldNotCountLengthOfSpecificSymbolsAndNumbers() {
        assertThat(new Text(". $a,./{}%    !  ? 1 2 2? ").getLengthInChars()).isEqualTo(1);
    }

    @Test
    public void shouldNotCountSpacesNewLinesTabsCarriageReturningForGetLengthInChars() {
        assertThat(new Text("\n\t\r     ").getLengthInChars()).isEqualTo(0);
    }


    /**************************************************************************************************************************************************************/


    @Test
    public void shouldThrownExceptionIfTextIsNull() {
        assertThatThrownBy(() -> new Text(null).getTopWords(1))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Text cant be null");
    }

    private String getSpecificElements() throws IOException {
        return new String(Files.readAllBytes(Paths.get("SpecificSymbolsSpacesNumbersNewLinesTabs.txt")),
                StandardCharsets.UTF_8);
    }

    private static String getDefaultText() throws IOException {
        return new String(Files.readAllBytes(Paths.get("defaultText.txt")), StandardCharsets.UTF_8);
    }

    private String getSpecificSymbolsNumbersAndWords() throws IOException {
        return new String(Files.readAllBytes(Paths.get("specificSymbolsNumbersAndWords.txt")), StandardCharsets.UTF_8);
    }

    private String getWordsInDifferentCase() throws IOException {
        return new String(Files.readAllBytes(Paths.get("differentCase.txt")), StandardCharsets.UTF_8);
    }


    private String getEmptyText() throws IOException {

        return new String(Files.readAllBytes(Paths.get("emptyFile.txt")), StandardCharsets.UTF_8);
    }


}
