<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="blossom-taglib" prefix="blossom" %>

<h1>Customer details</h1>

<form>
<table>
    <tr>
        <td>First name</td>
        <td><input type="text" class="textinput" /></td>
    </tr>
    <tr>
        <td>Last name</td>
        <td><input type="text" class="textinput" /></td>
    </tr>
    <tr>
        <td>Address Line 1</td>
        <td><input type="text" class="textinput" /></td>
    </tr>
    <tr>
        <td>Address Line 2</td>
        <td><input type="text" class="textinput" /></td>
    </tr>
    <tr>
        <td>Phone Number</td>
        <td><input type="text" class="textinput" /></td>
    </tr>
    <tr>
        <td>E-Mail</td>
        <td><input type="text" class="textinput" /></td>
    </tr>
    <tr>
        <td colspan="2" align="right"><input type="button" value="Place order" /></td>
    </tr>
</table>
</form>
