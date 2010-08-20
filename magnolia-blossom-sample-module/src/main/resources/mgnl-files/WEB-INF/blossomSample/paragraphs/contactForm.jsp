<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="cms-taglib" prefix="cms" %>
<%@ taglib uri="blossom-taglib" prefix="blossom" %>
<cms:editBar />

<style type="text/css">
    .textinput {margin-bottom:8px;}
</style>

<h1>Contact Form</h1>

<form action="?">
    <blossom:pecid-input />
    Your Name<br/>
    <input type="text" name="name" class="textinput" /><br/>
    Your E-mail<br/>
    <input type="text" name="email" class="textinput" /><br/>
    Message<br/>
    <textarea name="message" cols="60" rows="20" class="textinput"></textarea><br/>
    <input type="submit" value="Send" />
</form>
