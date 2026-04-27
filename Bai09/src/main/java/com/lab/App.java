package com.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public void processData(String username, int id) {
        // Dùng INFO để báo cáo các mốc quan trọng (Dùng Parameterized Logging {})
        logger.info("Bắt đầu xử lý dữ liệu cho User: {}, ID: {}", username, id);
        
        try {
            if (id < 0) {
                throw new IllegalArgumentException("ID không được âm!");
            }
            logger.info("Xử lý dữ liệu thành công!");
        } catch (Exception e) {
            // Dùng ERROR để ghi nhận ngoại lệ
            logger.error("Đã xảy ra lỗi hệ thống: {}", e.getMessage(), e);
        }
    }
}