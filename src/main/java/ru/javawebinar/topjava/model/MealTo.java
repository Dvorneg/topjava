package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MealTo {
    private final LocalDateTime dateTime;

    private final int id;

    private final String description;

    private final int calories;

    private final boolean excess;

    public MealTo(int id, LocalDateTime dateTime, String description, int calories, boolean excess) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.excess = excess;
        this.id=id;
    }

    @Override
    public String toString() {
        return "MealTo{" +
                "dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", excess=" + excess +
                '}';
    }


    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public String getFormattedDateTime() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(this.dateTime);
        //return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(this.dateTime);
    }

    public boolean isExcess() {
        return excess;
    }

    public int getId() {
        return id;
    }
}
