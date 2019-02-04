import org.junit.Assert;
import org.junit.Test;

public class TextWrapperTest {


    @Test
    public void given_null_text_should_should_return_empty_string() {
        assertWrap(3, null, "");
    }

    @Test
    public void given_text_lower_or_equals_than_width_should_return_text() {
        assertWrap(5, "aaa", "aaa");
        assertWrap(5, "bb", "bb");
        assertWrap(2, "cc", "cc");
        assertWrap(3, "d d", "d d");
    }


    @Test
    public void given_word_bigger_than_width_should_break_word() {
        assertWrap(2, "aabb", "aa\nbb");
        assertWrap(2, "aabbcc", "aa\nbb\ncc");
    }

    @Test
    public void given_text_bigger_than_width_should_insert_last_word_to_next_line() {
        assertWrap(5, "aa bbcc", "aa\nbbcc");
        assertWrap(5, "aa bbccdd ", "aa\nbbccd\nd");
        assertWrap(5, "aa bbccd  d ", "aa\nbbccd\nd");
        assertWrap(5, "aa bb ccd", "aa bb\nccd");
    }



    private void assertWrap(int width, String text, String expected) {
        Assert.assertEquals(expected, TextWrapper.wrap(text, width));
    }


    @Test
    public void finalTest() {
        Assert.assertEquals("Le TDD\nc'est\nsuper mais\nil faut\nbeaucoup\npratiquer\npour être\nbon",
                TextWrapper.wrap("Le TDD c'est super mais il faut beaucoup pratiquer pour être bon ", 10));

    }
}
