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

    public TypeDay getTypeDay() {
        return typeDay;
    }

    public void setTypeDay(TypeDay typeDay) {
        this.typeDay = typeDay;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public int getWeekId() {
        return weekId;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }
}
