<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task Management</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .completed {
            text-decoration: line-through;
            color: #6c757d;
        }
    </style>
</head>
<body>
    <div class="container mt-4">
        <h1>Task Management</h1>
        <div class="mb-3">
            <a href="/tasks/new" class="btn btn-primary">Add New Task</a>
        </div>
        
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="task" items="${tasks}">
                    <tr>
                        <td>${task.id}</td>
                        <td class="${task.completed ? 'completed' : ''}">${task.title}</td>
                        <td class="${task.completed ? 'completed' : ''}">${task.description}</td>
                        <td>
                            <c:choose>
                                <c:when test="${task.completed}">
                                    <span class="badge badge-success">Completed</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="badge badge-warning">Pending</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <a href="/tasks/toggle/${task.id}" class="btn btn-sm btn-info">
                                <c:choose>
                                    <c:when test="${task.completed}">Mark Incomplete</c:when>
                                    <c:otherwise>Mark Complete</c:otherwise>
                                </c:choose>
                            </a>
                            <a href="/tasks/edit/${task.id}" class="btn btn-sm btn-primary">Edit</a>
                            <a href="/tasks/delete/${task.id}" class="btn btn-sm btn-danger" 
                               onclick="return confirm('Are you sure you want to delete this task?')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <c:if test="${empty tasks}">
            <div class="alert alert-info">
                No tasks available. Add a new task to get started!
            </div>
        </c:if>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>