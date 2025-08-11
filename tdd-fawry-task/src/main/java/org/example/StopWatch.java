package org.example;

public class StopWatch {
    private int minutes;

    public void record(int minutes) {
        if (minutes < 0) {
            return;
        }
        this.minutes = minutes;
    }
    public int getMinutes() {
        return minutes;
    }
}
