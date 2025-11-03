<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Comprehensive Healthcare</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
    <main>
        <form action="login" method="post" class="auth-form">
            <h2>Login</h2>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit">Login</button>
            <p>Don't have an account? <a href="signup.jsp">Sign up</a></p>
        </form>
    </main>
</body>
</html>
