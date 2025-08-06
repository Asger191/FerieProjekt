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
        this.week = new ArrayList<>();
    }

    public Week(int weekNumber, List<Day> week) {
        this.weekNumber = weekNumber;
        this.week = new ArrayList<>();
    }
}
