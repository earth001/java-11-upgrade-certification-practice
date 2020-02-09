package com.main.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

class StreamsUnitTest {

  @Test
  void givenAccountList_whenTakeWhile_thenSizeAndSumValues() {
    var accounts = List
        .of(new SavingsAccount(100), new SavingsAccount(200), new SavingsAccount(300),
            new SavingsAccount(400), new SavingsAccount(500));

    //Select balances lower than 250 = 100 and 200
    var filteredAccounts = accounts.stream().takeWhile(account -> account.getBalance() < 250)
        .collect(Collectors.toList());

    SoftAssertions.assertSoftly(softly -> {
      softly.assertThat(filteredAccounts).hasSize(2);
      softly.assertThat(filteredAccounts.stream().mapToDouble(SavingsAccount::getBalance)
          .sum()).isEqualTo(300, Offset.offset(0.1));
      softly.assertAll();
    });
  }

  @Test
  void givenAccountList_whenDropWhile_thenSizeAndSumValues() {
    var accounts = List
        .of(new SavingsAccount(100), new SavingsAccount(200), new SavingsAccount(300),
            new SavingsAccount(400), new SavingsAccount(500));

    //Select balances equal or bigger than 250 = 300, 400 and 500
    var filteredAccounts = accounts.stream().dropWhile(account -> account.getBalance() < 250)
        .collect(Collectors.toList());

    SoftAssertions.assertSoftly(softly -> {
      softly.assertThat(filteredAccounts).hasSize(3);
      softly.assertThat(filteredAccounts.stream().mapToDouble(SavingsAccount::getBalance)
          .sum()).isEqualTo(1200, Offset.offset(0.1));
      softly.assertAll();
    });
  }

  @Test
  void whenIterateStream_thenExpectedList() {

    var accounts = Stream
        .iterate(new SavingsAccount(100), account -> account.getBalance() <= 500,
            account -> new SavingsAccount(account.getBalance() + 100)).collect(Collectors.toList());

    SoftAssertions.assertSoftly(softly -> {
      softly.assertThat(accounts).hasSize(5);
      softly.assertThat(accounts.stream().mapToDouble(SavingsAccount::getBalance)
          .sum()).isEqualTo(1500, Offset.offset(0.1));
      softly.assertAll();
    });
  }

}
