package ru.javawebinar.topjava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Meal extends AbstractBaseEntity{

    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    private final Integer userID;


    public Meal(LocalDateTime dateTime, String description, int calories, Integer userID) {
        this(null, dateTime, description, calories, userID);
    }

    public Meal(Integer id, LocalDateTime dateTime, String description, int calories, Integer userID) {
        super(id); //после наследования от базового entity надо добавить super
       // this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.userID = userID;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    public Integer getUserID() {
        return userID;
    }

    public boolean isNew() {
        return id == null;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }
}
