import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.*;

public class HelloServlet extends HttpServlet {

    List<String> todo = new ArrayList<>();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {
        PrintWriter out = resp.getWriter();

        out.write("<html><body>");
        out.write("<form action='/' method='POST'>");
        out.write("<input name='todoText' type='text'>");
        out.write("<button type='submit'>Submit</button>");
        out.write("</form>");
        out.write("</body></html>");

        for (String item : todo) {
            out.write("<li>");
            out.write(item);
            out.write("</li>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        todo.add(req.getParameter("todoText"));
        resp.sendRedirect("/");
    }
}