<%@ include file="include/header.jsp" %>

<!-- Body Section -->
<div id="page-wrapper">
    <div class="panel">
        <div class="panel-heading"><h3>Login</h3></div>
        <div class="panel-body">
        	${errorMessage }
            <form action="login" method="POST" id="loginForm" class="group">
                <div class="field-group">
                    <div class="label">
                        <label for="userName">Username <span class="error" id="userNameError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                        <p class="label">Your Username - required</p>
                    </div>
                    <div class="input">
                        <input type="text" name="userName" id="userName" placeholder="User Name" value="${user.userName }" required>
                    </div>
                </div>
                <div class="field-group">
                    <div class="label">
                        <label for="password">Password <span class="error" id="passwordError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                        <p class="label">Your Password - required</p>
                    </div>
                    <div class="input">
                        <input type="password" name="password" id="password" placeholder="password" value="${user.password }" required>
                    </div>
                </div>

                <input type="submit" id="submit" class="floatright" value="Login">
            </form>
        </div><!-- end panel-body -->
    </div><!-- end panel -->
</div><!-- end page wrapper -->

<%@ include file="include/footer.jsp" %>