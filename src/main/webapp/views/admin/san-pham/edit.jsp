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
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/Assignment_Sof3011_war_exploded/css/bootstrap.min.css">
</head>
<body>
<div class="col-8 offset-2">
    <h1>Update sản phẩm</h1>
    <c:if test="${not empty sessionScope.mess_error}">
        <div class="alert alert-danger" role="alert">
                ${sessionScope.mess_error}
        </div>
        <% session.removeAttribute("mess_error"); %>
    </c:if>
    <form method="POST"
          action="/Assignment_Sof3011_war_exploded/san-pham/update?ma=${sp.ma}"
          enctype="multipart/form-data"
    >
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${sp.ma}" disabled />
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${sp.ten}" />
            </div>
            <div class="col-4">
                <label>Ảnh</label>
                <input type="file" name="srcImage" value="${sp.srcImage}" class="form-control"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Update</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>
</body>
</html>
