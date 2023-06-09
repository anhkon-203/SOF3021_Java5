
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/../css/bootstrap.min.css">
</head>
<body>
<div class="col-8 offset-2">
<%--    <c:if test="${not empty sessionScope.mess_error}">--%>
<%--        <div class="alert alert-danger" role="alert">--%>
<%--                ${sessionScope.mess_error}--%>
<%--        </div>--%>
<%--        <% session.removeAttribute("mess_error"); %>--%>
<%--    </c:if>--%>
    <sf:form method="POST"
          action="${action}" modelAttribute="chucVu">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <sf:input path="ma" type="text" class="form-control" value="${chucVu.ma}" readonly="true"/>
                <sf:errors path="ma" class="text-danger"/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <sf:input path="ten" type="text" class="form-control" value="${chucVu.ten}"/>
                <sf:errors path="ten" class="text-danger"/>
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
