
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
</head>
<body>
<h1>Thông tin Cửa Hàng</h1>
<a href="/admin/cua-hang/create" class="btn btn-success mt-3">Add</a>

    <table class="table table-bordered mt-5">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Địa chỉ</th>
            <th>Thành phố</th>
            <th>Quốc gia</th>
            <th class="col-2 text-center">Action</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="cuaHang" items="${ list }" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${ cuaHang.ma }</td>
                <td>${ cuaHang.ten }</td>
                <td>${ cuaHang.diaChi }</td>
                <td>${ cuaHang.thanhPho }</td>
                <td>${ cuaHang.quocGia }</td>

                <td class="text-center">
                    <a href="/admin/cua-hang/edit/${ cuaHang.id }"
                       class="btn btn-primary">Update</a>
                    <a href="/admin/cua-hang/delete/${ cuaHang.id }"
                       class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xoá?  ')">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>
