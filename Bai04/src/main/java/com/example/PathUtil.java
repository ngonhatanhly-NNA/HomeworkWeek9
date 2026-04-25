package com.example;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtil {
    
    // Cố tình nối chuỗi dùng dấu \ của Windows
    public String createFilePath(String folder, String fileName) {
        return folder + "\\" + fileName; 
    }

    // // Refactor: Sử dụng thư viện nio.file.Path của Java
    // public String createFilePath(String folder, String fileName) {
    //     // Paths.get() sẽ tự động nhận diện Hệ điều hành và dùng đúng dấu \ hoặc /
    //     Path path = Paths.get(folder, fileName);
    //     return path.toString(); 
    // }
}