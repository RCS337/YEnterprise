<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title></title>
    <meta name="description" content="">
    <!-- XFN Metadata Profile -->
    <link rel="profile" href="http://gmpg.org/xfn/11">
    <!-- mobile specific metadeta -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-sclase=1">
    <!-- specify IE rendering version -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <!-- Apple Touch Icon -->
    <link rel="apple-touch-icon-precomposed" sizes="180x180" href="../icons/apple-touch-icon-precomposed.png">
    <!-- stylesheets-->
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />

</head>
<body>

<!-- Header Section -->
<div class="header-wrapper">

    <header id="masthead" class="group">
        <h1>Y Enterprises</h1>
        <ul>
        	<li><a href="login"><i class="fa fa-sign-${(user.firstName != null) ? "out\"></i>Logout" : "in\"></i>Login"}</a></li>
			<li>${(user.firstName != null) ? user.firstName  : ""} ${(user.lastName != null) ? user.lastName  : "<a href=\"register\"><i class=\"fa fa-user-plus\"></i>Register</a>"}</li>
        </ul>
     </header>

</div>

<!-- Tabbed Navigation Section -->
<div id="nav-wrapper">
    <nav id="tabbed-nav">
        <ul>
            <li><a href="posts" class="${post }">Comment List</a></li>
            ${(user.firstName != null) ? "<li><a href=\"newComment\" class=\"" : ""}${comment }${(user.firstName != null) ? "\" >Add New Comment</a></li>" :""}
            ${(user.firstName != null) ? "<li><a href=\"profile\" class=\"" : ""}${profile }${(user.firstName != null) ? "\" >User Profile</a></li>" :""}
        </ul>
    </nav>
</div>