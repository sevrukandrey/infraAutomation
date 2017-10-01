package com.playtika.second.hw2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class GetLengthHarmcrestTest {

    Text text;
    String txt = "x y z a Andrew a A !";

    @Before
    public void setUp() throws Exception {
        text = new Text(txt);
    }


    @Test
    public void shouldReturnCorrectLength() {
        assertThat(text.getLengthInChars(),equalTo(12));
    }

    @Test
    public void shouldReturnZeroIfTextDoesNotContainWords() {
        assertThat(new Text("1 2 3").getLengthInChars(), equalTo(0));
    }

    @Test
    public void shouldNotCountLengthOfSpecificSymbols() {
        assertThat(new Text(". $,./{}%    !  ?").getLengthInChars(), equalTo(0));
    }

    @Test
    public void shouldNotCountSpaces() {
        assertThat(new Text("   b    ").getLengthInChars(), equalTo(1));
    }


    @Test (expected = RuntimeException.class)
    public void shouldThrownExceptionIfTextIsNullForGetLengthChars() {
        new Text(null).getLengthInChars();
    }
}
