<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
</head>
<body>

<form method="post">

    <table class="dataTable" cellspacing="0" cellpadding="0">
        <tr>

            <button onclick="deleteAll()">批量删除</button>
        </tr>
        <tr>
            <td width="5%"></td>
            <td width="10%">序号</td>
            <td width="30%">用户名</td>
            <td width="15%">邮箱</td>
            <td width="18%">年龄</td>
            <td width="10%">操作</td>
        </tr>
        <c:forEach items="${requestScope.list}" var="user" varStatus="varStatus">
            <tr>
                <td width="5%"><input type="checkbox" value="${user.id}"/></td>
                <td width="10%" >${varStatus.index+1 }</td>
                <td width="30%" ><div  class="oneline">${user.userName }</div></td>
                <td width="15%" ><div  class="oneline">${user.email }</div></td>
                <td width="18%"><div  class="oneline">${user.age }</div></td>
                <td width="10%" ><input onclick="deleteUser(${user.id})" type="button" value="删除"></td>
            </tr>
        </c:forEach>
    </table>
</form>

<script src="/static/js/jquery.js"></script>
<script>
    function deleteUser(obj){
        var url = "/user/delete?id=" + obj;
        var form = $("form");
        form.attr("action", url);
        form.submit();
    }

    function deleteAll() {
        console.log("删除所有");
    }

</script>
</body>

</html>