<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
</head>
<body>

<form action="/user/registSubmit" method="post" onsubmit="return checkForm()">
    <table>
        <tr>
            <td>登录名：</td>
            <td><input name="userName"/>
                <span id="tishi" style="color: red;display: none" >该用户已注册！</span>
                <span id="gou" style="display: none;"><img style="height: 20px;width: 20px;" src="/static/img/gou.png"></span></td>
        </tr>
        <tr>
            <td>设置密码：</td>
            <td><input type="password" name="password">
                <span id="passwordTishi" style="color: red;display: none" >两次密码不一致，请重新输入！</span></td>
        </tr>
        <tr>
            <td>确认密码：</td>
            <td><input type="password" name="repeatPassword">
                <span id="repeatPasswordTishi" style="color: red;display: none" >两次密码不一致，请重新输入！</span></td>
        </tr>
        <tr>
            <td>邮箱：</td>
            <td><input  name="email">
                <span id="emailTishi" style="color: red;display: none" >邮箱格式错误，请重新输入！</span></td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><input  name="age">
                <span id="ageTishi" style="color: red;display: none" >年龄格式错误，请输入正整数字！</span></td>
        </tr>
        <tr>
            <td colspan="2"><input name="submit" type="submit" value="提交" /></td>
        </tr>
    </table>
</form>

<script src="/static/js/jquery.js"></script>
<script>
    var repeatPasswordFlag;
    var emailFlag;
    var ageFlag;

    $("input[name='userName']").blur(function () {
        var userName = $("input[name='userName']").val();
        if(userName != ''){
            checkName(userName)
        }
    });

    function checkName(userName){
        $.ajax({
            type: "get",
            url:"/user/checkUserName",
            data: {userName:userName},
            dataType: "json",
            success:function(data){
                var flag=data.flag;
                if(flag == 'has'){
                    $("#gou").hide();
                    $("#tishi").show();
                    return "noSubmit";
                }else {
                    $("#gou").show();
                    $("#tishi").hide();
                    return "canSubmit";
                }
            }
        });
    }

    $("input[name='password']").blur(function () {
        var password = $("input[name='password']").val();
        var repeatPassword = $("input[name='repeatPassword']").val();
        if(repeatPassword){
            if(password != repeatPassword){
                $("#passwordTishi").show();
            }else {
                $("#passwordTishi").hide();
            }
        }
    });

    $("input[name='repeatPassword']").blur(function () {
        var password = $("input[name='password']").val();
        var repeatPassword = $("input[name='repeatPassword']").val();
        if(password){
            if(password != repeatPassword){
                $("#repeatPasswordTishi").show();
            }else {
                $("#repeatPasswordTishi").hide();
            }
        }
    });

    $("input[name='email']").blur(function () {
        var email = $("input[name='email']").val();
        if (email){
            checkEmail(email);
        }

    });
    function checkEmail(str){
        var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        if(reg.test(str)){
            $("#emailTishi").hide();
            return true;
            //alert("正确");
        }else{
            $("#emailTishi").show();
            return false;
            //alert("错误");
        }
    }

    $("input[name='age']").blur(function () {
        var age = $("input[name='age']").val();
        if (age){
            checkAge(age);
        }
    });
    function checkAge(str){
        var reg = /^[0-9]*$/;
        if(reg.test(str)){
            $("#ageTishi").hide();
            return true;
            //alert("正确");
        }else{
            $("#ageTishi").show();
            return false;
            //alert("错误");
        }
    }
    
    function checkForm() {
        var userName = $("input[name='userName']").val();
        if(!userName){
            alert("请填写登录名！");
            return false;
        }else{
            var userNameFlag = checkName(userName);
            if(!userNameFlag == 'canSubmit'){
                return false;
            }
        }

        var password = $("input[name='password']").val();
        var repeatPassword = $("input[name='repeatPassword']").val();
        if(password && repeatPassword){
            if (!password == repeatPassword) {
                alert("两次密码不一致，请重新输入！");
                return false;
            }
        }else {
            alert("请输入密码！");
            return false;
        }

        var email = $("input[name='email']").val();
        if (!checkEmail(email)) {
            return false;
        }
        var age = $("input[name='age']").val();
        if(!checkAge(age)){
            return false;
        }

        return true;
    }
</script>
</body>

</html>