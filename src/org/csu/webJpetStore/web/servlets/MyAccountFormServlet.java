package org.csu.webJpetStore.web.servlets;

import org.csu.webJpetStore.domain.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyAccountFormServlet extends HttpServlet {
    private static final String MY_ACCOUNT_FORM ="/WEB-INF/jsp/account/MyAccountForm.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession=req.getSession();
        Account loginAccount=(Account) httpSession.getAttribute("loginAccount");
        if (loginAccount==null){
            resp.sendRedirect("MyAccountForm");
            /*如果个人账户页面的名称不是这个还要进一步改一下*/
        }else{

            req.getRequestDispatcher(MY_ACCOUNT_FORM).forward(req,resp);
        }
    }
    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
