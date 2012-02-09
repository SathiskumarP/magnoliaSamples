<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="blossom-taglib" prefix="blossom" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<style type="text/css">
    .textinput {margin-bottom:8px;}
    form span {color:red;}
</style>

<h1>Contact Form</h1>

<form:form action="?" commandName="contactForm" method="POST">
    <blossom:pecid-input />
    Your Name<br/>
    <form:input path="name" cssClass="textinput" />&nbsp;<form:errors path="name" /><br/>
    Your E-mail<br/>
    <form:input path="email" cssClass="textinput" />&nbsp;<form:errors path="email" /><br/>
    Message&nbsp;<form:errors path="message" /><br/>
    <form:textarea path="message" cols="60" rows="20" cssClass="textinput" /><br/>
    <input type="submit" value="Send" />
</form:form>
