package com.playtika.second.hw2;


import com.playtika.second.lesson.Main;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


// junit ---- runt test

public class ApplicationTest {

    public Main implementation;

    @Before
    public void setUp() throws Exception {
        implementation = new Main();
    }


    @Test
    public void testIsSplitBySpace() {
        int wordCount = implementation
                .countOfWords("I have 5 dollars");
        assertThat(wordCount).isEqualTo(4);
    }

    @Test
    public void emptyTextHasNoWords() {
        int wordCount = implementation
                .countOfWords("");
        assertThat(wordCount).isEqualTo(0);
    }

    @Test
    public void shouldReturnExceptionIfTextNull() {
        assertThatThrownBy(() -> implementation.countOfWords(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("text can`t be null");

    }

    @Test
    public void shouldCorrectSplitMultilineString() {
        assertThat(implementation.countOfWords("First line "
                + "second line"))
                .isEqualTo(4);
    }


    //perenos strok
    //
}
