package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private static final String INSERT_OR_EDIT = "/mealEdit.jsp";
    private static final String ALL_MEALS = "/meals.jsp";
    private MealRepository repository=new MealRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");

        String forward = "";
        String action = request.getParameter("action");
        if (action==null)
            action="start";

        if (action.equalsIgnoreCase("edit")  ) {
            log.debug("edit to meals");
            forward = INSERT_OR_EDIT;
            int mealId =Integer.valueOf( request.getParameter("mealId"));
            Meal meal = repository.getMealsById(mealId);
            log.debug("meal:"+meal);
            request.setAttribute("meal", meal);
            //System.out.print("!!!!!!! " + action + "!!!!!!!!!!!" + mealId);
        }
        else if(action.equalsIgnoreCase("del")) {
            int mealId =Integer.valueOf( request.getParameter("mealId"));
            repository.delete(mealId);
            response.sendRedirect("meals");
            return;
        }
        else if(action.equalsIgnoreCase("insert") ) {
            log.debug("insert to meals");
            forward = INSERT_OR_EDIT;
            //request.setAttribute("meal", meal);


            final Meal meal =  new Meal(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), "", 1000);
                 //   repository.getMealsById(  getId(request) );

            log.debug("meal:"+meal);
            request.setAttribute("meal", meal);
            request.getRequestDispatcher(forward).forward(request, response);

        }
        else {
            forward = ALL_MEALS;
            System.out.println(action+" = > ELSE ^^^^^^^");
        }

//        request.getRequestDispatcher("/users.jsp").forward(request, response);
        response.setContentType("text/html");
        List<MealTo> meals = new ArrayList<>();
        meals.addAll(MealsUtil.filteredByStreams( repository.getAll(), LocalTime.MIN, LocalTime.MAX, MealsUtil.returnCaloriesNorm()));
        request.setAttribute("meals", meals);
        log.debug("meals:"+meals);
        request.getRequestDispatcher(forward).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        System.out.println("DO post!");
       //meal.setFirstName(request.getParameter("firstName"));
       // meal.setLastName(request.getParameter("lastName"));
        LocalDateTime dob = null;
        try {
            //dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
            dob =  LocalDateTime.parse(request.getParameter("dateTime"));
            if (dob==null)
                System.out.println("Error ! Data NULL!!!");
            //meal.setDob(dob);
        } catch (Exception e) {
            e.printStackTrace();
        }
      //  meal.setEmail(request.getParameter("email"));
        String mealId = request.getParameter("mealId");
        if (mealId==null)
            System.out.println("Error ! user id  NULL!!!");
    //    MealRepository repository = new MealRepository();

        Meal meal = new Meal(Integer.parseInt(mealId),dob, request.getParameter("description"),Integer.parseInt(request.getParameter("calories")));

        if(mealId == null || mealId.isEmpty())
        {
            repository.save(meal);
        }
        else
        {
           // meal.setUserid(Integer.parseInt(userid));
            repository.update(Integer.valueOf(mealId), meal);
        }

        RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
        //request.setAttribute("users", repository.getAll());

        List<MealTo> meals = new ArrayList<>();
        meals.addAll(MealsUtil.filteredByStreams( repository.getAll(), LocalTime.MIN, LocalTime.MAX, MealsUtil.returnCaloriesNorm()));
        request.setAttribute("meals", meals);

       //response.sendRedirect("meals");
      response.sendRedirect("meals");
      // view.forward(request, response);
        //request.getRequestDispatcher(ALL_MEALS).forward(request, response);
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("mealId"));
        return Integer.parseInt(paramId);
    }
}