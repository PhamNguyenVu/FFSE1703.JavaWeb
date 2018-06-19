<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Students Management</h1>
		<h2>
			<a href="new">Add New Student</a> &nbsp;&nbsp;&nbsp; <a href="list">List
				All Students</a>

		</h2>
	</center>
	<div align="center">
		<c:if test="${student != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${student == null}">
			<form action="insert" method="post" name="uploadForm"
				enctype="multipart/form-data">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${student != null}">
                        Edit Student
                    </c:if>
					<c:if test="${student == null}">
                        Add New Student
                    </c:if>
				</h2>
			</caption>
			<c:if test="${student != null}">
				<input type="hidden" name="id"
					value="<c:out value='${student.id}' />" />
			</c:if>
			<tr>
				<th>Name:</th>
				<td><input type="text" placeholder="Username" name="Name"
					size="45" value="<c:out value='${student.name}' />" /></td>
			</tr>
			<tr>
				<th>Class:</th>
				<td><input type="text" placeholder="Class" name="Class"
					size="45" value="<c:out value='${student.clas}' />" /></td>
			</tr>
			<tr>
				<th>Address:</th>
				<td><input type="text" placeholder="Address" name="Address"
					size="45" value="<c:out value='${student.address}' />" /></td>
			</tr>
			<tr>
				<th>Age:</th>
				<td><input type="text" placeholder="Age" name="Age" size="5"
					value="<c:out value='${student.age}' />" /></td>
			</tr>
			<tr>
				<th>Author:</th>
				<td><input type="text" placeholder="Author" name="Author"
					size="5" value="<c:out value='${student.author}' />" /></td>
			</tr>
			<tr>
				<th>LP#1:</th>
				<td><input type="text" placeholder="LP#1" name="Diemlp1"
					size="5" value="<c:out value='${student.diemLp1}' />" /></td>
			</tr>
			<tr>
				<th>LP#2:</th>
				<td><input type="text" placeholder="LP#2" name="Diemlp2"
					size="5" value="<c:out value='${student.diemLp2}' />" /></td>
			</tr>
			<tr>
				<th>Ảnh Đại Diện:</th>
				<td><input name="uploadfile" placeholder="File" type="file" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
				<td><a class="nav-link"
					href="http://localhost:8080/Assignment1/list"> <i
						class="fa fa-fw fa-area-chart"></i> <span class="nav-link-text">Back</span>
				</a></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>