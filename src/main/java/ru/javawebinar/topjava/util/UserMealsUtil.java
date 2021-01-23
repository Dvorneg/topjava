package ru.javawebinar.topjava.util;


import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> meals = Arrays.asList(
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
        );

        List<UserMealWithExcess> mealsTo = filteredByCycles(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        mealsTo.forEach(System.out::println);

//        System.out.println(filteredByStreams(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));
    }

    /*     -  должны возвращаться только записи между `startTime` и `endTime`
            -  поле `UserMealWithExcess.excess` должно показывать,
    превышает ли сумма калорий за весь день значение `caloriesPerDay`*/
    public static List<UserMealWithExcess> filteredByCycles(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        List<UserMealWithExcess> resault = new ArrayList();
        Map<LocalDate, Integer> dayCalories = new HashMap<>();
        for (UserMeal meal : meals) {
            if (dayCalories.get(meal.getDateTime().toLocalDate())==null)
                dayCalories.put(meal.getDateTime().toLocalDate(), meal.getCalories());
            else
                dayCalories.put(meal.getDateTime().toLocalDate(), dayCalories.get(meal.getDateTime().toLocalDate())+ meal.getCalories());

        }
        for (UserMeal meal : meals) {
            if ( TimeUtil.isBetweenHalfOpen(meal.getDateTime().toLocalTime(),startTime, endTime ))  {
                resault.add(new UserMealWithExcess(meal.getDateTime(), meal.getDescription(), meal.getCalories(), dayCalories.get(meal.getDateTime().toLocalDate()) > caloriesPerDay));
            }
        }
        return resault;
    }
/*    UserMealWithExcess{dateTime=2020-01-30T10:00, description='Завтрак', calories=500, excess=true}
    UserMealWithExcess{dateTime=2020-01-31T10:00, description='Завтрак', calories=1000, excess=true}*/

    public static List<UserMealWithExcess> filteredByStreams(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO Implement by streams
        return null;
    }
}
