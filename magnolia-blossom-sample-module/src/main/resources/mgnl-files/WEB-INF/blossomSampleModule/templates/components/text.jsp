<%--@elvariable id="content" type="info.magnolia.jcr.util.ContentMap"--%>
<%@ include file="../includes/taglibs.jsp"%>

<h1>${content.title}</h1>

<p>${cmsfn:decode(content).body}</p>
