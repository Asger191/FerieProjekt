package app.controllers;

import app.entities.Day;
import app.entities.TypeDay;
import app.entities.Week;
import app.exceptions.DatabaseException;
import app.persistence.WeekMapper;
import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.List;

public class WeekController {

    public void addWeekToCalender(Context ctx) throws DatabaseException {
        int weekNumber = Integer.parseInt(ctx.formParam("weekNumber"));

        List<Day> days = new ArrayList<>();

        String[] dayNames = {"Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag", "Lørdag", "Søndag"};

        for(int i = 0; i<7; i++){
            String breakfast = ctx.formParam("breakfast" + (i + 1));
            String lunch = ctx.formParam("lunch" + (i + 1));
            String dinner = ctx.formParam("dinner" + (i + 1));

            days.add(new Day(new TypeDay(dayNames[i]), breakfast, lunch, dinner, 0));
        }
        Week week = new Week(weekNumber, days);
        WeekMapper weekMapper = new WeekMapper();
        weekMapper.addWeekWithDays(ctx, week);

    }
}
