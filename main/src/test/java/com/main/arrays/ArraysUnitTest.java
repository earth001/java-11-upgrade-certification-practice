package com.main.arrays;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ArraysUnitTest {

  @Test
  void whenCompareArraysWithEquals_thenGetExpectedResult() {
    int[] array1 = {100, 100, 100, 100, 100};
    int[] array2 = {100, 100, 100, 100, 100};
    int[] array3 = {100, 100, 300, 100, 100};
    int[] array4 = {100, 100, 100, 100, 100, 100};

    assertSoftly(softly -> {
      softly.assertThat(Arrays.equals(array1, array2)).isTrue();
      softly.assertThat(Arrays.equals(array3, array4)).isFalse();
      softly.assertThat(Arrays.equals(array4, array3)).isFalse();
      softly.assertThat(Arrays.equals(array3, 0, 2, array4, 0, 2)).isTrue();
      softly.assertThatThrownBy(() -> Arrays.equals(array3, 0, 2, array4, 0, 10))
          .isInstanceOf(ArrayIndexOutOfBoundsException.class);
      softly.assertAll();
    });
  }

  @Test
  void whenCompareArraysWithCompare_thenGetExpectedResult() {
    int[] array1 = {100, 100, 100, 100, 100};
    int[] array2 = {100, 100, 100, 100, 100};
    int[] array3 = {100, 100, 300, 100, 100};
    int[] array4 = {100, 100, 100, 100, 100, 100};

    assertSoftly(softly -> {
      softly.assertThat(Arrays.compare(array1, array2)).isZero();
      softly.assertThat(Arrays.compare(array1, array3)).isEqualTo(-1);
      softly.assertThat(Arrays.compare(array3, array1)).isOne();
      softly.assertThat(Arrays.compare(array3, 0, 2, array4, 0, 2)).isZero();
      softly.assertThat(Arrays.compare(array1, 0, 2, array4, 0, 3)).isEqualTo(-1);
      softly.assertAll();
    });
  }

  @Test
  void whenCompareArraysWithCompareUnsigned_thenGetExpectedResult() {
    int[] array1 = {100, 100, 100, 100, 100};
    int[] array3 = {100, 100, 300, 100, 100};
    int[] array31 = {100, 100, -300, 100, 100};
    int[] array32 = {100, 100, 50, 100, 100, 100};
    int[] array33 = {100, 100, 50, 50, 100};
    int[] array34 = {100, 400, 50, 50, 100};
    int[] charArray1 = {'A', 'B'};
    int[] charArray2 = {'C', 'D'};
    int[] charArray3 = {'C', 'Z'};

    assertSoftly(softly -> {
      softly.assertThat(Arrays.compareUnsigned(array1, array3)).isEqualTo(-1);
      softly.assertThat(Arrays.compareUnsigned(array1, array31)).isEqualTo(-1);
      softly.assertThat(Arrays.compareUnsigned(array1, array32)).isOne();
      softly.assertThat(Arrays.compareUnsigned(array1, array33)).isOne();
      //La diferencia es lexicográfica
      softly.assertThat(Arrays.compareUnsigned(array1, array34)).isEqualTo(-1);
      softly.assertThat(Arrays.compare(charArray1, charArray2)).isEqualTo(-1);
      softly.assertThat(Arrays.compare(charArray1, charArray3)).isEqualTo(-1);
      softly.assertAll();
    });
  }

  @Test
  void whenCompareArraysWithMismatch_thenGetExpectedResult() {
    int[] array1 = {100, 100, 100, 100, 100};
    int[] array4 = {100, 100, 100, 100, 100, 100};
    int[] array41 = {100, 100, 50, 100, 100, 100};
    int[] array42 = {100, 100, 50, 100, 50, 100};

    assertSoftly(softly -> {
      // mismatch returns the index of the first mismatch between the two arrays, otherwise -1.
      softly.assertThat(Arrays.mismatch(array1, 0, 5, array4, 0, 5)).isEqualTo(-1);
      softly.assertThat(Arrays.mismatch(array1, array4)).isEqualTo(5);
      softly.assertThat(Arrays.mismatch(array1, 0, 5, array41, 0, 6)).isEqualTo(2);
      softly.assertThat(Arrays.mismatch(array1, 0, 5, array42, 0, 6)).isEqualTo(2);
      softly.assertAll();
    });
  }

}
