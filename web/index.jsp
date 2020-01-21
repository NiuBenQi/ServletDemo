<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
欢迎你，<%=request.getParameter("username")%>  ----- ${sessionScope.user.userName}====${sessionScope.user.userPwd}

${requestScope.list}
<c:forEach items="${requestScope.list}" var="user">
    ${user.userName}---${user.userPwd}

</c:forEach>

</body>
</html>
