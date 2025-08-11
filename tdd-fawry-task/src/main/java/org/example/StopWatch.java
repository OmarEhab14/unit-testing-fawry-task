package org.example;

public class StopWatch {
    private int minutes;
    private int hours;
    private int days;
    private int workingHours = 24;

    public void record(int minutes) {
        if (minutes < 0) return;

        int totalHours = minutes / 60;
        this.minutes = minutes % 60;

        this.hours = totalHours;
        if (this.hours >= workingHours) {
            this.days = this.hours / workingHours;
            this.hours = this.hours % workingHours;
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
    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }
}
