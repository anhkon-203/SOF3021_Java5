<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="col-8 offset-2">
    <h1>Thêm mới Nhân Viên</h1>
    <sf:form action="/admin/nhan-vien/store" method="post" modelAttribute="nv">
    <div class="mt-3">
        <label>Mã</label>
        <sf:input path="ma"/>
        <sf:errors path="ma" cssClass="text-danger"/>
    </div>
    <div class="mt-3">
        <label>Họ</label>
        <sf:input path="ho"/>
        <sf:errors path="ho" cssClass="text-danger"/>
    </div>
    <div class="mt-3">
        <label>Tên đệm</label>
        <sf:input path="tenDem"/>
        <sf:errors path="tenDem" cssClass="text-danger"/>
    </div>

    <div class="mt-3">
        <label>Tên</label>
        <sf:input path="ten"/>
        <sf:errors path="ten" cssClass="text-danger"/>
    </div>
    <div class="mt-3">
        <label>Ngày Sinh</label>
        <sf:input path="ngaySinh" type="date"/>
        <sf:errors path="ngaySinh" cssClass="text-danger"/>
    </div>
    <div class="mt-3">
        <label>SDT</label>
        <sf:input path="sdt"/>
        <sf:errors path="sdt" cssClass="text-danger"/>
    </div>
    <div class="mt-3">
        <label>Địa chỉ</label>
        <sf:input path="diaChi"/>
        <sf:errors path="diaChi" cssClass="text-danger"/>
    </div>
    <div class="mt-3">
        <label>Mật khẩu</label>
        <sf:input path="matKhau" type="password"/>
        <sf:errors path="matKhau" cssClass="text-danger"/>
    </div>
    <div class="mt-3">
        <label>Email</label>
        <sf:input path="email" type="email"/>
        <sf:errors path="email" cssClass="text-danger"/>
    </div>
    <div class="mt-3">
        <label>Giới tính</label>
        <sf:radiobutton path="gioiTinh" value="1"/>Nam
        <sf:radiobutton path="gioiTinh" value="0"/>Nữ
        <sf:errors path="gioiTinh" cssClass="text-danger"/>
    </div>
    <div class="mt-3">
        <label>Trạng thái</label>
        <sf:radiobutton path="trangThai" value="1"/>Đang làm việc
        <sf:radiobutton path="trangThai" value="0"/>Đã nghỉ việc
        <sf:errors path="trangThai" cssClass="text-danger"/>
    </div>
    <div class="mt-3">
        <label>Chức vụ</label>
        <sf:select path="chucVu">
            <sf:option value="nv">Nhân Viên</sf:option>
            <sf:option value="ql">Quản lí</sf:option>
        </sf:select>
    </div>
    <div class="mt-3">
        <label>Cửa Hàng</label>
        <sf:select path="cuaHang">
            <sf:option value="CH1">Cửa Hàng 1</sf:option>
            <sf:option value="CH2">Cửa Hàng 2</sf:option>
        </sf:select>
    </div>

    <div class="mt-3">
        <button class="btn btn-primary">Thêm mới</button>
    </div>
    </sf:form>
</body>
</html>
