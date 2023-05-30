<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">

</head>
<body>

<div class="col-8 offset-2">
    <h1>Thêm mới Cửa hàng</h1>
    <sf:form action="/cua-hang/store" method="post" modelAttribute="cuaHang">
    <div class="mt-3">
        <label>Mã</label>
        <sf:input path="ma"/>
        <sf:errors path="ma" cssClass="text-danger form-control"/>
    </div>
    <div class="mt-3">
        <label>Tên</label>
        <sf:input path="ten"/>
        <sf:errors path="ten" cssClass="text-danger"/>
    </div>
    <div class="mt-3">
        <label>Địa chỉ</label>
        <sf:input path="diaChi"/>
        <sf:errors path="diaChi" cssClass="text-danger"/>
    </div>
    <div class="mt-3">
        <label>Quốc gia</label>
        <sf:select path="quocGia">
            <sf:option value="vi">Việt Nam</sf:option>
            <sf:option value="us">Mỹ</sf:option>
        </sf:select>
    </div>
    <div class="mt-3">
        <label>Thành phố</label>
        <sf:select path="thanhPho">
            <sf:option value="ha_noi">Hà Nội</sf:option>
            <sf:option value="new_york">New York</sf:option>
        </sf:select>
    </div>
    <div class="mt-3">
        <button class="btn btn-primary">Thêm mới</button>
    </div>
    </sf:form>
</body>
</html>
