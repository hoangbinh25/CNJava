<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bai 2</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style type="text/css">
	.custom-table {
		border: 2px solid blue;
	}
	.custom-text th {
		color: red;
		background-color: yellow;
	}
	 .custom-table td {
            background-color: #e9f2ff; 
            color: #000000;             
            border: 1px solid #0d6efd;  
        }
	
</style>
</head>
<body>
 <div class="container mt-5">
        <h2 class="mb-4 text-center">Danh sách sinh viên</h2>
        <table class="table custom-table custom-text text-center">
            <thead>
                <tr>
                    <th>STT</th>
                    <th>Mã SV</th>
                    <th>Họ và tên</th>
                    <th>Quê quán</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>SV001</td>
                    <td>Nguyễn Văn A</td>
                    <td>Hà Nội</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>SV002</td>
                    <td>Trần Thị B</td>
                    <td>Đà Nẵng</td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>