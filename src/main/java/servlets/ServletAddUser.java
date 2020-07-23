package servlets;

import DAO.UserDao;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/add")
public class ServletAddUser extends HttpServlet {
    private static final Logger log = LogManager.getLogger(ServletAddUser.class);
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("userName");
        String email = req.getParameter("userEmail");
        String pass = req.getParameter("userPass");
       
        User user = new User();
        user.setUserName(name);
        user.setEmail(email);
        user.setPassword(pass);
        log.info("User created. Name={}, email={}",name,email);
        //create in DB
        UserDao userDao = new UserDao();//nowy "zestaw narzędzi" do DB
        userDao.create(user);
        resp.sendRedirect("/user/list");
    }
}
