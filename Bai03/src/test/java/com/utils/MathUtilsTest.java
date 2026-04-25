package com.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @Test
    public void testAdd(){
        int result = MathUtils.add(5, 3);
        assertEquals(8, result, "5 + 3 = 8");
    }

    @Test
    public void testDivisionNormal(){
        double result = MathUtils.divide(10, 2);
        assertEquals(5.0, result, "10 / 2 = 5.0");
    }

    @Test
    public void testDivisionException() {
        Exception exception = assertThrows(ArithmeticException.class, () -> MathUtils.divide(10, 0));
        assertEquals("Cant not divide 0", exception.getMessage() );
    }
}
