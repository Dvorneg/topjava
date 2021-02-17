package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface MealToServiceImpl {
    List<Meal> loadMeals();
    //void DeletedMeals();
    Meal getMealsById(int id);
    void deleteMealsById(int id);
    Meal updateUserData(int id, LocalDateTime dateTime, String description, int calories);
    int returnCaloriesNorm();
}
