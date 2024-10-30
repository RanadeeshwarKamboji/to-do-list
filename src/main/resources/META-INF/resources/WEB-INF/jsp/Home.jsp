<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<HTML>
        <head>
            <title>Home</title>
            <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
        </head>
        <body>
            <div class="container">
                <h1>Welcome ${name} !!</h1>
            	<h2>Your Todos</h2>
            	<table class="table">
            		<thead>
            			<tr>
            			    <th>Id</th>
            				<th>Task</th>
            				<th>Created date</th>
            				<th>Start date</th>
            				<th>Target date</th>
            				<th>Status</th>
            			</tr>
            		</thead>
            		<tbody>
            			<c:forEach items="${todos}" var="todo">
            				<tr>
            				    <td>${todo.getId()}</td>
            					<td>${todo.getTaskName()}</td>
            					<td>${todo.getCreatedDate()}</td>
            					<td>${todo.getStartDate()}</td>
            					<td>${todo.getFinishDate()}</td>
                                <td>${todo.getStatus().getMessage()}</td>
            					<td> <a href="delete-todo?id=${todo.getId()}" class="btn btn-warning">Delete</a>   </td>
            					<td> <a href="update-todo?id=${todo.getId()}" class="btn btn-success">Update</a>   </td>
            				</tr>
            			</c:forEach>
            		</tbody>
            	</table>
            	<a href="add-todo" class="btn btn-success">Add Todo</a>
            </div>
            <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
            <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
        </body>
</HTML>