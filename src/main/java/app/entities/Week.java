package app.entities;

import java.util.ArrayList;
import java.util.List;

public class Week {
    int weekId;
    int weekNumber;
    List<Day> week;

    public Week(int weekId, int weekNumber, List<Day> week) {
        this.weekId = weekId;
        this.weekNumber = weekNumber;
        this.week = week;
    }

    public Week(int weekNumber, List<Day> week) {
        this.weekNumber = weekNumber;
        this.week = week;
    }

    public int getWeekId() {
        return weekId;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public List<Day> getWeek() {
        return week;
    }

    public void setWeek(List<Day> week) {
        this.week = week;
    }
}
