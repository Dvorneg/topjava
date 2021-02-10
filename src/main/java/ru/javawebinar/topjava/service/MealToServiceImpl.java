package ru.javawebinar.topjava.service;

public interface MealToServiceImpl {
    void loadUsers();
    void DeletedUsers();
    void getUserById(long userId);
    void deleteUserById(long userId);
    void changeUserData(String name, long id, int level);
}
