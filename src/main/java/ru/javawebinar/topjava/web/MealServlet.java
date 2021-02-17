package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.service.MealToServiceHardDEL;
import ru.javawebinar.topjava.repository.MealToServiceImpl;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private static final String INSERT_OR_EDIT = "/mealEdit.jsp";
    private static final String ALL_MEALS = "/meals.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");

        String forward = "";
        String action = request.getParameter("action");
        if (action==null)
            action="start";
        MealRepository repository = new MealRepository();
        // System.out.printf("action"+action.toString() );

        if (action.equalsIgnoreCase("edit")) {
            log.debug("edit to meals");
            forward = INSERT_OR_EDIT;
            int mealId =Integer.valueOf( request.getParameter("mealId"));
            Meal meal = repository.getMealsById(mealId);
            log.debug("meal:"+meal);
            request.setAttribute("meal", meal);
            System.out.print("!!!!!!! " + action + "!!!!!!!!!!!" + mealId);
        }
        else {
            forward = ALL_MEALS;
        }

//        request.getRequestDispatcher("/users.jsp").forward(request, response);

        response.setContentType("text/html");
        //Integer i = service.returnCaloriesNorm();
        //  request.setAttribute("сaloriesNorm", service.returnCaloriesNorm());
/*        String varTextA = "Hello World!";
        request.setAttribute("textA", varTextA);
        String varTextB = "It JSP.";
        request.setAttribute("textB", varTextB);*/

        //List<MealTo> meals = MealsUtil.friendsAsArray(); //Заменяем ниже
        List<MealTo> meals = new ArrayList<>();
        meals.addAll(MealsUtil.filteredByStreams( repository.getAll(), LocalTime.MIN, LocalTime.MAX, MealsUtil.returnCaloriesNorm()));
        request.setAttribute("meals", meals);
        // RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        // dispatcher.forward(request, response);
        log.debug("meals:"+meals);
        request.getRequestDispatcher(forward).forward(request, response);
        //request.getRequestDispatcher("/meals.jsp").forward(request, response);
        //response.sendRedirect("meals.jsp",response);

    }
}

   /* protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(request.getParameter("userId"));
            dao.deleteUser(userId);
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int userId = Integer.parseInt(request.getParameter("userId"));
            User user = dao.getUserById(userId);
            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }*/

