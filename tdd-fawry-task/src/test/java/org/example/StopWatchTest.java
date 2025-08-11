package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StopWatchTest {
    @Test
    void givenStopWatch_whenRecordMinutes_thenMinutesAreRecorded() {
        // Arrange
        StopWatch stopWatch = new StopWatch();

        // Act
        stopWatch.record(10);

        // Assert
        int minutes = stopWatch.getMinutes();
        Assertions.assertEquals(10, minutes);
    }
    @Test
    void givenNegativeMinutes_whenRecord_thenMinutesDoNotChange() {
        // Arrange
        StopWatch stopWatch = new StopWatch();
        stopWatch.record(10);

        // Act
        stopWatch.record(-5);

        // Assert
        int minutes = stopWatch.getMinutes();
        Assertions.assertEquals(10, minutes);
    }
    @Test
    void givenMinutesReachedSixty_whenRecord_thenIncreaseHours() {
        // Arrange
        StopWatch stopWatch = new StopWatch();

        // Act
        stopWatch.record(60);

        // Assert
        Assertions.assertEquals(0, stopWatch.getMinutes());
        Assertions.assertEquals(1, stopWatch.getHours());
    }
    @Test
    void givenHoursReachedTwentyFour_whenRecord_thenIncreaseDays() {
        // Arrange
        StopWatch stopWatch = new StopWatch();

        // Act
        stopWatch.record(1500);

        // Assert
        Assertions.assertEquals(0, stopWatch.getMinutes());
        Assertions.assertEquals(1, stopWatch.getHours());
        Assertions.assertEquals(1, stopWatch.getDays());
    }
    @Test
    void givenDailyWorkingHours_whenRecorded_thenIncreaseDaysAccordingly() {
        // Arrange
        StopWatch stopWatch = new StopWatch();
        stopWatch.setDailyHours(8);

        // Act
        stopWatch.record(600);

        // Assert
        Assertions.assertEquals(1, stopWatch.getDays());
        Assertions.assertEquals(2, stopWatch.getHours());
    }
}
