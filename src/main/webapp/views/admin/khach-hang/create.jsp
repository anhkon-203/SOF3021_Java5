<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/../css/bootstrap.min.css">
</head>
<body>
<div class="col-8 offset-2">
    <sf:form method="post" modelAttribute="kh" action="${action}">
        <div class="form-group">
            <label for="ma">Mã</label>
            <sf:input path="ma" value="${kh.ma}" id="ma" readonly="true" class="form-control"/>
            <sf:errors path="ma" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="ho">Họ</label>
            <sf:input path="ho" value="${kh.ho}" id="ho" class="form-control"/>
            <sf:errors path="ho" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="tenDem">Tên Đệm</label>
            <sf:input path="tenDem" value="${kh.tenDem}" id="tenDem" class="form-control"/>
            <sf:errors path="tenDem" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="ten">Tên</label>
            <sf:input path="ten" value="${kh.ten}" id="ten" class="form-control"/>
            <sf:errors path="ten" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="ngaySinh">Ngày sinh</label>
            <sf:input path="ngaySinh" type="date" value="${kh.ngaySinh}" id="ngaySinh" class="form-control"/>
            <sf:errors path="ngaySinh" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="diaChi">Địa chỉ</label>
            <sf:input path="diaChi" value="${kh.diaChi}" id="diaChi" class="form-control" />
            <c:if test="${not empty error}">
                <p style="color: red">${error}</p>
            </c:if>
        </div>
        <div class="form-group">
            <label for="sdt">Số điện thoại</label>
            <sf:input path="sdt" value="${kh.sdt}" id="sdt" class="form-control"/>
            <c:if test="${not empty error}">
                <p style="color: red">${error}</p>
            </c:if>
        </div>
        <div class="form-group">
            <label for="matKhau">Mật khẩu</label>
            <sf:input path="matKhau" type="password" value="${kh.matKhau}" id="matKhau" class="form-control"/>
            <sf:errors path="matKhau" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <sf:input path="email" value="${kh.email}" id="email" class="form-control" />
            <sf:errors path="email" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="thanhPho">Thành phố</label>
            <sf:select path="thanhPho" class="form-select">
                <sf:option value="Hà Nội" selected="${kh.thanhPho == 'Hà Nội'}">Hà Nội</sf:option>
                <sf:option value="NewYork" selected="${kh.thanhPho == 'NewYork'}">NewYork</sf:option>
            </sf:select>
        </div>
        <div class="form-group">
            <label for="quocGia">Quốc gia</label>
            <sf:select path="quocGia" class="form-select">
                <sf:option value="Việt Nam" selected="${kh.quocGia == 'Việt Nam'}">Việt Nam</sf:option>
                <sf:option value="Mỹ" selected="${kh.quocGia == 'Mỹ'}">Mỹ</sf:option>
            </sf:select>
        </div>
        <button type="submit" class="btn btn-primary mt-3">Submit</button>
    </sf:form>
</div>
</body>
</html>
