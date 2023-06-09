<%--
  Created by IntelliJ IDEA.
  User: anhkon
  Date: 3/9/2023
  Time: 9:29 PM
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
<h1>Thông tin Chi tiết sản phẩm</h1>
<a href="/admin/ctsp/create" class="btn btn-success mt-3">Add</a>
<%--<c:if test="${ f:length(list) == 0 }">--%>
<%--    <h4 class="text-center">Không có dữ liệu</h4>--%>
<%--</c:if>--%>

<%--<c:if test="${ f:length(list) != 0 }">--%>
<%--    <c:if test="${not empty sessionScope.message}">--%>
<%--        <div class="alert alert-success" role="alert">--%>
<%--                ${sessionScope.message}--%>
<%--        </div>--%>
<%--        <% session.removeAttribute("message"); %>--%>
<%--    </c:if>--%>
        <span class="text-danger">${errorMessage}</span>
    <table class="table table-bordered mt-5">
        <thead>
        <tr>
            <th>STT</th>
            <th>Năm bảo hành</th>
            <th>Số lượng tồn</th>
            <th>Giá nhập</th>
            <th>Giá bán</th>
            <th>Sản phẩm</th>
            <th>NSX</th>
            <th>Màu sắc</th>
            <th>Dòng Sản phẩm</th>
            <th>Mô tả</th>
            <th>Ảnh</th>
            <th class="col-2 text-center">Action</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="ctsp" items="${ list.content }" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${ ctsp.namBaoHanh }</td>
                <td>${ ctsp.soLuongTon }</td>
                <td>${ ctsp.giaNhap }</td>
                <td>${ ctsp.giaBan }</td>
                <td>${ ctsp.sanPham.ten }</td>
                <td>${ ctsp.nsx.ten }</td>
                <td>${ ctsp.mauSac.ten }</td>
                <td>${ ctsp.dongSp.ten }</td>
                <td>${ ctsp.moTa }</td>
                <td>
                    <img src="${ ctsp.sanPham.srcImage }" alt="ảnh sản phẩm" style="width: 200px; height: 100px;">
                </td>

                <td class="text-center">
                    <a href="/admin/ctsp/edit/${ ctsp.id }"
                       class="btn btn-primary">Update</a>
                    <a href="/admin/ctsp/delete/${ ctsp.id }"
                       class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xoá?  ')">
                        Delete
                    </a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:forEach begin="0" end="${ list.totalPages -1}" varStatus="loop">
                <li class="page-item">
                    <a class="page-link" href="/admin/ctsp/index?page=${loop.begin + loop.count - 1}">
                            ${loop.begin + loop.count }
                    </a>
                </li>
            </c:forEach>
        </ul>
    </nav>
<%--</c:if>--%>

</body>
</html>
