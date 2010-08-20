<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="cms-taglib" prefix="cms" %>
<%@ taglib uri="blossom-taglib" prefix="blossom" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="sv" lang="sv">
<head>
<title>${content.title}</title>
<style type="text/css">

	body { font-family: arial,sans-serif; font-size: 13px; background-color: #e8e8f0; }
    a {color: #4040ff}
    a:visited {color: #4040ff;}
    #container {margin-left:50px; width:875px;}
    #content {background-color:white;}
    #logo {font-size:32px;padding:50px 0px 8px 10px;background-color:#ffffff;}
	#main { float:left; width: 595px; background-color: #ffffff; padding: 15px; }
	#rightcolumn { float:left; margin-left:20px;width: 200px; background-color: #ffffff; padding: 15px; }
    #menu {background-color:#ffffff;margin-bottom:10px;overflow:hidden;}
    #menu ul {float:left;list-style:none outside none;margin:0;position:relative;width:700px;padding-left:20px;}
    #menu ul li {float:left;font-family:arial,sans-serif;font-size:170%;margin:0 15px 0 0;padding:0 0 5px;position:relative;}
    #menu a {text-decoration:none;}
    #copyright {padding:15px;clear:both;text-align:center;color: #737373;}

</style>
</head>
<body>
	<cms:mainBar adminButtonVisible="true" dialog="main-properties" label="Properties" />

    <div id="container">

        <div id="logo">Visit Gothenburg</div>

        <div id="menu">
            <cms:setNode var="sections" path="/sections" />
            <ul>
            <c:forEach items="${sections.children}" var="section">
                <li><a href="${section.handle}.html">${section.name}</a></li>
            </c:forEach>
            </ul>
        </div>

        <div id="content">

            <div id="main">
                <cms:contentNodeIterator contentNodeCollectionName="main">
                    <cms:includeTemplate/>
                </cms:contentNodeIterator>
                <cms:newBar contentNodeCollectionName="main" paragraph="text,book,tour,shoppingCartView,purchase,contact"/>
            </div>

            <div id="rightcolumn">
                <cms:contentNodeIterator contentNodeCollectionName="right">
                    <cms:includeTemplate/>
                </cms:contentNodeIterator>
                <cms:newBar contentNodeCollectionName="right" paragraph="text,shoppingCart,bookcategory"/>
            </div>

            <div id="copyright">Site produced in cooperation with the tourist board of Gothenburg</div>

            </div>
    </div>
</body>
</html>
