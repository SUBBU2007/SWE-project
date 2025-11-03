<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - Comprehensive Healthcare</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
    <main>
        <h1>Admin Dashboard</h1>
        <div class="admin-links">
            <a href="manage_blood.jsp">Manage Blood Bank</a>
            <a href="manage_tests.jsp">Manage Lab Tests</a>
            <a href="manage_donors.jsp">Manage Organ Donors</a>
        </div>
    </main>
</body>
</html>
