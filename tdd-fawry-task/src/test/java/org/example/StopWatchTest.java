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
}
