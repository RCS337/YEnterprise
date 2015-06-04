<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="include/header.jsp" %>

<!-- Body Section -->
<div id="page-wrapper">
    <div class="panel">
            <div class="entry-header group">
        <div class="entry">
            <h3>Comments</h3>
        </div>
        <div class="date">
            <h3>Date</h3>
        </div>
        <div class="${(user.firstName != null) ? "admin" : "hidden"}">
            <h3>Admin</h3>
        </div>
    </div>
        <div class="panel-body group">
        
        <c:forEach items="${posts}" var="post" varStatus="myIndex">
            <div class="${(myIndex.index)%2 eq 0 ? 'entry-item group even' : 'entry-item group odd'}">
                <div class="entry">
                    <h1><a href="detail?postId=<c:out value="${post.postId}"></c:out>"><c:out value="${post.title}"></c:out></a></h1>
                    <article>
                        <p>${post.shortDesc}<a href="detail?postId=<c:out value="${post.postId}"></c:out>">... Read More</a></p>
                    </article>
                </div>
                <div class="date">
                    ${post.createDate }
                </div>
                <div class="${(user.firstName != null) ? "edit" : "hidden"}">
                    <a href="edit?postId=<c:out value="${post.postId}"></c:out>">Edit</a>
                </div>
                <div class="${(user.firstName != null) ? "delete" : "hidden"}">
                    <a href="delete?postId=<c:out value="${post.postId}"></c:out>">Delete</a>
                </div>
            </div>
		</c:forEach>


        </div><!-- end panel-body -->
    </div><!-- end panel -->
</div><!-- end page wrapper -->

<%@ include file="include/footer.jsp" %>