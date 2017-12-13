package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
* Test.
*
* @author Pavel Kortchagin	
* @version 1.0
* @since 13.12.2017
*/
public class CalculateTest {
/**
* Test echo.
*/ 
@Test
public void whenTakeNameThenTreeEchoPlusName() {
    String input = "Pablo";
    String expect = "Echo, echo, echo : Pablo";
    Calculate calc = new Calculate();
    String result = calc.echo(input);
    assertThat(result, is(expect));
}
 
}