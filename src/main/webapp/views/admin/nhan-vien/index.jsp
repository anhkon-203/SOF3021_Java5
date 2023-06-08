
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
</head>
<body>
<h1 >Thông tin Nhân Viên</h1>
<a href="/admin/nhan-vien/create" class="btn btn-success mt-3">Add</a>


<table class="table table-bordered mt-5">
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã</th>
        <th>Họ và Tên</th>
        <th>Giới Tính</th>
        <th>Ngày Sinh</th>
        <th>SDT</th>
        <th>Địa Chỉ</th>
        <th>Cửa Hàng</th>
        <th>Chức Vụ</th>
        <th>Email</th>
        <th>Trạng Thái</th>
        <th class="col-2 text-center">Action</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="nhanVien" items="${ list }" varStatus="status">
    <tr>
        <td>${status.index + 1}</td>
        <td>${ nhanVien.ma }</td>
        <td>${ nhanVien.ho } ${nhanVien.tenDem} ${nhanVien.ten}</td>
        <td>${ nhanVien.gioiTinh == 1 ? "Nam" : "Nữ" }</td>
        <td>${ nhanVien.ngaySinh }</td>
        <td>${ nhanVien.sdt }</td>
        <td>${ nhanVien.diaChi }</td>
        <td>${ nhanVien.cuaHang.ten }</td>
        <td>${ nhanVien.chucVu.ten }</td>
        <td>${ nhanVien.email }</td>
        <td>${ nhanVien.trangThai == 1 ? "Đang Làm" : "Đã Nghỉ" }</td>
        <td>
            <a href="/admin/nhan-vien/edit/${nhanVien.id}" class="btn btn-primary">Update</a>
            <a href="/admin/nhan-vien/delete/${nhanVien.id}" class="btn btn-danger"
               onclick="return confirm('Bạn có chắc chắn muốn xoá?  ')">
                Delete
            </a>
        </td>
        </c:forEach>
</table>

</body>
</html>
