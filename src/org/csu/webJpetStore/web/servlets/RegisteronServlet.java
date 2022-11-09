package org.csu.webJpetStore.web.servlets;

import org.csu.webJpetStore.domain.Account;
import org.csu.webJpetStore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisteronServlet extends HttpServlet {
    private String firstName;
    private  String lastName;
    private String email;
    private  String phone;
    private String address1;
    private  String address2;
    private String city;
    private  String state;
    private String status;
    private String zip;
    private String country;
    private String name;
    private String password;
    private String password2;
    private String languagePreference;
    private String favouriteCategoryId;
    private boolean listOption;
    private boolean bannerOption;
    private String bannername;
    /* 这里的bannername图片还没有加，登陆的时候会自动显示，dao里面可以搜索到 */
    private  String rmsg;
    private  String exchange;
    private  String exchange2;
    private static final String REGISTER_FORM ="/WEB-INF/jsp/account/RegisterForm.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account=new Account();
        this.firstName=req.getParameter("firstName");
        this.lastName=req.getParameter("lastName");
        this.email=req.getParameter("email");
        this.phone=req.getParameter("phone");
        this.address1=req.getParameter("address1");
        this.address2=req.getParameter("address2");
        this.city=req.getParameter("city");
        this.state=req.getParameter("state");
        this.status=req.getParameter("status");
        this.zip=req.getParameter("zip");
        this.country=req.getParameter("country");
        this.name=req.getParameter("name");
        this.password=req.getParameter("Password");
        this.password2=req.getParameter("Password2");
        this.languagePreference=req.getParameter("languagePreference");
        this.favouriteCategoryId=req.getParameter("favouriteCategoryId");
        this.exchange=req.getParameter("listOption");
        this.exchange2=req.getParameter("bannerOption");


        if (!validate()){
            req.setAttribute("rmsg",rmsg);
            req.getRequestDispatcher(REGISTER_FORM).forward(req,resp);
        }else {
            Account account1=new Account();
            account1.setFirstname(this.firstName);
            account1.setLastname(this.lastName);
            account1.setEmail(this.email);
            account1.setPhone(this.phone);
            account1.setPassword(this.password);
            account1.setUserid(this.name);
            account1.setName(this.name);
            account1.setLangpref(this.languagePreference);
            account1.setAddr1(this.address1);
            account1.setAddr2(this.address2);
            account1.setCity(this.city);
            account1.setCountry(this.country);
            account1.setState(this.state);
            account1.setStatus(this.status);
            account1.setZip(this.zip);
            account1.setFavcategory(this.favouriteCategoryId);
            account1.setMylistopt(this.listOption);
            account1.setBanneropt(this.bannerOption);
            account1.setBannername("0");
            AccountService accountService=new AccountService();
            boolean result=accountService.insertAccount(account1);
            if (result==true){
                resp.sendRedirect("loginForm");
            }else{
                this.rmsg="注册失败！";
                req.setAttribute("msg",this.rmsg);
                req.getRequestDispatcher(REGISTER_FORM).forward(req,resp);
            }
        }
    }
    private boolean validate(){
        if (this.name==null || this.name==""){
            this.rmsg="输入的用户名不能为空！";
            return false;
        }
        if (this.password==null || this.password=="") {
            this.rmsg = "输入的密码不可以为空！";
            return false;
        }
        if (this.password2==null || this.password2=="") {
            this.rmsg = "输入的重复密码不能为空！";
            return false;
        }

/*        if (this.password == this.password2){
        }else {
            this.rmsg="输入密码不一致，请检查！";
            return false;
        }
为什么这里两个全局变量始终说不相等？
 */
        if (this.email==null || this.email==""){
            this.rmsg="输入的email不能为空！";
            return false;
        }
        if (this.phone==null || this.phone==""){
            this.rmsg="输入的名字不能为空！";
            return false;
        }
        if (this.address1==null || this.address1==""){
            this.rmsg="输入的address1不能为空！";
            return false;
        }
        if (this.city==null || this.city==""){
            this.rmsg="输入的city不能为空！";
            return false;
        }
        if (this.state==null || this.state==""){
            this.rmsg="输入的state不能为空！";
            return false;
        }
        if (this.zip==null || this.zip==""){
            this.rmsg="输入的zip不能为空！";
            return false;
        }
        if (this.country==null || this.country==""){
            this.rmsg="输入的country不能为空！";
            return false;
        }
        if (this.languagePreference==null || this.languagePreference==""){
            this.rmsg="输入的languagePreference不能为空！";
            return false;
        }
        if (this.exchange=="1"){
            this.listOption=true;
        }else {
            this.listOption=false;
        }
        if (this.exchange2=="1"){
            this.bannerOption=true;
        }else {
            this.bannerOption=false;
        }
        return true;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
