import org.junit.Assert;
import org.junit.Test;

public class TextWrapperTest {


    @Test
    public void given_null_text_should_return_empty_string() {
        Assert.assertEquals("", TextWrapper.wrap(null, 10));
    }

    @Test
    public void given_text_smaller_or_equals_than_width_should_return_same_text() {
        Assert.assertEquals("aaa", TextWrapper.wrap("aaa", 3));
        Assert.assertEquals("bb", TextWrapper.wrap("bb", 3));
    }


    @Test
    public void given_text_beginning_or_ending_with_space_should_remove_these_space() {
        Assert.assertEquals("aaa", TextWrapper.wrap(" aaa", 5));
        Assert.assertEquals("aaa", TextWrapper.wrap("aaa ", 5));
        Assert.assertEquals("aaa", TextWrapper.wrap(" aaa ", 5));
        Assert.assertEquals("a a", TextWrapper.wrap(" a a ", 5));
    }

    @Test
    public void given_word_bigger_than_width_should_break_word() {
        Assert.assertEquals("aaa\nbbb", TextWrapper.wrap("aaabbb", 3));
        Assert.assertEquals("aaa\nbbb\nccc", TextWrapper.wrap("aaabbbccc", 3));
        Assert.assertEquals("aaa\nbbb\nccc", TextWrapper.wrap("aaabbbccc ", 3));
    }

    @Test
    public void given_text_bigger_than_width_should_insert_the_last_word_of_line_to_next_line() {
        Assert.assertEquals("aaa\nbbb", TextWrapper.wrap("aaa bbb", 6));
        Assert.assertEquals("aaa\nbbbbbb\naaa", TextWrapper.wrap("aaa bbbbbbaaa", 6));
        Assert.assertEquals("aa bb\nccc", TextWrapper.wrap("aa bb ccc", 5));
    }

    @Test
    public void final_test() {
        Assert.assertEquals("Le TDD\nc'est\nsuper mais\nil faut\nbeaucoup\npratiquer\npour être\nbon",
                TextWrapper.wrap("Le TDD c'est super mais il faut beaucoup pratiquer pour être bon ", 10));
    }

}
