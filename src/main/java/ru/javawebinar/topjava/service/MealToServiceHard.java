package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class MealToServiceHard implements MealToServiceImpl{

    @Override
    public List<Meal> loadMeals() {
        List<Meal> meals = Arrays.asList(
       /* Meal[] meals= */  new Meal(1, LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new Meal(2,LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new Meal(3, LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new Meal(4,LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new Meal(5, LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new Meal(6, LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new Meal(7,LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)  );

        return meals;
    }

    @Override
    public Meal getMealsById(long id) {
        return null;
    }

    @Override
    public void deleteMealsById(long id) {

    }

    @Override
    public Meal updateUserData(int id, LocalDateTime dateTime, String description, int calories) {
        return null;
    }

    public  int returnCaloriesNorm(){
        return 2000;
    }

}
