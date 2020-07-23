package servlets;

import entity.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@WebServlet("/user/list")
public class ServletShowUser extends HttpServlet {
    private static final Logger log = LogManager.getLogger(ServletShowUser.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        
        //create in DB
        List<String> users = DBUtil.dataToList(DBUtil.conn(), "SELECT * FROM users", "id", "username", "email");
        
        req.setAttribute("users", users);
        log.info("Users listed: {}",users);
        try {
            getServletContext().getRequestDispatcher("/user/controlPanel.jsp").forward(req, resp);
            
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
