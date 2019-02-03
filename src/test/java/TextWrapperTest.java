import org.junit.Assert;
import org.junit.Test;

public class TextWrapperTest {

    @Test
    public void given_text_null_should_return_empty_string() {
        Assert.assertEquals("",TextWrapper.wrap(null, 5));
    }


}
