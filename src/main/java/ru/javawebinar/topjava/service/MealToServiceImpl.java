package ru.javawebinar.topjava.service;

public interface MealToServiceImpl {
    //ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userId);
    void deleteUserById(long userId);
    void changeUserData(String name, long id, int level);
}
