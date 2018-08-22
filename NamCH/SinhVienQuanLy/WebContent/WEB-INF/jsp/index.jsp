<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<meta charset="utf-8" name="viewport"
    content="width=device-width, initial-scale=1"
    http-equiv="X-UA-Conpatible" />
<link library="css" name="bootstrap.min.css" />
<title>Danh Sách Sinh Viên</title>
<style type="text/css">
.btn-circle {
  width: 30px;
  height: 30px;
  text-align: center;
  padding: 6px 0;
  font-size: 12px;
  line-height: 1.428571429;
  border-radius: 15px;
}

.tableUpdated {
    width: 90% !important;
    margin: 17px 58px 0 !important;
}

.btnSpace {
    margin: 17px;
}
</style>
</head>
<body>

    <center>
        <h1>Danh Sách Sinh Viên</h1>
    </center>
    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Mã Sinh Viên</th>
                <th scope="col">Họ Và Tên</th>
                <th scope="col">Năm Sinh</th>
                <th scope="col">Email</th>
                <th scope="col">Địa Chỉ</th>
                <th scope="col">Số Điện Thoại</th>
                <th scope="col">Lớp Học</th>
                <th scope="col">Hoạt Động</th>
            </tr>
        </thead>
        <tbody>
              <c:forEach var="sv" varStatus="counter" items="${sinhvien}">
            <tr>
                <th scope="row"><c:out value="${counter.count}" /></th>
                <td>${sv.maSv}</td>
                <td>${sv.tenSv}</td>
                <td>${sv.namSinh}</td>
                <td>${sv.email}</td>
                <td>${sv.diaChi}</td>
                <td>${sv.soDt}</td>
                <td>${sv.lop}</td>
                <td>                    
                    <a href="edit/${sv.id}"><button type="button" class="btn btn-warning btn-circle">
                        Edit
                    </button></a>
                    <a href="delete/${sv.id}"><button type="button" class="btn btn-danger btn-circle">
                        Del
                    </button></a>
                </td>
            </tr>
            </c:forEach>  
        </tbody>
    </table>
    <a href="add"><button type="button" class="btn btn-primary btn-block">Thêm Sinh Viên</button></a>
   
</body>
</html>