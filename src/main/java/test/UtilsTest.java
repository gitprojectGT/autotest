package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.Utils;

import java.nio.charset.Charset;
import java.util.Random;

import static org.junit.Assert.*;

public class UtilsTest {

    @Before
    public void setUp ( ) throws Exception {
    }

    @After
    public void tearDown ( ) throws Exception {
    }

    @Test
    public void checkSpecialCharsIsTrue ( ) {

          assertTrue (Utils.checkSpecialChars ("*&*akjdjskdj¬`|"));

    }

    @Test
    public void checkSpecialCharsIsFalse ( ) {
        assertFalse (Utils.checkSpecialChars ("PIPPO"));
    }

    @Test
    public void checkSpecialCharsLongString ( ) {
        byte[] array = new byte[10];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        assertTrue (Utils.checkSpecialChars (generatedString));
    }

}