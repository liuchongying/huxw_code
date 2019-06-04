<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
</head>
<body>

<form action="/user/submit" method="post">
    <table>
        <tr>
            <td>登录名：</td>
            <td><input name="userName"/>
                <span id="tishi" style="color: red;display: none" >该用户不存在！请点击<a href="/user/regist">注册</a></span>
                <span id="gou" style="display: none;"><img style="height: 20px;width: 20px;" src="/static/img/gou.png"></span></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2"><div id="submit"><input type="submit" value="登录" /></div></td>
        </tr>
    </table>
</form>

<script src="/static/js/jquery.js"></script>
<%--<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
</script>--%>
<script>
    var status;
    $("input[name='userName']").blur(function () {
        var userName = $("input[name='userName']").val();
        if(userName != ''){
            $.ajax({
                type: "get",
                url:"/user/checkUserName",
                data: {userName:userName},
                dataType: "json",
                success:function(data){
                    var flag=data.flag;
                    if(flag == 'has'){
                        $("#gou").show();
                        $("#tishi").hide();
                        status = "exist";
                        //alert("存在用户");
                    }else {
                        $("#gou").hide();
                        $("#tishi").show();
                        //alert("不存在用户");
                        status = "noExist";
                    }
                }
            });
        }
    });
    $("input[name='submit']").click(function () {
        if (status == "exist") {
            alert("用户不存在,请注册!");
        }
    });
</script>
</body>

</html>