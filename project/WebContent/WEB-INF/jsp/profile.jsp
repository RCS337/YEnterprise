<%@ include file="include/header.jsp" %>

<!-- Body Section -->
<div id="page-wrapper">
    <div class="panel">
        <div class="panel-heading"><h3>User Profile - ${user.firstName } ${user.lastName }</h3></div>
        <div class="panel-body">
            <form action="#" method="POST" id="registerForm" class="group">
                <div class="field-group">
                    <div class="label">
                        <label for="firstName">First Name <span class="error" id="firstNameError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                        <p class="label">Your First Name - Required</p>
                    </div>
                    <div class="input">
                        <input type="text" name="firstName" id="firstName" placeholder="First Name" value="${user.firstName }" required>
                    </div>
                </div>

                <div class="field-group">
                    <div class="label">
                        <label for="lastName">Last Name <span class="error" id="lastNameError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                        <p class="label">Your Last Name - Required</p>
                    </div>
                    <div class="input">
                        <input type="text" name="lastName" id="lastName" placeholder="Last Name" value="${user.lastName }" required>
                    </div>
                </div>

                <div class="field-group">
                    <div class="label">
                        <label for="email">Email <span class="error" id="emailError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                        <p class="label">A Valid Email - Required</p>
                    </div>
                    <div class="input">
                        <input type="email" name="email" id="email" placeholder="Email" value="${user.email }" required>
                    </div>
                </div>

                <div class="field-group">
                    <div class="label">
                        <label for="userName">User Name <span class="error" id="userNameError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                        <p class="label">Your Login name - Required</p>
                    </div>
                    <div class="input">
                        <input type="text" name="userName" id="userName" placeholder="User Name" value="${user.userName }" required>
                    </div>
                </div>

                <div class="field-group">
                    <div class="label">
                        <label for="password">Password <span class="error" id="passwordError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                        <p class="label">Your Desired Password - Required</p>
                    </div>
                    <div class="input">
                        <input type="password" name="password" id="password" placeholder="Password" value="myPassword" required>
                    </div>
                </div>

                <div class="field-group">
                    <div class="label">
                        <label for="passwordVerification">Repeat Password <span class="error" id="passwordVerificationError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                        <p class="label">Repeat Password - Required</p>
                    </div>
                    <div class="input">
                        <input type="password" name="passwordVerification" id="passwordVerification" placeholder="Repeat Password" value="myPassword" required>
                    </div>
                </div>
                <input type="hidden" id="userID" value="${user.userId }">
                <input type="submit" id="submit" class="floatright" value="Register">
                <a href="./posts" class="button floatright">Cancel</a>
            </form>
        </div><!-- end panel-body -->
    </div><!-- end panel -->
</div><!-- end page wrapper -->

<%@ include file="include/footer.jsp" %>