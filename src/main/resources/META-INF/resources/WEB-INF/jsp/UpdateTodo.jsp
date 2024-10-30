<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<HTML>
<head>
    <title>Update Todo</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >

</head>
<body>
    <div class = "container">
        <h2>Add Todo</h2>
        <pre>${error}</pre>
        <form method="post">
            <div class = "form-group mb-3">
                <label for="taskName">Task Name:</label>
                <input class = "form-control w-25" type="text" id="taskName" name="taskName" value = ${todo.getTaskName()} required>
            </div>
            <div class = "form-group mb-3">
                <label for="startDate">Start Date:</label>
                <input class = "form-control w-25" type="date" id="startDate" name="startDate" value = ${todo.getStartDate()} required>
            </div>
            <div class = "form-group mb-3">
                <label for="finishDate">Finish Date:</label>
                <input class = "form-control w-25" type="date" id="finishDate" name="finishDate" value = ${todo.getFinishDate()} required>
            </div>
            <div class = "form-group mb-3">
                <label for="status">Status:</label>
                <select id="status" name="status" class = "form-control w-25" value = ${todo.getStatus()}>
                    <c:forEach items="${statuses}" var="statusValue">
                        <option value="${statusValue}"  <c:if test="${statusValue eq todo.getStatus()}">selected</c:if>>${statusValue.getMessage()}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class = "btn btn-success">Update Todo</button>
        </form>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</HTML>
