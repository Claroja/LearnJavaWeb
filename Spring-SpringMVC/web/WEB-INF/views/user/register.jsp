<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript">
        function register(){
            var username = $("#name").val();
            var password = $("#pwd").val();
            var info = {"username":username,"password":password};
            var json = JSON.stringify(info);
            var url = "${pageContext.request.contextPath}/user/registerjson1.do";
            $.ajax({
                type:'post',
                url:url,
                contentType:'application/json;charset=utf-8',
                data:json,
                success:function(res){
                    console.log(res.toString());
                }
            })

            console.log(username)
        }

    </script>
</head>



<body>
<h1>单独获取表单的每个参数</h1>
<form action="${pageContext.request.contextPath}/user/login.do" method="post">
    用户名:<input type="text" name="username"><br>
    密码:<input type="text" name="password"><br>
    性别:<input type="text" name="gender"><br>
    年龄:<input type="text" name="age"><br>
    生日:<input type="text" name="birthday"><br>
    爱好:<input type="checkbox" name="hobbyIds" value="1">打球
    <input type="checkbox" name="hobbyIds" value="2">打人
    <input type="checkbox" name="hobbyIds" value="3">打假<br>
    <input type="submit">
</form>
<br>
<h1>通过model获得表单的参数</h1>
<form action="${pageContext.request.contextPath}/user/login2.do" method="post">
    用户名:<input type="text" name="username"><br>
    密码:<input type="text" name="password"><br>
    性别:<input type="text" name="gender"><br>
    年龄:<input type="text" name="age"><br>
    生日:<input type="text" name="birthday"><br>
    爱好:<input type="checkbox" name="hobbyIds" value="1">打球
    <input type="checkbox" name="hobbyIds" value="2">打人
    <input type="checkbox" name="hobbyIds" value="3">打假<br>
    <input type="submit">
</form>
<br>
<h1>json提交数据</h1>
<form action="${pageContext.request.contextPath}/user/registerjson.do" method="post">
    用户名:<input type="text" name="username" id="name"><br>
    密码:<input type="text" name="password" id="pwd"><br>
    <input type="button" onclick="register();">
</form>
<br>




</body>
</html>
