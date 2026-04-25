package com.example;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathUtilTest {

    @Test
    public void testCreateFilePath() {
        PathUtil util = new PathUtil();
        
        // Gọi hàm để tạo đường dẫn: "docs" và "report.txt"
        String filePath = util.createFilePath("docs", "report.txt");
        
        // Chuyển thành đối tượng File của Java để lấy thư mục cha
        File file = new File(filePath);
        
        // Kiểm tra xem Java có nhận diện được thư mục cha là "docs" hay không
        assertEquals("docs", file.getParent(), "Thư mục cha phải là 'docs'");
    }
}