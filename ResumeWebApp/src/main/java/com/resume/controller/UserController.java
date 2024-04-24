package com.resume.controller;

import com.dao.inter.UserDaoInter;
import com.entity.User;
import com.main.Context;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet(name = "UserController", urlPatterns = {"/user-detail"})
public class UserController extends HttpServlet {

    private UserDaoInter userDao = Context.instanceUserDao();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.valueOf(request.getParameter("id").trim());
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String profileDesc = request.getParameter("profileDescription");
        String address = request.getParameter("address");
        String birthdate = request.getParameter("birthdate");

        Date bd = new Date(sdf.parse(birthdate).getTime());

        User user = userDao.getById(id);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setProfileDesc(profileDesc);
        user.setAddress(address);
        user.setBirthDate(bd);

        userDao.updateUser(user);

        response.sendRedirect("users.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String action = request.getParameter("action");

        if (action.equals("edit")){
            try {
                String userIdStr = request.getParameter("id");
                if (userIdStr == null || userIdStr.trim().isEmpty()) {
                    throw new IllegalArgumentException("id is not specified");
                }

                Integer userId = Integer.parseInt(request.getParameter("id"));

                UserDaoInter userDao = Context.instanceUserDao();
                User u = userDao.getById(userId);
                if (u == null) {
                    throw new IllegalArgumentException("There is no user with this id");
                }

                request.setAttribute("user", u);
                request.getRequestDispatcher("user-detail.jsp").forward(request,response);
            }catch (Exception ex){
                response.sendRedirect("error.jsp?msg=" + ex.getMessage());
            }
        } else if (action.equals("delete")) {
            String userIdStr = request.getParameter("id");
            if (userIdStr == null || userIdStr.trim().isEmpty()) {
                throw new IllegalArgumentException("id is not specified");
            }

            Integer userId = Integer.parseInt(request.getParameter("id"));

            UserDaoInter userDao = Context.instanceUserDao();

            userDao.removeUser(userId);

            response.sendRedirect("users.jsp");
        }
    }
}
