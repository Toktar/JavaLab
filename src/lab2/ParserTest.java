package lab2;

import lab4.ru.vsu.amm.avl_tree.Tree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class ParserTest {

    @Test
    public void testPlus() throws Exception {
        detectAnswer("5+4", 9.0);
    }

    @Test
    public void testMinus() throws Exception {
        detectAnswer("5-4", 1.0);
    }

    @Test
    public void testMul() throws Exception {
        detectAnswer("5*4", 20.0);
    }

    @Test
    public void testDiv() throws Exception {
        detectAnswer("5 /2", 2.5);
    }

    @Test
    public void testParh() throws Exception {
        detectAnswer("5 + ( 4*2)", 13.0);
    }

    @Test
    public void testPow() throws Exception {
        detectAnswer("5 ^2", 25.0);
    }

    @Test
    public void testSin() throws Exception {
        detectAnswer("sin( " + Math.PI + ")", 0.0);
    }

    @Test
    public void testCos() throws Exception {
        detectAnswer("cos(" + Math.PI + ")", -1.0);
    }

    @Test
    public void testEmptyBracket() throws Exception {
        MathParser parser = new MathParser();
        try {
            parser.Parse("5+()");
        } catch (Exception e) {
            return;
        }
        Assert.fail();
    }
    @Test
    public void testErrorBracket() throws Exception {
        MathParser parser = new MathParser();
        try {
            parser.Parse("5+(");
        } catch (Exception e) {
            return;
        }
        Assert.fail();
    }


    @Test
    public void testNullString() {
        MathParser parser = new MathParser();
        try {
            parser.Parse("");
        } catch (Exception e) {
            return;
        }
        Assert.fail();
    }

    private void detectAnswer(String expression, double result) throws Exception {
        MathParser parser = new MathParser();
        System.out.println(result + " " +  parser.Parse(expression));
        Assert.assertEquals(result, parser.Parse(expression), 0.001);
        //Assert.assertTrue(result == parser.Parse(expression));
    }

}
