
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/../css/bootstrap.min.css">
</head>
<body>

<div class="col-8 offset-2">
    <c:if test="${not empty sessionScope.mess_error}">
        <div class="alert alert-danger" role="alert">
                ${sessionScope.mess_error}
        </div>
        <% session.removeAttribute("mess_error"); %>
    </c:if>
    <sf:form method="POST"
          action="${action}" modelAttribute="ctsp">
        <div class="row">
            <div class=" col-md-4 ">
                <label class="form-label">Năm bảo hành</label>
               <sf:input path="namBaoHanh" type="number" class="form-control"  value="${ctsp.namBaoHanh}"/>
                <sf:errors path="namBaoHanh" cssClass="text-danger"/>
            </div>

            <div class=" col-md-4 mb-3">
                <label  class="form-label">Số lượng tồn</label>
                <sf:input path="soLuongTon" type="number" class="form-control" value="${ctsp.soLuongTon}"/>
                <sf:errors path="soLuongTon" cssClass="text-danger"/>
            </div>
            <div class="col-md-4 mb-3">
                <label  class="form-label">Dòng Sản phẩm</label>
                <sf:select path="dongSp" class="form-control">
                    <c:forEach var="dongSp" items="${dongSPList}">
                        <option value="${dongSp.id}" ${dongSp.id == ctsp.dongSp.id ? "selected" : ""}>${dongSp.ten}</option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 mb-3">
                <label class="form-label">Giá nhập</label>
                <sf:input path="giaNhap" type="number" class="form-control" value="${ctsp.giaNhap}"/>
                <sf:errors path="giaNhap" cssClass="text-danger"/>
            </div>
            <div class="col-md-4 mb-3">
                <label for="nsx" class="form-label">Nhà sản xuất</label>
                <sf:select path="nsx" class="form-control" >
                    <c:forEach var="nsx" items="${nsxList}">
                        <option value="${nsx.id}" ${nsx.id == ctsp.nsx.id ? "selected" : ""}>${nsx.ten}</option>
                    </c:forEach>
                </sf:select>
            </div>
            <div class="col-md-4 mb-3">
                <label class="form-label">Sản phẩm</label>
                <sf:select path="sanPham" class="form-control" >
                    <c:forEach var="sp" items="${sanPhamList}">
                        <option value="${sp.id}" ${sp.id == ctsp.sanPham.id ? "selected" : ""}>${sp.ten}</option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 mb-3">
                <label  class="form-label">Giá bán</label>
                <sf:input path="giaBan" type="number" class="form-control" value="${ctsp.giaBan}"/>
                <sf:errors path="giaBan" cssClass="text-danger"/>
            </div>
            <div class="col-md-4 mb-3">
                <label  class="form-label">Màu sắc</label>
               <sf:select path="mauSac" class="form-control" >
                    <c:forEach var="mauSac" items="${mauSacList}">
                        <option value="${mauSac.id}" ${mauSac.id == ctsp.mauSac.id ? "selected" : ""}>${mauSac.ten}</option>
                    </c:forEach>
                </sf:select>
            </div>
            <div class=" col-md-4 mb-3">
                <label  class="form-label">Mô tả</label>
                <sf:input path="moTa" type="text" class="form-control" value="${ctsp.moTa}"/>
                <sf:errors path="moTa" cssClass="text-danger"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Submit</button>
            </div>
            <div class="col-6"></div>
        </div>
    </sf:form>
</div>

</body>
</html>
