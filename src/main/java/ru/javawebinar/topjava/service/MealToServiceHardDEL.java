package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealToServiceImpl;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class MealToServiceHardDEL {

    private List<Meal> meals;

/*    public MealToServiceHard() {

        meals = Arrays.asList(
                *//* Meal[] meals= *//*
                new Meal( LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new Meal( LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new Meal( LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new Meal( LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)  );

       // this.meals = meals;
    }*/


    public List<Meal> loadMeals() {
        return meals;
    }


    public Meal getMealsById(int id) {
        for (int i = 0; i <meals.size() ; i++) {
            if(meals.get(i).getId()==id )
                return meals.get(i);
        }
        return null;

       // return meals.get(id);
    }


    public void deleteMealsById(int id) {

    }


    public Meal updateUserData(int id, LocalDateTime dateTime, String description, int calories) {
        return null;
    }



}
