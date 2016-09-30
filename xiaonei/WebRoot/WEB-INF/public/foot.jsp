<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
  </head>
  
  <body>
    <table width="1004" height="61" border="0" float="left" position="relative" align="center" cellpadding="0" cellspacing="0" id="foot">
    <tbody>
        <tr>
            <td align="left" valign="middle" style="padding:0px 0 0 340px;"><font class="font1">
                版权所有 © <font color="#cc0000">1广东海洋大学 - 水产动物生理学</font> 技术支持：<br>
                建议在IE6以上浏览器 <a href="test://210.38.136.69:8001/Ltclient/login.asp" target="_blank"><img src="${pageContext.request.contextPath }/images/pic_kiki.gif" alt="网站管理" border="0"></a> 1024×768分辨率下浏览 访问统计：
            </font></td>
            <td width="265" align="center" valign="middle">
                <table width="206" height="37" border="0" cellpadding="0" cellspacing="0">
                    <tbody>
                        <tr>
                            <td align="center">
                                <select name="select" style="width:180px;clear:both;" onchange="if(this.options[this.selectedIndex].value!=''){window.open(this.options[this.selectedIndex].value,'_blank');}">
                                    <option value="" style="color: #555"><font class="font1">------- 友情链接 -------</font></option>
                                        <option value="http://www.gdou.edu.cn/"><font class="font1">广东海洋大学</font></option>
                                        <option value="http://www1.gdou.edu.cn/scxy/"><font class="font1">水产学院</font></option>
                                </select>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </td>
        </tr>
    </tbody>
</table>
  </body>
</html>
