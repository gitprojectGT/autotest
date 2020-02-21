package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.PropertyLoader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PropertyLoaderTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void loadNullProperty() {
      assertNull("The property is null", PropertyLoader.loadProperty(""));
    }

    @Test
    public void loadBlankValueProperty() {
        assertNotEquals("The property is blank"," ", PropertyLoader.loadProperty(" "));
    }

    @Test
    public void loadSpecialCharsProperty() {
        String match ="@*@*";
        assertThat( "The value of variable passed is "+ match , null, is(PropertyLoader.loadProperty(match)));
    }

    @Test
    public void loadPropertyWhenConfigurationFileNotFound ( ) {
        assertEquals (" (The system cannot find the path specified)" , PropertyLoader.loadProperty ("PIPPO" , ""));
    }

}