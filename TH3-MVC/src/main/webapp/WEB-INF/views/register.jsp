<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            padding: 20px 0;
        }
        
        .register-container {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px;
            padding: 2rem;
            margin: 20px auto;
        }
        
        .register-header {
            text-align: center;
            margin-bottom: 2rem;
        }
        
        .register-header h2 {
            color: #333;
            font-size: 1.8rem;
            margin-bottom: 0.5rem;
        }
        
        .register-header p {
            color: #777;
            font-size: 0.9rem;
            margin: 0;
        }
        
        .input-group {
            margin-bottom: 1.2rem;
        }
        
        .input-group label {
            display: block;
            margin-bottom: 8px;
            color: #555;
            font-weight: 500;
        }
        
        .input-group input {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 1rem;
            transition: border-color 0.3s;
            box-sizing: border-box;
        }
        
        .input-group input:focus {
            outline: none;
            border-color: #4e73df;
            box-shadow: 0 0 0 2px rgba(78, 115, 223, 0.25);
        }
        
        .input-row {
            display: flex;
            gap: 15px;
            margin-bottom: 1.2rem;
        }
        
        .input-row .input-group {
            flex: 1;
            margin-bottom: 0;
        }
        
        .agreement {
            margin-bottom: 1.5rem;
            display: flex;
            align-items: flex-start;
        }
        
        .agreement input {
            margin-top: 4px;
            margin-right: 10px;
        }
        
        .agreement label {
            font-size: 0.9rem;
            color: #555;
        }
        
        .agreement a {
            color: #4e73df;
            text-decoration: none;
        }
        
        .agreement a:hover {
            text-decoration: underline;
        }
        
        .btn-register {
            width: 100%;
            padding: 12px;
            background-color: #4e73df;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 1rem;
            font-weight: 600;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        
        .btn-register:hover {
            background-color: #3a5ccc;
        }
        
        .login-link {
            text-align: center;
            margin-top: 1.5rem;
            font-size: 0.9rem;
            color: #777;
        }
        
        .login-link a {
            color: #4e73df;
            text-decoration: none;
            font-weight: 500;
        }
        
        .login-link a:hover {
            text-decoration: underline;
        }
        
        .password-requirements {
            font-size: 0.8rem;
            color: #777;
            margin-top: 5px;
        }
        
        .required:after {
            content: " *";
            color: #e74a3b;
        }
        
        @media (max-width: 600px) {
            .input-row {
                flex-direction: column;
                gap: 0;
            }
        }
    </style>
</head>
<body>
    <div class="register-container">
        <div class="register-header">
            <h2>Đăng Ký Tài Khoản</h2>
            <p>Vui lòng điền thông tin để tạo tài khoản mới</p>
        </div>
        <form action="register" method="post">
            <div class="input-row">
                <div class="input-group">
                    <label for="firstname" class="required">Họ</label>
                    <input type="text" id="firstname" name="firstname" placeholder="Nhập họ" required>
                </div>
                <div class="input-group">
                    <label for="lastname" class="required">Tên</label>
                    <input type="text" id="lastname" name="lastname" placeholder="Nhập tên" required>
                </div>
            </div>
            
            <div class="input-group">
                <label for="email" class="required">Email</label>
                <input type="email" id="email" name="email" placeholder="Nhập địa chỉ email" required>
            </div>
            
            <div class="input-group">
                <label for="username" class="required">Tên đăng nhập</label>
                <input type="text" id="username" name="username" placeholder="Chọn tên đăng nhập" required>
            </div>
            
            <div class="input-group">
                <label for="password" class="required">Mật khẩu</label>
                <input type="password" id="password" name="password" placeholder="Tạo mật khẩu" required>
                <div class="password-requirements">
                    Mật khẩu phải có ít nhất 8 ký tự, bao gồm chữ hoa, chữ thường và số
                </div>
            </div>
            
            <div class="input-group">
                <label for="confirm_password" class="required">Xác nhận mật khẩu</label>
                <input type="password" id="confirm_password" name="confirm_password" placeholder="Nhập lại mật khẩu" required>
            </div>
            
            <div class="input-group">
                <label for="phone">Số điện thoại</label>
                <input type="tel" id="phone" name="phone" placeholder="Nhập số điện thoại">
            </div>
            
            <div class="agreement">
                <input type="checkbox" id="terms" name="terms" required>
                <label for="terms">
                    Tôi đồng ý với <a href="#">Điều khoản dịch vụ</a> và <a href="#">Chính sách bảo mật</a>
                </label>
            </div>
            
            <button type="submit" class="btn-register">Đăng Ký</button>
            
            <div class="login-link">
                Đã có tài khoản? <a href="/login">Đăng nhập</a>
            </div>
        </form>
    </div>
</body>
</html>