<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="cms-taglib" prefix="cms" %>
<%@ taglib uri="blossom-taglib" prefix="blossom" %>

<div style="padding:5px;border: 1px solid lightgray;-moz-border-radius:4px;margin-bottom:10px;">
    <span style="display:block;font-size:20px;border-bottom:1px solid;margin-bottom:3px;"><cms:out nodeDataName="category" /></span>
    <table width="100%">
        <tr> 
            <th align="left">Title</th>
            <th align="left">Price</th>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.title}</td>
                <td align="right"><nobr>&euro; ${book.price}.00</nobr></td>
            </tr>
        </c:forEach>
    </table>
</div>