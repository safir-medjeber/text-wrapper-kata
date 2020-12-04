import org.junit.Assert;
import org.junit.Test;

public class TextWrapperTest {


    @Test
    public void given_null_text_should_return_empty_text() {
        assertWrap(5, null, "");
    }

    @Test
    public void given_text_lower_or_equals_than_width_should_return_text() {
        assertWrap(4, "aa", "aa");
        assertWrap(4, "bb", "bb");
        assertWrap(2, "bb", "bb");
    }

    @Test
    public void given_word_bigger_than_width_should_break_word() {
        assertWrap(2, "aabb", "aa\nbb");
        assertWrap(2, "aabbcc", "aa\nbb\ncc");
    }

    @Test
    public void given_text_bigger_than_width_should_break_text() {
        assertWrap(3,"a dog", "a\ndog");
        assertWrap(2,"a dog", "a\ndo\ng");
    }

    @Test
    public void given_text_surrounded_by_space_remove_it() {
        assertWrap(4, " aa ", "aa");
    }

    @Test
    public void final_Test() {
        assertWrap(10, "Le TDD c'est super mais il faut beaucoup pratiquer pour être bon ",
                "Le TDD\nc'est\nsuper mais\nil faut\nbeaucoup\npratiquer\npour être\nbon");
    }

    private void assertWrap(int width, String text, String expected) {
        Assert.assertEquals(expected, TextWrapper.wrap(width, text));
    }
}

