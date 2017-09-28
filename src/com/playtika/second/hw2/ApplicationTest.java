package com.playtika.second.hw2;



import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


// junit ---- runt test

public class ApplicationTest {

    public Application application;

    @Before
    public void setUp() throws Exception {
        application = new Application();
    }


    @Test
    public void testIsSplitBySpace() {
        int wordCount = application
                .countOfWords("I have 5 dollars");
        assertThat(wordCount).isEqualTo(4);
    }

    @Test
    public void emptyTextHasNoWords() {
        int wordCount = application
                .countOfWords("");
        assertThat(wordCount).isEqualTo(0);
    }

    @Test
    public void shouldReturnExceptionIfTextNull() {
        assertThatThrownBy(() -> application.countOfWords(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("text can`t be null");

    }

    @Test
    public void shouldCorrectSplitMultilineString() {
        assertThat(application.countOfWords("First line "
                + "second line"))
                .isEqualTo(4);
    }

    @Test
    public void shouldNotContainPunctuationMarks() {
        String txt = ", . / & ? :";
        assertThat(application.countOfWords(txt)).isEqualTo(0);

    }

    @Test
    public void shouldNotContainExtraSpaces() {
        String txt = "  d  a";
        assertThat(application.countOfWords(txt)).isEqualTo(2);
    }

}
