<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>

	<%--静态包含 公共的base标签,css样式,jquery文件  --%>
	<%@include file="/pages/common/header.jsp"%>



	<script type="text/javascript">
		$(function () {
             //给验证码图片添加单击事件
			$("#codeImg").click(function () {
            this.src="${basePath}kaptcha.jpg?d="+Math.random();
			});
			// 给[注册]绑定单击事件
			$("#sub_btn").click(function () {
				// 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
				// 1 先获取输入框里的内容
				var usernameText = $("#username").val();
				// 2 创建正则表达式
				var usernamePatt = /^\w{5,12}$/;
				// 3 调用 test 方法验证是否合法
				// test方法正则表达式的方法用于验证字符串是否匹配正则表达式
				// 返回true	表示匹配正则要求
				// 返回false表示不匹配正则要求
				if (!usernamePatt.test(usernameText)) {
					// 4 提示验证结果
					$("span.errorMsg").text("用户名不合法!");
					// 阻止表单提交
					return false;
				}

				// 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
				//1 获取密码的内容
				var passwordText = $("#password").val();
				//2 创建密码正则表达式
				var passwordPatt = /^\w{5,12}$/;
				//3 调用 test 验证
				if (!passwordPatt.test(passwordText)) {
					//4 提示用户结果
					$("span.errorMsg").text("密码不合法!");
					// 阻止表单提交
					return false;
				}

				// 验证确认密码：和密码相同
				//1 获取确认密码
				var repwdText = $("#repwd").val();
				//2 和密码比较
				if (repwdText != passwordText) {
					//3 提示用户
					$("span.errorMsg").text("确认密码和密码不一致!");
					// 阻止表单提交
					return false;
				}
				// 邮箱验证：xxxxx@xxx.com
				// 1 获取邮箱里的内容
				var emailText = $("#email").val();
				// 2 创建邮箱正则表达式
				var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
				// 3 调用 test 去验证
				if (!emailPatt.test(emailText)) {
					// 4 提示用户
					$("span.errorMsg").text("邮箱格式不合法!");
					// 阻止表单提交
					return false;
				}

				// 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
				//1 先获取输入框里的内容
				var codeText = $("#code").val();
				// alert("去掉空格前["+ codeText +"]");
				codeText = $.trim(codeText);
				// alert("去掉空格后["+ codeText +"]");
				//2 比较是否为空串
				if (codeText == "" || codeText == null) {
					// 提示用户
					$("span.errorMsg").text("请输入验证码!");
					// 阻止表单提交
					return false;
				}

				// 错误信息置空!!!
				$("span.errorMsg").text("");

			});
		});
	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									${ requestScope.msg }
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist" />
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off"
										   tabindex="1" name="username" id="username"
										   value="${ requestScope.username }"/>

									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off"
										   tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off"
										   tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off"
										   tabindex="1" name="email" id="email"
										   value="${ requestScope.email }"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 120px;" name="code" id="code" />
									<img alt="" src="kaptcha.jpg" id="codeImg"
										 style="float: right; margin-right: 40px;width: 100px;height: 32px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>