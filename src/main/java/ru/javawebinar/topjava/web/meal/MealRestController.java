package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.service.UserService;

import java.util.List;

@Controller
public class MealRestController {

/*5.1: Отдать свою еду (для отображения в таблице, формат List<MealTo>), запрос БЕЗ параметров
5.2: Отдать свою еду, отфильтрованную по startDate, startTime, endDate, endTime
5.3: Отдать/удалить свою еду по id, параметр запроса - id еды. Если еда с этим id чужая или отсутствует - NotFoundException
5.4: Сохранить/обновить еду, параметр запроса - Meal. Если обновляемая еда с этим id чужая или отсутствует - NotFoundException
5.5: Сервлет мы удалим, а контроллер останется, поэтому возвращать List<MealTo> надо из контроллера. И userId принимать в контроллере НЕЛЬЗЯ (иначе - для чего аторизация?).
            5.6: В концепции REST при update дополнительно принято передавать id (см. AdminRestController.update)
5.7: Для получения всей своей еды сделайте отдельный getAll без применения фильтра*/


    @Autowired
    private MealService service;

    public List<Meal> getAll() {
        return service.getAll();
    }


    public Meal get(int id) {
        return service.get(id);
    }


    public Meal create(Meal user) {
        return service.create(user);
    }


    public void delete(int id) {
        service.delete(id);
    }


    public void update(Meal meal) {
        service.update(meal);
    }


/*    public Meal getByMail(String email) {
        return service.getByMail(email);
    }*/

}