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
        List<String> list = new ArrayList<>();
        list.addAll(text.getTopWords(1, txt));

        assertThat(list).hasSize(1);
    }

    @Test
    public void shouldReturnElementsInCorrectOrder() {
        List<String> list = new ArrayList<>();
        list.addAll(text.getTopWords(5, txt));

        assertThat(list).containsSequence("Andrew", "a", "x", "y", "z");
    }

    @Test
    public void shouldReturnUniqueElements() {
        assertThat(text.getTopWords(5, txt)).doesNotHaveDuplicates();
    }

    @Test
    public void shouldThrownExceptionIfTextIsNull() {
        assertThatThrownBy(() -> text.getTopWords(1, null))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("Text cant be null");
    }

    @Test
    public void shouldThrownExceptionIfCountLessThanZero() {
        assertThatThrownBy(() -> text.getTopWords(-1, "sd"))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("count can not be < 0");
    }

    @Test
    public void shouldReturnOnlyWordsForGetTopWords() {
        String txt = ".1. 2, 3! 4? |' [ ] s32 3 dda 2 a1 3f s123 !";

        assertThat(text.getTopWords(10, txt)).doesNotContain(".", ",", "!", "1", "}", "[", "s");

    }

/**************************************************************************************************************************************************************/
    @Test
    public void shouldReturnAllWords() {
        Map<String, Integer> map;

        map = text.getWordFrequencies(txt);

        assertThat(map).hasSize(8);
    }

    @Test
    public void shouldReturnValueMoreThanOne() {
        Map<String, Integer> map;

        map = text.getWordFrequencies(txt);

        assertThat(map.get("a")).isEqualTo(3);
    }

    @Test
    public void shouldThrownExceptionIfTextIsNullForGetWordFrequencies() {
        assertThatThrownBy(() -> text.getWordFrequencies(null))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("Text cant be null");
    }

/**************************************************************************************************************************************************************/

    @Test
    public void shouldReturnCorrectLenght() {
        assertThat(text.getLengthInChars(txt)).isEqualTo(11);
    }

    @Test
    public void shouldReturnZeroIfTextDoesNotContainWords() {
        assertThat(text.getLengthInChars("1,2,3")).isEqualTo(0);
    }

    @Test
    public void shouldThrownExceptionIfTextIsNullForGetLengthChars() {
        assertThatThrownBy(() -> text.getWordFrequencies(null))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("Text cant be null");
    }
}
