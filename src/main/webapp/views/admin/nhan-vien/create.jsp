<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-8">
            <sf:form action="${action}" method="post" modelAttribute="nv">
                <div class="row">
                    <div class="mt-3 col-7">
                        <div class="form-group">
                            <label>Mã</label>
                            <sf:input path="ma" value="${nv.ma}" class="form-control" disabled="true"/>
                            <sf:errors path="ma" cssClass="text-danger"/>
                        </div>
                        <div class="form-group">
                            <label>Họ</label>
                            <sf:input path="ho" value="${nv.ho}" class="form-control"/>
                            <sf:errors path="ho" cssClass="text-danger"/>
                        </div>
                        <div class="form-group">
                            <label>Tên đệm</label>
                            <sf:input path="tenDem" value="${nv.tenDem}" class="form-control"/>
                            <sf:errors path="tenDem" cssClass="text-danger"/>
                        </div>
                        <div class="form-group">
                            <label>Tên</label>
                            <sf:input path="ten" value="${nv.ten}" class="form-control"/>
                            <sf:errors path="ten" cssClass="text-danger"/>
                        </div>
                        <div class="form-group">
                            <label>Ngày Sinh</label>
                            <sf:input path="ngaySinh" type="date" value="${nv.ngaySinh}" class="form-control"/>
                            <sf:errors path="ngaySinh" cssClass="text-danger"/>
                        </div>
                        <div class="form-group">
                            <label>SDT</label>
                            <sf:input path="sdt" value="${nv.sdt}" class="form-control"/>
                            <sf:errors path="sdt" cssClass="text-danger"/>
                        </div>
                        <div class="form-group">
                            <label>Địa chỉ</label>
                            <sf:input path="diaChi" value="${nv.diaChi}" class="form-control"/>
                            <sf:errors path="diaChi" cssClass="text-danger"/>
                        </div>
                    </div>
                    <div class="mt-3 col-5">
                        <div class="form-group">
                            <label>Mật khẩu</label>
                            <sf:input path="matKhau" type="password" value="${nv.matKhau}" class="form-control"/>
                            <sf:errors path="matKhau" cssClass="text-danger"/>
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <sf:input path="email" type="email" value="${nv.email}" class="form-control"/>
                            <sf:errors path="email" cssClass="text-danger"/>
                        </div>
                        <div class="form-group">
                            <label>Giới tính</label>
                            <div class="form-check">
                                <sf:radiobutton path="gioiTinh" value="1" checked="${nv.gioiTinh == 1 }" class="form-check-input"/>Nam
                            </div>
                            <div class="form-check">
                                <sf:radiobutton path="gioiTinh" value="0" class="form-check-input"/>Nữ
                            </div>
                            <sf:errors path="gioiTinh" cssClass="text-danger"/>
                        </div>
                        <div class="form-group">
                            <label>Trạng thái</label>
                            <div class="form-check">
                                <sf:radiobutton path="trangThai" value="1" selected="${nv.trangThai == 1}" class="form-check-input"/>Đang làm việc
                            </div>
                            <div class="form-check">
                                <sf:radiobutton path="trangThai" value="0" selected="${nv.trangThai == 0}" class="form-check-input"/>Đã nghỉ việc
                            </div>
                            <sf:errors path="trangThai" cssClass="text-danger"/>
                        </div>
                        <div class="form-group">
                            <label>Chức vụ</label>
                            <sf:select path="chucVu" class="form-control">
                                <c:forEach var="chucVu" items="${chucVuList}">
                                    <option value="${chucVu.id}" ${chucVu.id == nv.chucVu.id ? "selected" : ""}>${chucVu.ten}</option>
                                </c:forEach>
                            </sf:select>
                        </div>
                        <div class="form-group">
                        <label>Cửa Hàng</label>
                        <sf:select path="cuaHang" class="form-control">
                            <c:forEach var="cuaHang" items="${cuaHangList}">
                                <option value="${cuaHang.id}" ${cuaHang.id == nv.cuaHang.id ? "selected" : ""}>${cuaHang.ten}</option>
                            </c:forEach>
                        </sf:select>
                    </div>
                    </div>
                </div>
                <div class="mt-3">
                    <button class="btn btn-primary" type="submit">Submit</button>
                </div>
            </sf:form>
        </div>
    </div>
</div>

</body>
</html>
