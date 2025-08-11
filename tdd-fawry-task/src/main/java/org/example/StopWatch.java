package org.example;

public class StopWatch {
    private int minutes;
    private int hours;
    private int days;

    public void record(int minutes) {
        if (minutes < 0) return;

        int totalHours = minutes / 60;
        this.minutes = minutes % 60;

        this.hours = totalHours;
        if (this.hours >= 24) {
            this.days = this.hours / 24;
            this.hours = this.hours % 24;
        }
    }
    public int getMinutes() {
        return minutes;
    }
    public int getHours() {
        return hours;
    }
    public int getDays() {
        return days;
    }
}
