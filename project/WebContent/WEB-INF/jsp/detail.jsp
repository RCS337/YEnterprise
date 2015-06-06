<%@ include file="include/header.jsp" %>

<!-- Body Section -->
<div id="page-wrapper">
    <div class="panel">
        <div class="panel-heading"><h3>Comment</h3></div>
        <div class="panel-body group">

        <h1>${post.title}</h1>
        <p class="entry-meta">Posted on ${post.createDate}, by ${post.createdBy }</p>
        <!-- Stock Comment Content -->
        <p>${post.shortDesc }</p>
        <p>${post.longDesc }</p>
        <!-- End stock content -->
        <p class=" ${(user != null) ?"admin-links" : "hidden"}"><a href="edit?postId=${post.postId}">Edit</a> | <a href="delete?postId=${post.postId}">Delete</a></p>

        </div><!-- end panel-body -->
    </div><!-- end panel -->
</div><!-- end page wrapper -->

<%@ include file="include/footer.jsp" %>