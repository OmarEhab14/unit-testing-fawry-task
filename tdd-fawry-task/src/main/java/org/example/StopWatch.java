package org.example;

public class StopWatch {
    private int minutes;
    private int hours;

    public void record(int minutes) {
        if (minutes < 0) return;
        this.hours += (this.minutes + minutes) / 60;
        this.minutes += (this.minutes + minutes) % 60;
    }
    public int getMinutes() {
        return minutes;
    }
    public int getHours() {
        return hours;
    }
}
