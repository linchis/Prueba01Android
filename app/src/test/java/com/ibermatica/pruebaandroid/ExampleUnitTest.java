package com.ibermatica.pruebaandroid;

import android.content.Context;
import android.widget.EditText;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
/*
    @Test
    public void isValidNumber() {
        // Context of the app under test.
        Calculadora calc = new Calculadora();
        EditText et1 = new EditText(calc.getApplicationContext());
        et1.setText("123");
        assertEquals(true,calc.isNumber(et1));
        et1.setText("0");
        assertEquals(true,calc.isNumber(et1));
        et1.setText("0.55");
        assertEquals(true,calc.isNumber(et1));
        et1.setText(" ");
        assertEquals(false,calc.isNumber(et1));
        et1.setText("a,1");
        assertEquals(false,calc.isNumber(et1));
        et1.setText(".");
        assertEquals(false,calc.isNumber(et1));
    }
*/
}