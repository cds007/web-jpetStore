<%--
  Created by IntelliJ IDEA.
  User: 22051
  Date: 2022/11/7
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp"%>
<div class="Order" align="center">
    <h2><strong>请确认订单</strong></h2>
    <form action="conFirmOrderForm" method="post">
        <table class="table-2 firstTable"  summary="Meeting Results">
            <!--表头-->
            <thead>
            <tr>
                <th colspan=2 scope="col">Payment Details</th>
                <!-- <th scope="col">Division</th>
                <th scope="col">Suggestions</th> -->
            </tr>
            </thead>
            <!--表尾-->
            <tfoot>
            <tr>
                <td colspan="4">IE 6 users won't see the transparent background if the hack is not applied</td>
            </tr>
            </tfoot>
            <!--表格-->
            <tbody>
            <tr>
                <td>Card Type:</td>
                <td>
                    <select>
                        <option value="Visa" selected="selected">Visa</option>
                        <option value="MasterCard">MasterCard</option>
                        <option value="American Express">American Express</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Card Number:</td>
                <td>
                    <input type="text" name="creditCard" value="999999999999">* Use a fake number!
                </td>
            </tr>
            <tr>
                <td>Expiry Date (MM/YYYY):</td>
                <td>
                    <input type="text" name="expiryDate" value="12/03"/>
                </td>
            </tr>
            <thead>
            <tr>
                <th colspan=2 scope="col">Billing Address</th>
                <!-- <th scope="col">Division</th>
                <th scope="col">Suggestions</th> -->
            </tr>
            </thead>
            <tr>
                <td>First name:</td>
                <td>
                    <input type="text" name="billToFirstName" value="${sessionScope.order.billToFirstName}" />
                </td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td>
                    <input type="text" name="billToLastName" value="${sessionScope.order.billToLastName}" />
                </td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td>
                    <input type="text" size="40" name="billAddress1" value="${sessionScope.order.billAddress1}" />
                </td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td>
                    <input type="text" size="40" name="billAddress2" value="${sessionScope.order.billAddress2}" />
                </td>
            </tr>
            <tr>
                <td>City:</td>
                <td>
                    <input type="text" name="billCity" value="${sessionScope.order.billCity}" />
                </td>
            </tr>
            <tr>
                <td>State:</td>
                <td>
                    <input type="text" size="4" name="billState" value="${sessionScope.order.billState}" />
                </td>
            </tr>
            <tr>
                <td>Zip:</td>
                <td>
                    <input type="text" size="10" name="billZip" value="${sessionScope.order.billZip}" />
                </td>
            </tr>
            <tr>
                <td>Country:</td>
                <td>
                    <input type="text" size="15" name="billCountry" value="${sessionScope.order.billCountry}" />
                </td>
            </tr>

            <tr>
                <td colspan=2>
                    <input type="checkbox" name="shippingAddressRequired"/>
                    Ship to different address...
                </td>
            </tr>
            </tbody>
        </table>
        <br>
        <input type="submit" name="newOrder" value="继续" class="buttonContinue"/>
    </form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>