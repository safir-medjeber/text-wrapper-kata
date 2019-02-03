import org.junit.Assert;
import org.junit.Test;


public class TextWrapperTest {

    @Test
    public void given_text_null_should_return_empty_string() {
        Assert.assertEquals("", TextWrapper.wrap(null, 5));
    }


    @Test
    public void given_text_length_smaller_or_equals_than_width_should_return_same_text() {
        Assert.assertEquals("aaaa", TextWrapper.wrap("aaaa", 5));
        Assert.assertEquals("bbb", TextWrapper.wrap("bbb", 3));
        Assert.assertEquals("c c", TextWrapper.wrap("c c", 3));
    }

    @Test
    public void given_text_beginning_or_ending_with_space_should_return_text_without_theses_spaces() {
        Assert.assertEquals("aa", TextWrapper.wrap(" aa", 4));
        Assert.assertEquals("aa", TextWrapper.wrap("aa ", 4));
        Assert.assertEquals("aa", TextWrapper.wrap(" aa ", 4));
    }

    @Test
    public void given_word_bigger_than_width_should_break_word() {
        Assert.assertEquals("aaa\nbbb", TextWrapper.wrap("aaabbb", 3));
        Assert.assertEquals("aaa\nbbb\nccc", TextWrapper.wrap("aaabbbccc", 3));
    }

    @Test
    public void given_text_bigger_than_width_should_insert_last_word_of_line_to_next_line_instead_of_break() {
        Assert.assertEquals("aa bb\nccc", TextWrapper.wrap("aa bb ccc", 5));
        Assert.assertEquals("aa\nbbbbb", TextWrapper.wrap("aa bbbbb", 5));
        Assert.assertEquals("aa\nbbbbb\nb", TextWrapper.wrap("aa bbbbbb", 5));
        Assert.assertEquals("aa\nbb\nbb\nbb", TextWrapper.wrap("aa bbbbbb", 2));
        Assert.assertEquals("Le TDD\nc'est\nsuper\nmais\nil\nfaut\nbeacou\nup\npratiq\nuer\npour\nêtre\nbon", TextWrapper.wrap("Le TDD c'est super mais il faut beacouup pratiquer pour être bon", 6));
    }
}
