package org.example;

import org.junit.jupiter.api.*;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

  @BeforeAll
  public static void setUpAll() {
    System.out.println("=== Bat dau chay org.example.MathUtilsTest ===");
  }

  @AfterAll
  public static void tearDownAll() {
    System.out.println("=== Ket thuc ===");
  }

  @Test
  @DisplayName("EP: a lon hon b")
  public void testMax_AGreaterThanB() {
    assertEquals(5, MathUtils.max(5, 3));
    assertEquals(100, MathUtils.max(100, -50));
  }

  @Test
  @DisplayName("EP: a bang b")
  public void testMax_AEqualsB() {
    assertEquals(4, MathUtils.max(4, 4));
    assertEquals(-10, MathUtils.max(-10, -10));
  }

  @Test
  @DisplayName("EP: a nho hon b")
  public void testMax_ALessThanB() {
    assertEquals(7, MathUtils.max(2, 7));
    assertEquals(0, MathUtils.max(-5, 0));
  }

  @Test
  @DisplayName("BVA: Kiem tra cac gia tri bien cua kieu int")
  public void testMax_BoundaryValues() {
    assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, 0));
    assertEquals(Integer.MAX_VALUE, MathUtils.max(0, Integer.MAX_VALUE));
    assertEquals(10, MathUtils.max(Integer.MIN_VALUE, 10));
    assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, Integer.MIN_VALUE));
  }

  @Test
  @DisplayName("EP: b > 0 (So chia la so duong)")
  public void testDivide_PositiveDivider() {
    assertEquals(5, MathUtils.divide(10, 2));
    assertEquals(0, MathUtils.divide(0, 5));
  }

  @Test
  @DisplayName("EP: b < 0 (So chia la so am)")
  public void testDivide_NegativeDivider() {
    assertEquals(-5, MathUtils.divide(10, -2));
    assertEquals(3, MathUtils.divide(-9, -3));
  }

  @Test
  @DisplayName("EP: b = 0 (Bat ngoai le chia cho 0)")
  public void testDivide_ZeroDivider() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      MathUtils.divide(10, 0);
    });

    assertEquals("Divider must not be zero", exception.getMessage());
  }

  @Test
  @DisplayName("BVA: Kiem tra cac gia tri bien cua phep chia (divide)")
  public void testDivide_BoundaryValues() {
    assertEquals(10, MathUtils.divide(10, 1));
    assertEquals(-10, MathUtils.divide(10, -1));

    assertEquals(Integer.MAX_VALUE, MathUtils.divide(Integer.MAX_VALUE, 1));
    assertEquals(Integer.MIN_VALUE, MathUtils.divide(Integer.MIN_VALUE, 1));

    assertEquals(-2147483647, MathUtils.divide(Integer.MAX_VALUE, -1));

    assertEquals(1, MathUtils.divide(Integer.MAX_VALUE, Integer.MAX_VALUE));
    assertEquals(1, MathUtils.divide(Integer.MIN_VALUE, Integer.MIN_VALUE));

    assertEquals(Integer.MIN_VALUE, MathUtils.divide(Integer.MIN_VALUE, -1));
  }

    @Test
    void testFilePath() {
        String folder = "data";
        String fileName = "report.txt";

        // Path.of sẽ tự hiểu:
        // - Trên Windows là "data\report.txt"
        // - Trên Linux là "data/report.txt"
        String expected = Path.of(folder, fileName).toString();

        assertEquals(expected, MathUtils.getFilePath(folder, fileName));
    }
}