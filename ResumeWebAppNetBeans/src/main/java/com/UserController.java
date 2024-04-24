package com;

import com.dao.inter.UserDaoInter;
import com.entity.User;
import com.main.Context;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    private UserDaoInter userDao = Context.instanceUserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.valueOf(request.getParameter("id").trim());
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        
        User user = userDao.getById(id);
        user.setName(name);
        user.setSurname(surname);
        
        userDao.updateUser(user);
        
        response.sendRedirect("user.jsp");
    }
}
