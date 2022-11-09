<%--
  Created by IntelliJ IDEA.
  User: 22051
  Date: 2022/11/8
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp"%>
/ *这个地方我的表头和表尾的文件放置的位置不一样，这个地方也要随之做修改  */
<div class="w">
    <div class="user-content">
        <div class="user-title">用户登录</div>
        <form action="signon" class="user-form"  method="post">
            <c:if test="${requestScope.msg != null}">
                <div class="user-form-error">
                    <i class="fa-solid fa-triangle-exclamation error-icon"></i>
                    <p class="error-msg">${requestScope.msg}</p>
                </div>
            </c:if>
            <div class="user-form-item">
                <label for="username" class="user-form-label">
                    <i class="fa-regular fa-user"></i>
                </label>
                <input type="text" class="user-form-input" name="username" id="username" placeholder="请输入用户名" autocomplete="off">
            </div>
            <div class="user-form-item">
                <label for="password" class="user-form-label" >
                    <i class="fa-solid fa-lock"></i>
                </label>
                <input type="password" class="user-form-input" name="password" id="password" placeholder="请输入密码" autocomplete="off">
            </div>
            <div class="user-input-item">
                <input type="submit" value="登录" class="user-form-submit">
            </div>
            <div class="user-form-link">
                <a href="register" class="link">用户注册</a>
                /*我这里用了一个绝对定位，可以根据情况修改一下*/
            </div>

        </form>

    </div>

</div>
/* 加上表头和表尾*/
<%@ include file="../common/IncludeBottom.jsp"%>
