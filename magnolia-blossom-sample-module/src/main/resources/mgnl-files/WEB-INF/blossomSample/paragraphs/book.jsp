<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="cms-taglib" prefix="cms" %>
<%@ taglib uri="blossom-taglib" prefix="blossom" %>
<cms:editBar />

<h2>${book.title}</h2>

by ${book.author}<br/>

${book.description}<br/>


<br/><br/>
<form action="?">
    <blossom:pecid-input />
    Quantity: <input type="hidden" name="action" value="add" />
    <input type="text" name="quantity" size="4" />
    <input type="submit" value="Add to cart" />
</form>
