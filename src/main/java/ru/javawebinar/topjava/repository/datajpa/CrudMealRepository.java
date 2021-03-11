package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Meal m WHERE m.id=:id")
    int delete(@Param("id") int id);


    @Transactional
    @Modifying
    //@Query(value = "SELECT * FROM meals WHERE date_time >= :startDate AND date_time <= :endDate", nativeQuery = true)
    @Query(value = "SELECT * FROM meals WHERE date_time >= :startDate AND date_time <= :endDate AND user_id=:user_id_par", nativeQuery = true)
    List<Meal> getBetweenHalfOpen(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("user_id_par") int userId);


}
