<%--
  Created by IntelliJ IDEA.
  User: 22051
  Date: 2022/11/9
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp"%>

<c:set var="user" value="${sessionScope.loginaccount}"/>
<form  action="Register" class="user-form"  method="post">
    <c:if test="${requestScope.rmsg != null}">
        <div class="user-form-error">
            <p class="error-msg">${requestScope.rmsg}</p>
        </div>
    </c:if>
    <h3>User Information</h3>
    <table>
        <tr>
            <p class="error-msg">User ID:${loginaccount.name}</p>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="text" name="Password" /></td>
        </tr>
        <tr>
            <td>Repeat Password:</td>
            <td><input type="text" name="Password2" /></td>
        </tr>
    </table>

    <h3>Account Information</h3>
    <table>
        <tr>
            <td>First name:</td>
            <td><input type="text" name="firstName" /></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><input type="text" name="lastName" /></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" /></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><input type="text" name="phone" /></td>
        </tr>
        <tr>
            <td>Address 1:</td>
            <td><input type="text" name="address1" /></td>
        </tr>
        <tr>
            <td>Address 2:</td>
            <td><input type="text" name="address2" size="40" /></td>
        </tr>
        <tr>
            <td>City:</td>
            <td><input type="text" name="city" /></td>
        </tr>
        <tr>
            <td>State:</td>
            <td><input type="text" name="state" size="4" /></td>
        </tr>
        <tr>
            <td>Zip:</td>
            <td><input type="text" name="zip" size="10" /></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><input type="text" name="country" size="15" /></td>
        </tr>
    </table>

    <h3>Profile Information</h3>

    <table>
        <tr>
            <td>Language Preference:</td>
            <td><select name="languagePreference">
                <option value="CHINESE">CHINESE</option>
                <option  value="ENGLISH">ENGLISH</option>
            </select></td>
        </tr>
        <tr>
            <td>Favourite Category:</td>
            <td><select name="favouriteCategoryId">
                <option value="FISH">FISH</option>
                <option selected="selected" value="DOGS">DOGS</option>
                <option value="REPTILES">REPTILES</option>
                <option value="CATS">CATS</option>
                <option value="BIRDS">BIRDS</option>
            </select></td>
        </tr>
        <tr>
            <td>Enable MyList</td>
            <td><input type="checkbox" name="listOption"  value="1"/></td>
        </tr>
        <tr>
            <td>Enable MyBanner</td>
            <td><input type="checkbox" name="bannerOption" value="1"/></td>
        </tr>

    </table>
    <div class="user-input-item">
        <input type="submit" value="开始注册" class="user-form-submit">
    </div>
</form>
</div>

