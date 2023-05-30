
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<%--    <%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<h1 class="text-center">Thông tin Khách Hàng</h1>
<a href="/admin/khach-hang/create" class="btn btn-success mt-3">Add</a>

<table class="table mt-3">
    <thead>
            <th>Mã</th>
            <th>Họ tên</th>
            <th>Ngày Sinh</th>
            <th>Địa chỉ</th>
            <th>SDT </th>
            <th>Email</th>
            <th>Thành phố</th>
            <th>Quốc gia</th>
            <th>Action</th>
    </thead>
    <tbody>
        <c:forEach varStatus="index" items="${list}" var="kh">
            <tr>
                <td>${kh.ma}</td>
                <td>${kh.ho} ${kh.tenDem} ${kh.ten}</td>
                <td>${kh.ngaySinh}</td>
                <td>${kh.diaChi}</td>
                <td>${kh.sdt}</td>
                <td>${kh.email}</td>
                <td>${kh.thanhPho}</td>
                <td>${kh.quocGia}</td>
                <td>
                    <a href="/admin/khach-hang/delete/${kh.ma}" class="btn btn-danger"
                    onclick="return confirm('Bạn có chắc chắn muốn xoá không?')"
                    >Xoá</a>
                    <a href="/admin/khach-hang/edit/${kh.ma}" class="btn btn-danger">Update</a>
                </td>
            </tr>

        </c:forEach>
    </tbody>
</table>

</body>
</html>
