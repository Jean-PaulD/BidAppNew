package BidAppNew.controller;


import BidAppNew.domain.User;
import BidAppNew.services.impl.UserServiceImpl;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

@Controller    // This means that this class is a Controller
//@RequestMapping(path="/demo")
@WebServlet(name = "GetUser", urlPatterns = {"/GetUser"})
public class UserController extends HttpServlet {

    @Autowired
    UserServiceImpl userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            List<User> users = userService.getAllUsers();

            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();

            out.print(gson.toJson(users));
        }
    }


    @GetMapping(path="/getAllUsers99") // Map ONLY GET Requests
    public @ResponseBody
    String getAllUsers ( ){

        return "";
    }
}
