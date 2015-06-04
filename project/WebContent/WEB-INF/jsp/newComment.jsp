<%@ include file="include/header.jsp" %>

<!-- Body Section -->
<div id="page-wrapper">
    <div class="panel">
        <div class="panel-heading"><h3>Add New Comment</h3></div>
        <div class="panel-body">
            <form action="./newComment" method="POST" id="commentForm" class="group">
                <div class="field-group">
                    <div class="label">
                        <label for="title">Title <span class="error" id="titleError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                        <p class="label">Add a title - required</p>
                    </div>
                    <div class="input">
                        <input type="text" name="title" id="title" placeholder="Comment Title" value="" required>
                    </div>
                </div>
                <div class="field-group">
                    <div class="label">
                        <label for="shortComment">Short Comment <span class="error" id="shortCommentError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                        <p class="label">Add Comment - required</p>
                    </div>
                    <div class="input">
                        <textarea name="shortComment" id="shortComment" placeholder="Add Comment" required></textarea>
                    </div>
                </div>
                 <div class="field-group">
                    <div class="label">
                        <label for="detailComment">Detailed Comment <span class="error" id="detailCommentError"><i class="fa fa-exclamation-triangle"></i> Required</span></label>
                        <p class="label">Add Comment - required</p>
                    </div>
                    <div class="input">
                        <textarea name="detailComment" id="detailComment" placeholder="Add Comment" required></textarea>
                    </div>
                </div>

                <input type="submit" id="submit" class="floatright" value="Add Comment">
                <input type="reset" id="reset" class="floatright" value="Clear Form">
            </form>
        </div><!-- end panel-body -->
    </div><!-- end panel -->
</div><!-- end page wrapper -->

<%@ include file="include/footer.jsp" %>