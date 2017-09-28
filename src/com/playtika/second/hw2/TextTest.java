package com.playtika.second.hw2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class TextTest {

    Text text;
    String txt = "x y z a Andrew a !";

    @Before
    public void setUp() throws Exception {
        text = new Text(txt);
    }

    @Test
    public void shouldReturnListWithCorrectSize() {

        assertThat(text.getTopWords(1)).hasSize(1);
    }

    @Test
    public void shouldReturnElementsInCorrectOrder() {

        assertThat(text.getTopWords(5)).containsSequence("Andrew", "a", "x", "y", "z");
    }

    @Test
    public void shouldReturnUniqueElements() {
        assertThat(text.getTopWords(5)).doesNotHaveDuplicates();
    }

    @Test
    public void shouldThrownExceptionIfTextIsNull() {
        assertThatThrownBy(() -> new Text(null).getTopWords(1))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("Text cant be null");
    }

    @Test
    public void shouldThrownExceptionIfCountLessThanZero() {
        assertThatThrownBy(() -> text.getTopWords(-1))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("count can not be < 0");
    }

    @Test
    public void shouldReturnOnlyWordsForGetTopWords() {
        String txt = ".1. 2, 3! 4? |' [ ] s32 3 dda 2 a1 3f s123 !";

        assertThat(new Text(txt).getTopWords(1)).doesNotContain(".", ",", "!", "1", "}", "[");

    }

/**************************************************************************************************************************************************************/
    @Test
    public void shouldReturnAllWords() {
        Map<String, Integer> map;

        map = text.getWordFrequencies();

        assertThat(map).hasSize(5);
    }

    @Test
    public void shouldReturnValueMoreThanOne() {
        Map<String, Integer> map;

        map = text.getWordFrequencies();

        assertThat(map.get("a")).isEqualTo(2);
    }

    @Test
    public void shouldThrownExceptionIfTextIsNullForGetWordFrequencies() {
        assertThatThrownBy(() -> new Text(null).getWordFrequencies())
            .isInstanceOf(RuntimeException.class)
            .hasMessage("Text cant be null");
    }

/**************************************************************************************************************************************************************/

    @Test
    public void shouldReturnCorrectLenght() {
        assertThat(text.getLengthInChars()).isEqualTo(11);
    }

    @Test
    public void shouldReturnZeroIfTextDoesNotContainWords() {
        assertThat(new Text("1 2 3").getLengthInChars()).isEqualTo(0);
    }

    @Test
    public void shouldThrownExceptionIfTextIsNullForGetLengthChars() {
        assertThatThrownBy(() -> new Text(null).getWordFrequencies())
            .isInstanceOf(RuntimeException.class)
            .hasMessage("Text cant be null");
    }
}
