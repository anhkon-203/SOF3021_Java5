
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/../css/bootstrap.min.css">
</head>
<body>

<div class="col-8 offset-2">
    <sf:form method="POST"
          action="${action}" modelAttribute="cuaHang">
        <div class="mt-3">
            <label>Mã</label>
            <sf:input type="text" path="ma" class="form-control"  value="${cuaHang.ma}" readonly="true" />
            <sf:errors path="ma" cssClass="text-danger"/>
        </div>
        <div class="mt-3">
            <label>Tên</label>
            <sf:input type="text" path="ten" class="form-control"  value="${cuaHang.ten}" required="true"/>
            <sf:errors path="ten" cssClass="text-danger"/>
        </div>
        <div class="mt-3">
            <label>Địa chỉ</label>
            <sf:input type="text" path="diaChi" class="form-control"  value="${cuaHang.diaChi}" required="true"/>
            <sf:errors path="diaChi" cssClass="text-danger"/>
        </div>
        <div class="mt-3">
            <label>Quốc gia</label>
            <sf:select path="quocGia" class="form-select">
                <sf:option value="Việt Nam" selected="${cuaHang.quocGia == 'Việt Nam'}">Việt Nam</sf:option>
                <sf:option value="Mỹ" selected="${cuaHang.quocGia == 'Mỹ'}">Mỹ</sf:option>
            </sf:select>
        </div>
        <div class="mt-3">
            <label>Thành phố</label>
            <sf:select path="thanhPho" class="form-select">
                <sf:option value="Hà Nội" selected="${cuaHang.thanhPho == 'Hà Nội'}">Hà Nội</sf:option>
                <sf:option value="NewYork" selected="${cuaHang.thanhPho == 'NewYork'}">NewYork</sf:option>
            </sf:select>
        </div>
        <div class="mt-3">
            <button class="btn btn-primary">Submit</button>
        </div>
    </sf:form>
</div>

</body>
</html>
