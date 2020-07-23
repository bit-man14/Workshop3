package servlets;

import DAO.UserDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@WebServlet("/user/delete")
public class ServletDelUser extends HttpServlet {
    private static final Logger log = LogManager.getLogger(ServletDelUser.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        
        //delete from DB
        UserDao userDao = new UserDao();
        String oldName=userDao.getUserData(userId,3);
        String oldEmail=userDao.getUserData(userId,2);
        userDao.removeUserData(userId);
        log.info("User id={}, Name={}, email={} deleted.",userId,oldName,oldEmail);
        resp.sendRedirect("/user/list");
    }
}
