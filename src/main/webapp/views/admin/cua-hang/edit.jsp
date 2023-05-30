
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="col-8 offset-2">
    <h1>Update Cửa hàng</h1>
    <form method="POST"
          action="/cua-hang/update/${cuaHang.id}">
        <div class="mt-3">
            <label>Mã</label>
            <input type="text" name="ma" class="form-control" disabled value="${cuaHang.ma}"  />
        </div>
        <div class="mt-3">
            <label>Tên</label>
            <input type="text" name="ten" class="form-control"  value="${cuaHang.ten}" required/>
        </div>
        <div class="mt-3">
            <label>Địa chỉ</label>
            <input type="text" name="diaChi" class="form-control"  value="${cuaHang.diaChi}"required />
        </div>
        <div class="mt-3">
            <label>Quốc gia</label>
            <select name="quocGia" class="form-select">
                <option value="vi" ${ cuaHang.quocGia == "vi" ? "selected" : "" }>Việt Nam</option>
                <option value="us" ${ cuaHang.quocGia == "us" ? "selected" : "" }>Mỹ</option>
            </select>
        </div>
        <div class="mt-3">
            <label>Thành phố</label>
            <select name="thanhPho" class="form-select">
                <option value="ha_noi" ${ cuaHang.thanhPho == "ha_noi" ? "selected" : "" }>Hà Nội</option>
                <option value="new_york" ${ cuaHang.thanhPho == "new_york" ? "selected" : "" }>New York</option>
            </select>
        </div>
        <div class="mt-3">
            <button class="btn btn-primary">Update</button>
        </div>
    </form>
</div>

</body>
</html>
