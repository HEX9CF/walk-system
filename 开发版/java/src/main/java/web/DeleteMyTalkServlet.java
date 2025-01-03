package web;

import service.chatListService;
import service.secondChatService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteOwnReplyServlet")
public class DeleteOwnReplyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json; charset = utf-8");
        chatListService chatListService = new chatListService();
        int unique_id = Integer.parseInt(req.getParameter("unique_id"));
        int comment_id = Integer.parseInt(req.getParameter("comment_id"));
        secondChatService secondChatService = new secondChatService();
        secondChatService.deleteOwnReply(unique_id);
        int i = secondChatService.selectCount(comment_id);
        chatListService.updateCount(i, comment_id);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        this.doGet(req, resp);
    }
}