<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%--
 * FCKeditor - The text editor for Internet - http://www.fckeditor.net
 * Copyright (C) 2003-2008 Frederico Caldeira Knabben
 *
 * == BEGIN LICENSE ==
 *
 * Licensed under the terms of any of the following licenses at your
 * choice:
 *
 *  - GNU General Public License Version 2 or later (the "GPL")
 *    http://www.gnu.org/licenses/gpl.html
 *
 *  - GNU Lesser General Public License Version 2.1 or later (the "LGPL")
 *    http://www.gnu.org/licenses/lgpl.html
 *
 *  - Mozilla Public License Version 1.1 or later (the "MPL")
 *    http://www.mozilla.org/MPL/MPL-1.1.html
 *
 * == END LICENSE ==
 * @version: $Id: sample05.jsp 2167 2008-07-03 21:33:15Z mosipov $
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>FCKeditor - JSP Sample</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="robots" content="noindex, nofollow" />
		<link href="../sample.css" rel="stylesheet" type="text/css" />
		<link rel="shortcut icon" href="../fckeditor.gif"
				type="image/x-icon" />
		<script type="text/javascript">
			function FCKeditor_OnComplete(editorInstance) {
				var oCombo = document.getElementById('cmbSkins') ;
	
				// Get the active skin.
				var sSkin = editorInstance.Config['SkinPath'] ;
				sSkin = sSkin.match( /[^\/]+(?=\/$)/g ) ;
	
				oCombo.value = sSkin ;
				oCombo.style.visibility = '' ;
			}

			function ChangeSkin(skinName) {
				window.location.href = window.location.pathname + "?skin=" + skinName ;
			}
		</script>
	</head>
	<%
		String skinStr=request.getParameter("skin");
		if(skinStr!=null) 
			skinStr= "skins/" + skinStr + "/"; 	//basePath +  constant relative skin path + skinName
		pageContext.setAttribute("skin",skinStr);
	%>	
	<body>
		<h1>FCKeditor - JSP - Sample 5</h1>
		This sample shows how to change the editor skin.
		<hr />
		<br />
		<form action="sampleposteddata.jsp" method="post" target="_blank">
			<FCK:editor instanceName="EditorDefault">
				
				<jsp:body>
					<FCK:config SkinPath="${skin}"/>
				</jsp:body>
			</FCK:editor>
			<br />
			<input type="submit" value="Submit" />
		</form>
	</body>
</html>