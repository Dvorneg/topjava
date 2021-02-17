package ru.javawebinar.topjava.repository;


import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MealRepository {
    private final Map<Integer, Meal> repository = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        for (Meal meal : MealsUtil.MealToServiceHard()) {
            // repository.put( counter.getAndDecrement(),meal);
            save(meal);
        }
        //todo stream 17/02
    }

    public Meal save(Meal meal) {
        System.out.println(counter.get());
        return repository.put(counter.getAndIncrement(),meal);
    }

/*    public boolean delete(int id) {
    }*/

    public Meal getMealsById ( int id){
        for (int i = 0; i <repository.size() ; i++) {
            if(repository.get(i).getId()==id )
                return repository.get(i);
        }
        return null;
    }

        public List<Meal> getAll () {
            return (new ArrayList<>( repository.values()));
        }
    }
