<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/1/25
  Time: 下午4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <style>
        ul li{
            list-style-type: none;
            margin: 0px;
            padding: 0px;
        }
        a{
            text-decoration: none;
        }
        a:active{
            color: red;
        }
    </style>
</head>
<body>

<div style="width: 1200px;margin: 0 auto;">
    <div style="border: 1px solid;height: 50px;">
        <h3 style="display: inline-block">欢迎登录</h3>
        <span style="float: right;margin-right: 10px;margin-top: 18px;">
                用户:${username} &nbsp;&nbsp;<a href="/loginOut" >退出登录</a>
            </span>
    </div>
    <div style="height: 600px">
        <div style="border: 1px solid;width: 200px;float: left;height:100%;">
            <ul>
                <li><a onclick="toTab(this)"  data-url="/user/page" href="javascript:void(0)">用户信息</a></li>
                <li><a onclick="toTab(this)" data-url="/role/page" href="javascript:void(0)">角色信息</a></li>
            </ul>
        </div>
        <div style="border: 1px solid;height:100%;float: right;width: 966px;padding:0px 15px; ">
            <iframe id="webCenter" src="/welcome" frameborder="0"></iframe>
        </div>
    </div>
</div>
<script type="text/javascript" >
    function toTab(a) {
        document.getElementById("webCenter").setAttribute("src",a.getAttribute("data-url"));
    }
</script>
</body>
</html>
