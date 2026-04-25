package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathServiceTest {
    @Test
    public void testAdd() {
        MathService service = new MathService();
        int result = service.add(5, 3);
        assertEquals(8, result, "5 + 3 should equal 8");
    }

    @Test
    public void testSubtract() {
        MathService service = new MathService();
        int result = service.subtract(5, 3);
        assertEquals(2, result, "5 - 3 should equal 2");
    }
}
