package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface MealToServiceImpl {
    List<Meal> loadMeals();
    //void DeletedMeals();
    Meal getMealsById(long id);
    void deleteMealsById(long id);
    Meal updateUserData(int id, LocalDateTime dateTime, String description, int calories);
     int returnCaloriesNorm();
}
