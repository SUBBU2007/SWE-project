<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Lab Tests - Comprehensive Healthcare</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
    <main>
        <h1>Manage Lab Tests</h1>
        <form action="../test" method="post" class="admin-form">
            <h2>Add Lab Test</h2>
            <div class="form-group">
                <label for="test-name">Test Name:</label>
                <input type="text" id="test-name" name="test_name" required>
            </div>
            <div class="form-group">
                <label for="lab-name">Lab Name:</label>
                <input type="text" id="lab-name" name="lab_name" required>
            </div>
            <div class="form-group">
                <label for="cost">Cost:</label>
                <input type="number" step="0.01" id="cost" name="cost" required>
            </div>
            <div class="form-group">
                <label for="insurance">Insurance Covered:</label>
                <input type="checkbox" id="insurance" name="insurance">
            </div>
            <button type="submit">Add Test</button>
        </form>
        <hr>
        <h2>Current Lab Tests</h2>
        <table id="lab-tests-table">
            <thead>
                <tr>
                    <th>Test Name</th>
                    <th>Lab Name</th>
                    <th>Cost</th>
                    <th>Insurance</th>
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
