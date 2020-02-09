package com.main.streams;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

  @Test
  void whenFilterListByLimit_thenGetFilteredAmount() {
    int limit = 400;
    var accounts = List
        .of(new SavingsAccount(100), new SavingsAccount(200), new SavingsAccount(300),
            new SavingsAccount(400), new SavingsAccount(500));

    double amountFiltered = accounts.stream().filter(account -> account.getBalance() >= limit)
        .findAny().stream().mapToDouble(SavingsAccount::getBalance).sum();

    assertThat(amountFiltered).isGreaterThanOrEqualTo(limit);
  }

  @Test
  void whenFilterListByUpperLimit_thenDefaultAccount() {
    int limit = 600;
    var defaultAmount = Optional.of(new SavingsAccount(0));
    var accounts = List
        .of(new SavingsAccount(100), new SavingsAccount(200), new SavingsAccount(300),
            new SavingsAccount(400), new SavingsAccount(500));

    double amountFiltered = accounts.stream().filter(account -> account.getBalance() >= limit)
        .findAny().or(() -> defaultAmount).stream().mapToDouble(SavingsAccount::getBalance).sum();

    assertThat(amountFiltered).isEqualTo(0);
  }

  @Test
  void whenFilterListByUpperLimitWithOptionals_thenDefaultBalance()
      throws IllegalArgumentException {
    int limit = 600;
    double defaultBalance = 0;
    var defaultAccount = new SavingsAccount(defaultBalance);
    var accounts = List
        .of(new SavingsAccount(100), new SavingsAccount(200), new SavingsAccount(300),
            new SavingsAccount(400), new SavingsAccount(500));
    var result = new ArrayList<SavingsAccount>();

    accounts.stream().filter(account -> account.getBalance() >= limit)
        .findAny().ifPresentOrElse(account -> result.add(account), () ->
        result.add(defaultAccount));

    assertThat(result).hasSize(1).contains(defaultAccount);
  }
}
