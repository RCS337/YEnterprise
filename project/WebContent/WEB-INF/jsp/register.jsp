<%@ include file="include/header.jsp" %>

<!-- Body Section -->
<div id="page-wrapper">
    <div class="panel">
        <div class="panel-heading"><h3>Register New User</h3></div>
        <div class="panel-body">
       		 ${errorMessage }
            <form action="/register" method="POST" id="registerForm" class="group">
                <div class="field-group">
                    <div class="label">
                        <label for="firstName">First Name <span class="error" id="firstNameError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                        <p class="label">Your First Name - Required</p>
                    </div>
                    <div class="input">
                        <input type="text" name="firstName" id="firstName" placeholder="First Name" value="${retryUser.firstName }" required>
                    </div>
                </div>

                <div class="field-group">
                    <div class="label">
                        <label for="lastName">Last Name <span class="error" id="lastNameError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                        <p class="label">Your Last Name - Required</p>
                    </div>
                    <div class="input">
                        <input type="text" name="lastName" id="lastName" placeholder="Last Name" value="${retryUser.lastName }" required>
                    </div>
                </div>

                <div class="field-group">
                    <div class="label">
                        <label for="email">Email <span class="error" id="emailError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                        <p class="label">A Valid Email - Required</p>
                    </div>
                    <div class="input">
                        <input type="email" name="email" id="email" placeholder="Email" value="${retryUser.email }" required>
                    </div>
                </div>

                <div class="field-group">
                    <div class="label">
                        <label for="userName">User Name <span class="error" id="userNameError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                        <p class="label">Your Login name - Required</p>
                    </div>
                    <div class="input">
                        <input type="text" name="userName" id="userName" placeholder="User Name" value="${retryUser.userName }" required>
                    </div>
                </div>

                <div class="field-group">
                    <div class="label">
                        <label for="password">Password <span class="error" id="passwordError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                        <p class="label">Your Desired Password - Required</p>
                    </div>
                    <div class="input">
                        <input type="password" name="password" id="password" placeholder="Password" value="" required>
                    </div>
                </div>

                <div class="field-group">
                    <div class="label">
                        <label for="passwordVerification">Repeat Password <span class="error" id="passwordVerificationError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                        <p class="label">Repeat Password - Required</p>
                    </div>
                    <div class="input">
                        <input type="password" name="passwordVerification" id="passwordVerification" placeholder="Repeat Password" value="" required>
                    </div>
                </div>

                <input type="submit" id="submit" class="floatright" value="Register">
                <input type="reset" id="reset" class="floatright" value="Clear Form">
            </form>
        </div><!-- end panel-body -->
    </div><!-- end panel -->
</div><!-- end page wrapper -->

<%@ include file="include/footer.jsp" %>