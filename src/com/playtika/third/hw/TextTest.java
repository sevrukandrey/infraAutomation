package com.playtika.third.hw;

import com.playtika.second.hw2.Text;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;




//Rewrite According to hamcrest asserts

public class TextTest {

    Text text;
    String txt = "! x y z a Andrew a A !";

    @Before
    public void setUp() throws Exception {
        text = new Text(txt);
    }

    @Test
    public void shouldReturnTopUniqueWordsOrderedAlphabetically() {

        //assertThat((text.getTopWords(5)), contains("a", "andrew", "x", "y", "z"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrownExceptionIfCountZeroAndLess() {
        text.getTopWords(0);

    }

    @Test
    public void shouldReturnOnlyWordsForGetTopWords() {
        String txt = ".1. 2, 3! 4? |' [ ] s32 3 dda 2 a1 3f s123 !";

        assertThat(new Text(txt).getTopWords(1),
                not(hasItems(".", "!", "@", "<", "1", "&")));
    }

    @Test
    public void shouldContainLowerCaseWordsOnly() {
        assertThat(text.getTopWords(5),
                not(hasItem("A")));
    }

    @Test
    public void shouldNotCountSpacesNewLinesTabsCarriageReturningForGetTopWords() {
        assertThat(new Text("\n\t\r     ").getLengthInChars(), equalTo(0));
    }

    @Test
    public void shouldCountWordFrequenciesForOnlyWords() {
        String txt = ".1. 2, 3! 4? |' [ ]  3  2 a1   a! b b b v v ";
        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 2);
        expected.put("b", 3);
        expected.put("v", 2);
        assertThat(new Text(txt).getWordFrequencies(), is(expected));

    }

    @Test
    public void shouldContainLowerCaseWordsOnlyForGetWordFrequencies() {
        String txt = "!a Abc aDc adF";
        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 1);
        expected.put("abc", 1);
        expected.put("adc", 1);
        expected.put("adf", 1);

        assertThat(new Text(txt).getWordFrequencies(), is(expected));
    }

    @Test
    public void shouldReturnWordFrequenciesForText() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("hello", 3);
        assertThat(new Text("hello Hello %hellO %").getWordFrequencies(), is(expected));

    }

    @Test
    public void shouldReturnEmptyMapForTextWithOnlySpaces() {
        Map<String, Integer> expected = new HashMap<>();
        assertThat(new Text("        ").getWordFrequencies(), is(expected));
    }

    @Test
    public void shouldNotCountSpacesNewLinesTabsCarriageReturningForGetWordFrequencies() {
        Map<String, Integer> expected = new HashMap<>();

        assertThat(new Text("\n\t\r     ").getWordFrequencies(), is(expected));
    }

    @Test
    public void shouldReturnCorrectLenght() {
        assertThat(text.getLengthInChars(), equalTo(12));
    }

    @Test
    public void shouldNotCountLengthOfSpecificSymbolsAndNumbers() {
        assertThat(new Text(". $a,./{}%    !  ? 1 2 2? ").getLengthInChars(), equalTo(1));
    }

    @Test
    public void shouldNotCountSpacesNewLinesTabsCarriageReturningForGetLengthInChars() {
        assertThat(new Text("\n\t\r     ").getLengthInChars(), equalTo(0));
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrownExceptionIfTextIsNull() {
        new Text(null).getTopWords(1);
    }
}
