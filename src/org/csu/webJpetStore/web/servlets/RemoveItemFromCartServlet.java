package org.csu.webJpetStore.web.servlets;

import org.csu.webJpetStore.domain.Account;
import org.csu.webJpetStore.domain.Cart;
import org.csu.webJpetStore.domain.Item;
import org.csu.webJpetStore.service.LogService;
//import org.csu.webJpetStore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RemoveItemFromCartServlet extends HttpServlet {

    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    private String workingItemId;
    private Cart cart;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        workingItemId = request.getParameter("workingItemId");

        HttpSession session = request.getSession();
        cart = (Cart)session.getAttribute("cart");

        //后台移除
        Item item = cart.removeItemById(workingItemId);

        if(item == null) {
            session.setAttribute("message", "Attempted to remove null CartItem from Cart.");

            Account account = (Account)session.getAttribute("account");
            /**日志相关**/
            if(account != null){
                HttpServletRequest httpRequest= request;
                String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                        + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

                LogService logService = new LogService();
                String logInfo = logService.logInfo(" ") + strBackUrl + " 物品为空，不能移除";
                logService.insertLogInfo(account.getUserid(), logInfo);
            }

            request.getRequestDispatcher(ERROR).forward(request, response);
        }else{

            Account account = (Account)session.getAttribute("account");
              /**日志相关**/
            if(account != null){
                HttpServletRequest httpRequest= request;
                String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                        + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

                LogService logService = new LogService();
                String logInfo = logService.logInfo(" ") + strBackUrl + " " + item + " 已从购物车中移除";
                logService.insertLogInfo(account.getUserid(), logInfo);
            }
            request.getRequestDispatcher(VIEW_CART).forward(request, response);
        }
    }
}
