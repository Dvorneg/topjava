package ru.javawebinar.topjava.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@NamedQueries({
/*        @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.BY_EMAIL, query = "SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.email=?1"),
        @NamedQuery(name = Meal.ALL_SORTED, query = "SELECT m FROM Meal m LEFT JOIN FETCH m.user.id ORDER BY m.dateTime, m.calories"),*/
        @NamedQuery(name = Meal.ALL_SORTED, query = "SELECT m FROM Meal m ORDER BY m.dateTime"),
})

@Entity
@Table(name = "meals", uniqueConstraints = {@UniqueConstraint(columnNames = "user_id", name = "meals_unique_user_datetime_idx")})
public class Meal extends AbstractBaseEntity {

    public static final String ALL_SORTED = "Meal.getAllSorted";

    @Column(name = "DATE_TIME", nullable = false, columnDefinition = "timestamp default now()")
    @NotNull
    private LocalDateTime dateTime;

    @Column(name = "description", nullable = false, unique = false)
    @NotBlank
    @Size(max = 150)
    private String description;

    @Column(name = "calories", nullable = false, unique = false, columnDefinition = "int default 500")
    @Range(min = 10, max = 10000)
    private int calories;

/*    @CollectionTable(name = "users", joinColumns = @JoinColumn(name = "id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"id"}, name = "user_roles_unique_idx")})*/

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public Meal() {
    }

    public Meal(LocalDateTime dateTime, String description, int calories) {
        this(null, dateTime, description, calories);
    }

    public Meal(Integer id, LocalDateTime dateTime, String description, int calories) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
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

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
