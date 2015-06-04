<%@ include file="include/header.jsp" %>

<!-- Body Section -->
<div id="page-wrapper">


<div class="panel">
    <div class="panel-heading"><h3>Edit Comment</h3></div>
    <div class="panel-body">
        <form action="./edit" method="POST" id="commentForm" class="group">
            <div class="field-group">
                <div class="label">
                    <label for="title">Title <span class="error" id="titleError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                    <p class="label">Edit Title - required</p>
                </div>
                <div class="input">
                    <input type="text" name="title" id="title" placeholder="Comment Title" value="${post.title}" required>
                </div>
            </div>
            <div class="field-group">
                <div class="label">
                    <label for="ShortComment">Short Comment <span class="error" id="shortCommentError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                    <p class="label">Edit Comment - required</p>
                </div>
                <div class="input">
                    <textarea name="shortComment" id="shortComment" placeholder="Add Comment" required>${post.shortDesc}</textarea>
                </div>
            </div>
                            <div class="label">
                    <label for="detailComment">Detail Comment <span class="error" id="detailCommentError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                    <p class="label">Edit Comment - required</p>
                </div>
                <div class="input">
                    <textarea name="detailComment" id="detailComment" placeholder="Add Comment" required>${post.longDesc}</textarea>
                </div>
            </div>
            <input type="hidden" id="postId" name="postId" value="${post.postId}">
            <input type="submit" id="submit" class="floatright" value="SAVE COMMENT">
            <a href="detail?postId=${post.postId}" class="button floatright">Cancel</a>

        </form>
    </div><!-- end panel-body -->
</div><!-- end panel -->

</div><!-- end page wrapper -->

<%@ include file="include/footer.jsp" %>