<HTML>
<head>
    <title>Login</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >

</head>
<body>
    <div class = "container">
        <h2>Login</h2>
        <pre>${error}</pre>
        <form method="post">
            <div class = "form-group mb-3">
                <label for="userName">Username:</label>
                <input class = "form-control w-25" type="text" id="userName" name="userName" required>
            </div>
            <div class = "form-group mb-3">
                <label for="password">Password:</label>
                <input class = "form-control w-25" type="password" id="password" name="password" required>
            </div>
            <button type="submit" class = "btn btn-success">Login</button>
        </form>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</HTML>
