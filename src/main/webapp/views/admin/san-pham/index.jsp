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
    <link rel="stylesheet" href="/../css/bootstrap.min.css">
</head>
<body>
<h1>Thông tin Sản phẩm</h1>
<a href="/admin/san-pham/create" class="btn btn-success mt-3">Add</a>
<c:if test="${ f:length(list) == 0 }">
    <h4 class="text-center">Không có dữ liệu</h4>
</c:if>

<c:if test="${ f:length(list) != 0 }">
    <c:if test="${not empty sessionScope.message}">
        <div class="alert alert-success" role="alert">
                ${sessionScope.message}
        </div>
        <% session.removeAttribute("message"); %>
    </c:if>

    <c:if test="${not empty sessionScope.mess_error}">
        <div class="alert alert-danger" role="alert">
                ${sessionScope.mess_error}
        </div>
        <% session.removeAttribute("mess_error"); %>
    </c:if>
        <span class="text-danger">${errorMessage}</span>
    <table class="table table-bordered mt-5">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Ảnh</th>
            <th class="col-2 text-center">Action</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="sp" items="${ list }" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${ sp.ma }</td>
                <td>${ sp.ten }</td>
                <td>
                    <img src="${ sp.srcImage }" alt="ảnh sản phẩm" style="width: 100px; height: 100px;">
                </td>
                <td class="text-center">
                    <a href="/admin/san-pham/edit/${ sp.id }"
                       class="btn btn-primary">Update</a>
                    <a href="/admin/san-pham/delete/${ sp.id }"
                       class="btn btn-danger"
                        onclick="return confirm('Bạn có chắc chắn muốn xoá?  ')">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>


</body>
</html>
