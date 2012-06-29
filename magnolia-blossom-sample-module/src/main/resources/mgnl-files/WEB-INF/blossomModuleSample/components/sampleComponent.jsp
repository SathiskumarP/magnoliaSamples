<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://magnolia-cms.com/taglib/templating-components/cms" prefix="cms" %>
<%@ taglib uri="http://magnolia-cms.com/taglib/templating-components/cmsfn" prefix="cmsfn" %>
<%@ taglib uri="blossom-taglib" prefix="blossom" %>

<h1>${cmsfn:decode(content).title}</h1>

<p>${cmsfn:decode(content).body}</p>
