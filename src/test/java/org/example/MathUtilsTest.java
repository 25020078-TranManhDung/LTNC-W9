package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.Path;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Lớp kiểm thử cho MathUtils.
 */
class MathUtilsTest {

  @BeforeAll
  static void setUpAll() {
    System.out.println("=== Bat dau chay org.example.MathUtilsTest ===");
  }

  @AfterAll
  static void tearDownAll() {
    System.out.println("=== Ket thuc ===");
  }

  @Test
  @DisplayName("EP: a lon hon b")
  void testMaxFirstArgumentGreater() {
    assertEquals(5, MathUtils.max(5, 3));
    assertEquals(100, MathUtils.max(100, -50));
  }

  @Test
  @DisplayName("EP: a bang b")
  void testMaxArgumentsEqual() {
    assertEquals(4, MathUtils.max(4, 4));
    assertEquals(-10, MathUtils.max(-10, -10));
  }

  @Test
  @DisplayName("EP: a nho hon b")
  void testMaxFirstArgumentLess() {
    assertEquals(7, MathUtils.max(2, 7));
    assertEquals(0, MathUtils.max(-5, 0));
  }

  @Test
  @DisplayName("BVA: Kiem tra cac gia tri bien cua kieu int")
  void testMaxBoundaryValues() {
    assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, 0));
    assertEquals(Integer.MAX_VALUE, MathUtils.max(0, Integer.MAX_VALUE));
    assertEquals(10, MathUtils.max(Integer.MIN_VALUE, 10));
    assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, Integer.MIN_VALUE));
  }

  @Test
  @DisplayName("EP: b > 0 (So chia la so duong)")
  void testDividePositiveDivider() {
    assertEquals(5, MathUtils.divide(10, 2));
    assertEquals(0, MathUtils.divide(0, 5));
  }

  @Test
  @DisplayName("EP: b < 0 (So chia la so am)")
  void testDivideNegativeDivider() {
    assertEquals(-5, MathUtils.divide(10, -2));
    assertEquals(3, MathUtils.divide(-9, -3));
  }

  @Test
  @DisplayName("EP: b = 0 (Bat ngoai le chia cho 0)")
  void testDivideZeroDivider() {
    Exception exception =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> {
                      MathUtils.divide(10, 0);
                    });

    assertEquals("Divider must not be zero", exception.getMessage());
  }

  @Test
  @DisplayName("BVA: Kiem tra cac gia tri bien cua phep chia (divide)")
  void testDivideBoundaryValues() {
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

    String expected = Path.of(folder, fileName).toString();

    assertEquals(expected, MathUtils.getFilePath(folder, fileName));
  }
}