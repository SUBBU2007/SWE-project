<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Blood Bank - Comprehensive Healthcare</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
    <main>
        <h1>Manage Blood Bank</h1>
        <form action="../blood" method="post" class="admin-form">
            <h2>Add Blood Stock</h2>
            <div class="form-group">
                <label for="hospital">Hospital:</label>
                <input type="text" id="hospital" name="hospital" required>
            </div>
            <div class="form-group">
                <label for="city">City:</label>
                <input type="text" id="city" name="city" required>
            </div>
            <div class="form-group">
                <label for="blood-group">Blood Group:</label>
                <input type="text" id="blood-group" name="blood_group" required>
            </div>
            <div class="form-group">
                <label for="units">Units:</label>
                <input type="number" id="units" name="units" required>
            </div>
            <button type="submit">Add Stock</button>
        </form>
        <hr>
        <h2>Current Blood Stock</h2>
        <table id="blood-stock-table">
            <thead>
                <tr>
                    <th>Hospital</th>
                    <th>City</th>
                    <th>Blood Group</th>
                    <th>Units</th>
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
