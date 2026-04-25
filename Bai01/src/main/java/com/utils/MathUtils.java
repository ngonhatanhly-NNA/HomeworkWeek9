package com.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathUtils {
    // Implement Logger for current class
    private static final Logger logger = LoggerFactory.getLogger(MathUtils.class);

    /*Add two integers*/
    public static int add (int a, int b){
        logger.info("Adding: {} + {}", a, b);
        return a + b;
    }

    public static double divide (int a, int b) {
        logger.debug("Validating division: {} / {}", a, b);
        if (b == 0){
            // Script log ERROR
            logger.error("Error: ZeroDivisionException, b can't be zero" );
            throw new ArithmeticException("Cant not divide 0");
        }

        double result = (double) a / b;
        logger.info("Result {}", result);
        return result;
    }
}
