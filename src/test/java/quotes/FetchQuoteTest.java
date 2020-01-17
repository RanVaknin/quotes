package quotes;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FetchQuoteTest {

    FetchQuote test = new FetchQuote();

    // tests if file not found
    @Test(expected = FileNotFoundException.class)
    public void fileNotFound_test() throws IOException {
        test.getRandomQuoteLocal("te/resources/empty.json");
    }

}
