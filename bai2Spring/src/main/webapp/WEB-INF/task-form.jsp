<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${isNew ? 'Add New Task' : 'Edit Task'}</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h1>${isNew ? 'Add New Task' : 'Edit Task'}</h1>
        
        <form:form action="/tasks/save" method="post" modelAttribute="task" class="mt-4">
            <form:hidden path="id" />
            
            <div class="form-group">
                <label for="title">Title:</label>
                <form:input path="title" class="form-control" required="true" />
            </div>
            
            <div class="form-group">
                <label for="description">Description:</label>
                <form:textarea path="description" class="form-control" rows="3" />
            </div>
            
            <div class="form-group form-check">
                <form:checkbox path="completed" class="form-check-input" id="completed" />
                <label class="form-check-label" for="completed">Completed</label>
            </div>
            
            <button type="submit" class="btn btn-primary">Save</button>
            <a href="/tasks" class="btn btn-secondary">Cancel</a>
        </form:form>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>