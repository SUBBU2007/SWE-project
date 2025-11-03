<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Organ Donation - Comprehensive Healthcare</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
    <main>
        <h1>Organ Donation</h1>
        <form action="donor" method="post" class="auth-form">
            <h2>Register as a Donor</h2>
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="age">Age:</label>
                <input type="number" id="age" name="age" required>
            </div>
            <div class="form-group">
                <label for="organ">Organ:</label>
                <input type="text" id="organ" name="organ" required>
            </div>
            <button type="submit">Register</button>
        </form>
        <hr>
        <h2>Organ Donor Waiting List</h2>
        <table id="donor-list-table">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Organ</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <!-- Data will be dynamically loaded here -->
            </tbody>
        </table>
    </main>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            fetch('donor')
                .then(response => response.json())
                .then(data => {
                    const tableBody = document.querySelector('#donor-list-table tbody');
                    tableBody.innerHTML = '';
                    data.forEach(donor => {
                        const row = `<tr>
                            <td>${donor.name}</td>
                            <td>${donor.age}</td>
                            <td>${donor.organ}</td>
                            <td>${donor.status}</td>
                        </tr>`;
                        tableBody.innerHTML += row;
                    });
                });
        });
    </script>
</body>
</html>
