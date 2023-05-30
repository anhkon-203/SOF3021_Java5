<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<h1>Thêm mới khách hàng</h1>
<div class="col-8 offset-2">
    <sf:form method="post" modelAttribute="kh" action="/admin/khach-hang/store">
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
            <label>Tên Đệm</label>
            <sf:input path="tenDem"/>
            <sf:errors path="tenDem" cssClass="text-danger"/>
        </div>
        <div class="mt-3">
            <label>Tên</label>
            <sf:input path="ten"/>
            <sf:errors path="ten" cssClass="text-danger"/>
        </div>
        <div class="mt-3">
            <label>Ngày sinh</label>
            <sf:input path="ngaySinh" type="date"/>
            <sf:errors path="ngaySinh" cssClass="text-danger"/>
        </div>
        <div class="mt-3">
            <label>Địa chỉ</label>
            <sf:input path="diaChi"/>
            <sf:errors path="diaChi" cssClass="text-danger"/>
        </div>
        <div class="mt-3">
            <label>sdt</label>
            <sf:input path="sdt"/>
            <sf:errors path="sdt" cssClass="text-danger"/>
        </div>
        <div class="mt-3">
            <label>Mật Khẩu</label>
            <sf:input path="matKhau" type="password"/>
            <sf:errors path="matKhau" cssClass="text-danger"/>
        </div>
        <div class="mt-3">
            <label>Email</label>
            <sf:input path="email"/>
            <sf:errors path="email" cssClass="text-danger"/>
        </div>
        <div class="mt-3">
            <label>Thành Phố</label>
            <sf:input path="thanhPho"/>
            <sf:errors path="thanhPho" cssClass="text-danger"/>
        </div>
        <div class="mt-3">
            <label>Quốc Gia</label>
            <sf:input path="quocGia"/>
            <sf:errors path="quocGia" cssClass="text-danger"/>
        </div>
        <button>submit</button>
    </sf:form>
</div>
</body>
</html>
