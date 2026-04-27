package com.lab;

import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    void testLogging() {
        App app = new App();
        // Gọi hàm đúng để in log INFO
        app.processData("NgoNhatAnh", 100);
        
        System.out.println("-------------------------------------------------");
        
        // Gọi hàm sai cố ý để in log ERROR
        app.processData("Hacker", -5);
    }
}