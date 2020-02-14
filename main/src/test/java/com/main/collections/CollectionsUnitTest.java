package com.main.collections;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.time.Month;
import java.time.MonthDay;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

class CollectionsUnitTest {
  @Test
  void givenListCreatedByOf_whenAdd_thenThrowUnsupportedOperationException() {
    var list = List.of(1, 2, 3, 4, 5, 6);

    assertSoftly(softly -> {
      softly.assertThatThrownBy(() -> list.add(7))
          .isInstanceOf(UnsupportedOperationException.class);
      softly.assertThat(list).hasSize(6);
    });
  }

  @Test
  void whenCreateMapWithOfEntries_thenContainsExpectedKey() {
    var map = Map.ofEntries(
        entry("Bologna Day", MonthDay.of(Month.JANUARY, 16)),
        entry("Opposite Day", MonthDay.of(Month.FEBRUARY, 13)),
        entry("Panic Day", MonthDay.of(Month.MARCH, 9)),
        entry("Raymond Day", MonthDay.of(Month.OCTOBER, 20)),
        entry("Knight Day", MonthDay.of(Month.DECEMBER, 1))
    );

    assertThat(map).hasSize(5).containsKey("Knight Day");
  }

  @Test
  void whenCreateSetWithOfEntries_thenCreateSequenceInRandomizedOrder() {
    var set = Set.of(1, 2, 3, 4, 5, 6);

    assertThat(set).doesNotContainSequence(1, 2, 3, 4, 5, 6);
  }

}
