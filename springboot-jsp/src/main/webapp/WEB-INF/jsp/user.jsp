<%--
  Created by IntelliJ IDEA.
  User: ColorXJH
  Date: 2020/7/11
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%--支持中文展示--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--jstl语法处理页面逻辑--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.Date" %>

<html>
<head>
    <title>JSP页面使用JAVA代码</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <h3>一行java代码</h3>
    <p>今天的日期是: <%=(new Date())%></p>
    <h3>多行JAVA代码</h3>
    <p>
        你的ip地址：
        <%
            out.println("your ip address is "+ request.getRemoteAddr()+"</br>");
            out.println("一段代码");
        %>
    </p>
    <h3>for 循环实例</h3>
    <%--<%%>之间包住的都是代码--%>
    <%
        int count=(int)session.getAttribute("count");
        for(int i=0;i<count;i++){
    %>
            ColorXJH Love DearBear
    <%
        }
    %>

    <h2>jstl语法</h2>
    <h3>标签c:if</h3>
    <c:if test="${username !=null}">
        <p>用户名为：${username}</p>
    </c:if>
    <h3>标签c:choose</h3>
    <c:choose>
        <c:when test="${username=='ColorXJH'}">
            ColorXJH666
        </c:when>
        <c:otherwise>
            DearBear666
        </c:otherwise>
    </c:choose>
    <h2>页面布局</h2>
    <h3>include指令完成页面公共的页眉页脚</h3>
    <p>include有两种用法：1：include标签 也叫静态绑定，在翻译阶段执行</p>
    <p>2: jsp:include命令 也叫动态绑定，在运行时检查包含内容的变化</p>

    <%@ include file="footer.jsp"%>
</body>
</html>
