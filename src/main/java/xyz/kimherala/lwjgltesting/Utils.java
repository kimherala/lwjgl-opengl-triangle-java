package xyz.kimherala.lwjgltesting;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Utils {
    public static String loadResource(String filePath) {
        StringBuilder result = new StringBuilder();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(String.valueOf(filePath)))) {
            byte[] buffer = new byte[8192];

            while (bis.read(buffer) > 0) {
                result.append(new String(buffer, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
