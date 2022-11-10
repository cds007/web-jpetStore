<%--
  Created by IntelliJ IDEA.
  User: 22051
  Date: 2022/11/7
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
    <a href="main">Return to Main Menu</a>
</div>
<div class="Order" align="center">
    <table class="table-2 firstTable">
        <tr>
            <th align="center" colspan="2"><font size="4"><b>Order</b></font>
                <br />
                <font size="3"><b>
                    <fmt:formatDate value="${sessionScope.order.orderDate}" pattern="yyyy/MM/dd hh:mm:ss" />
                </b></font>
            </th>
        </tr>

        <tr>
            <th colspan="2">Billing Address</th>
        </tr>
        <tr>
            <td>First name:</td>
            <td><c:out value="${sessionScope.order.billToFirstName}" /></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><c:out value="${sessionScope.order.billToLastName}" /></td>
        </tr>
        <tr>
            <td>Address 1:</td>
            <td><c:out value="${sessionScope.order.billAddress1}" /></td>
        </tr>
        <tr>
            <td>Address 2:</td>
            <td><c:out value="${sessionScope.order.billAddress2}" /></td>
        </tr>
        <tr>
            <td>City:</td>
            <td><c:out value="${sessionScope.order.billCity}" /></td>
        </tr>
        <tr>
            <td>State:</td>
            <td><c:out value="${sessionScope.order.billState}" /></td>
        </tr>
        <tr>
            <td>Zip:</td>
            <td><c:out value="${sessionScope.order.billZip}" /></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><c:out value="${sessionScope.order.billCountry}" /></td>
        </tr>
        <tr>
            <th colspan="2">Shipping Address</th>
        </tr>
        <tr>
            <td>First name:</td>
            <td><c:out value="${sessionScope.order.shipToFirstName}" /></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><c:out value="${sessionScope.order.shipToLastName}" /></td>
        </tr>
        <tr>
            <td>Address 1:</td>
            <td><c:out value="${sessionScope.order.shipAddress1}" /></td>
        </tr>
        <tr>
            <td>Address 2:</td>
            <td><c:out value="${sessionScope.order.shipAddress2}" /></td>
        </tr>
        <tr>
            <td>City:</td>
            <td><c:out value="${sessionScope.order.shipCity}" /></td>
        </tr>
        <tr>
            <td>State:</td>
            <td><c:out value="${sessionScope.order.shipState}" /></td>
        </tr>
        <tr>
            <td>Zip:</td>
            <td><c:out value="${sessionScope.order.shipZip}" /></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><c:out value="${sessionScope.order.shipCountry}" /></td>
        </tr>

    </table>
    <br>
    <button class="buttonContinue" style="height:50px;width:100px;"><a  href="viewOrder">确认订单</a></button>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>

