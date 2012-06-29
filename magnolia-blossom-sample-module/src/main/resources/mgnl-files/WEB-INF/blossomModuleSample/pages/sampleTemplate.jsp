<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://magnolia-cms.com/taglib/templating-components/cms" prefix="cms" %>
<%@ taglib uri="http://magnolia-cms.com/taglib/templating-components/cmsfn" prefix="cmsfn" %>
<%@ taglib uri="blossom-taglib" prefix="blossom" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="sv" lang="sv">
<head>
    <title>${content.title}</title>
    <style type="text/css">

        body { font-family: "Lucida Sans Unicode","Lucida Grande",Verdana,Arial,Helvetica,sans-serif; font-size: 13px; background-color: #DDDDDD; }
        a {color: #4040ff}
        a:visited {color: #4040ff;}
        #container {margin-left:50px; width:875px;}
        #content {background-color:white;padding:15px;margin-bottom:20px;-moz-border-radius-bottomleft:5px;-moz-border-radius-bottomright:5px;}
        #left { float:left; width: 625px; background-color: #ffffff;}
        #right { float:left; width: 200px; background-color: #ffffff;margin-left:20px;}

    </style>
    <cms:init />
</head>
<body>
<div id="container">

    <p>${cmsfn:decode(content).body}</p>

    <p>${stringFromModel}</p>

    <div id="content">

        <cms:area name="left" />

        <cms:area name="right" />

        <div style="clear:both;"></div>

    </div>
</div>
</body>
</html>
