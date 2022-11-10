package org.csu.webJpetStore.web.servlets;

import org.csu.webJpetStore.domain.Account;
import org.csu.webJpetStore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class SignonServlet extends HttpServlet {
    private String username;
    private  String password;
    private  String msg;
    private static final String LOGIN_FORM ="/WEB-INF/jsp/account/SignonForm.jsp";


    //待会跳转到main
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.username=req.getParameter("username");
        this.password=req.getParameter("password");
        Account loginAccount=new Account();
        HttpSession session=req.getSession();
        session.setAttribute("account",loginAccount);
        if (!validate()){
            req.setAttribute("msg",this.msg);
            req.getRequestDispatcher(LOGIN_FORM).forward(req,resp);
        }else{
            AccountService accountService=new AccountService();
            loginAccount=accountService.getaccount(username,password);
            if (loginAccount==null){
                this.msg="用户名或密码错误！";
                req.setAttribute("msg",this.msg);
                session.setAttribute("account",null);
                req.getRequestDispatcher(LOGIN_FORM).forward(req,resp);
            }else {
                loginAccount.setPassword(null);
//                loginAccount.setPassword(null);
                session.setAttribute("account",loginAccount);
                req.getRequestDispatcher(MAIN).forward(req, resp);
                /*这个地方登录成功会跳转到mainform中，也就是主页面，用的是dopost方法，而mainForm对应的servlet也应该可以支持dopost方法
                 * 否则就会报405的错误
                 * 此时mainForm对应的xml文件的url也应该是mainForm，否则这里的跳转请求要改一下 */
            }
        }
    }

    private boolean validate(){
        if (this.username==null || this.username==""){
            this.msg="输入的用户名不能为空！";
            return false;
        }
        if (this.password==null || this.password==""){
            this.msg="输入的密码不能为空！";
            return false;
        }
        return true;
    }
}
