package org.example;

import java.nio.file.Path;

public class MathUtils {

  // Lỗi 1: Dấu ngoặc nhọn mở bị rớt xuống dòng (LeftCurly violation)
  public static int max(int a, int b)
  {
    // Lỗi 2: Thiếu khoảng trắng xung quanh từ khóa 'if' và toán tử '>=' (WhitespaceAround violation)
    if(a>=b){
      return a;
    }
    return b;
  }

  // Lỗi 3: Thụt lề sai bét nhè, tự nhiên lùi vào sâu hơn bình thường (Indentation violation)
  public static int divide(int a, int b) {
    if (b == 0) {
      throw new IllegalArgumentException("Divider must not be zero");
    }
    // Lỗi 4: Thiếu khoảng trắng ở toán tử chia (WhitespaceAround violation)
    return a/b;
  }

  public static String getFilePath(String folder, String fileName) {
    // Sử dụng Path.of để tự động chọn dấu gạch chéo đúng theo OS
    return Path.of(folder, fileName).toString();
  }
}