package app.entities;

public class Day {
    TypeDay typeDay;
    String breakfast;
    String lunch;
    String dinner;
    int dayId;
    int weekId;

    public Day(TypeDay typeDay, String breakfast, String lunch, String dinner, int dayId, int weekId) {
        this.typeDay = typeDay;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.dayId = dayId;
        this.weekId = weekId;
    }

    public Day(TypeDay typeDay, String breakfast, String lunch, String dinner, int weekId) {
        this.typeDay = typeDay;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.weekId = weekId;
    }


}
