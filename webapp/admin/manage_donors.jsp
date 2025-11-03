<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Organ Donors - Comprehensive Healthcare</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
    <main>
        <h1>Manage Organ Donors</h1>
        <h2>Donor Registrations</h2>
        <table id="donors-table">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Organ</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <!-- Data will be dynamically loaded here -->
            </tbody>
        </table>
    </main>
</body>
</html>
