<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="blossom-taglib" prefix="blossom" %>
<%@ taglib uri="cms-taglib" prefix="cmsold" %>

<h1>${content.title}</h1>
<c:if test="${shoppingCart.numberOfItems eq 0}">
    The shopping cart is empty
</c:if>
<c:if test="${shoppingCart.numberOfItems > 0}">
    <table width="100%">
        <tr>
            <th align="left">Description</th>
            <th align="right">Quantity</th>
            <th align="right">Price</th>
            <th align="right">Line total</th>
        </tr>
        <c:forEach items="${shoppingCart.items}" var="item">
            <tr>
                <td>${item.product.title}</td>
                <td align="right">${item.quantity}</td>
                <td align="right">&euro; ${item.product.price}.00</td>
                <td align="right">&euro; ${item.price}.00</td>
            </tr>
        </c:forEach>
        <tr>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td align="right" colspan="3">
                <span style="font-weight:bold;font-size:120%;">Subtotal</span>
            </td>
            <td align="right">
                <span style="font-weight:bold;font-size:120%;">&euro; ${shoppingCart.totalPrice}.00</span>
            </td>
            <td></td>
        </tr>
        <tr>
            <td colspan="4" align="right">
                <br/>
                <br/>
                <a href="<cmsold:out nodeDataName="paymentLink" uuidToLink="relative" />.html">Proceed to payment &raquo;</a>
            </td>
        </tr>
    </table>
</c:if>
