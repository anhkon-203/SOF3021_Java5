<%--
  Created by IntelliJ IDEA.
  User: anhkon
  Date: 3/11/2023
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/../css/bootstrap.min.css">
</head>
<body>
<div class="col-8 offset-2">
    <c:if test="${not empty sessionScope.mess_error}">
        <div class="alert alert-danger" role="alert">
                ${sessionScope.mess_error}
        </div>
        <% session.removeAttribute("mess_error"); %>
    </c:if>
    <sf:form method="POST"
          action="${action}"
          enctype="multipart/form-data" modelAttribute="sp"
    >
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <sf:input type="text" path="ma" class="form-control" value="${sp.ma}" disabled="true"/>

            </div>
            <div class="col-6">
                <label>Tên</label>
                <sf:input type="text" path="ten" class="form-control" value="${sp.ten}"/>
                <c:if test="${not empty error}">
                    <p style="color: red">${error}</p>
                </c:if>
            </div>
            <div class="col-4">
                <label>Ảnh</label>
                <sf:input type="file" class="form-control" path="srcImage" value="${sp.srcImage}" />
                <c:if test="${not empty error}">
                    <p style="color: red">${error}</p>
                </c:if>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Submit</button>
            </div>
            <div class="col-6"></div>
        </div>
    </sf:form>
</div>
</body>
</html>
