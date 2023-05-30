<%@ page language="java" pageEncoding ="UTF-8"%>
<html>
<head>
    <title>Document</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<body>
<form action="/login" method="post">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h4 class="text-center">Đăng nhập</h4>
                    </div>
                    <div class="card-body">
                        <form>
                            <div class="form-group">
                                <label >Email</label>
                                <input type="email" class="form-control" name="email" >
                            </div>
                            <div class="form-group">
                                <label>Mật khẩu</label>
                                <input type="password" class="form-control" name="password">
                            </div>
                            <div class="form-group">
                                <label>Ghi nho</label>
                                <input type="checkbox" class="form-control" name="remember">
                            </div>
                            <div class="form-group text-center">
                                <button type="submit" class="btn btn-primary">Đăng nhập</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

</body>
</body>
</html>