package servlets;

import DAO.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@WebServlet("/user/edit")
public class ServletEditUser extends HttpServlet {
    private static final Logger log = LogManager.getLogger(ServletEditUser.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //data to edit
        int id = Integer.parseInt(req.getParameter("userId"));//current ID
        String name = req.getParameter("userName");//new name
        String email = req.getParameter("userEmail");//new email
        
        //String pass=req.getParameter("userPass"); //pass not to be changed
        
        User user = new User();//new user object to be found and updated in DB
        UserDao userDao = new UserDao();
        String oldName=userDao.getUserData(id,3);
        String oldEmail=userDao.getUserData(id,2);
        //1-id,2-email,3-username,4-password
        if (name.equals("")) {
            name = oldName;
        }
        if (email.equals("")) {
            email = oldEmail;
        }
        user.setId(id);
        user.setUserName(name);
        user.setEmail(email);
        user.setPassword(userDao.getUserData(id,4));//the same pass
        log.info("Data changed. Old name={}. New Name={}",oldName,name);
        log.info("Data changed. Old email={}. New email={}",oldEmail,email);
        userDao.update(user);//update in DB
        
        req.setAttribute("user", user);
        
        try {
            getServletContext().getRequestDispatcher("/user/list").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
