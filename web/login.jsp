<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
  <head>
    <title>login</title>
  </head>
  <body>

    <form action="UserServlet2" method="get">
      <input name="username" value="${cookie.username.value}"/><br/>
      <%--from 表单中传值   隐藏表单域 --%>
      <input name="action" value="login" type="hidden"/><br/>
      <input name="password" type="password"/>
      <input type="submit" value="登录"/>
    </form>

    <%--<form action="UserServlet2?action=login" method="get">--%>
      <%--<input name="username"/><br/>--%>
      <%--&lt;%&ndash;from 表单中传值   隐藏表单域 &ndash;%&gt;--%>
      <%--<input name="action" value="login" type="hidden"/><br/>--%>
      <%--<input name="password" type="password"/>--%>
      <%--<input type="submit" value="登录"/>--%>
    <%--</form>--%>

  </body>
</html>
