<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blood Availability - Comprehensive Healthcare</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
    <main>
        <h1>Blood Availability</h1>
        <form id="blood-search-form" class="search-form">
            <div class="form-group">
                <label for="city">City:</label>
                <input type="text" id="city" name="city" required>
            </div>
            <div class="form-group">
                <label for="blood-group">Blood Group:</label>
                <input type="text" id="blood-group" name="blood_group" required>
            </div>
            <button type="submit">Search</button>
        </form>
        <hr>
        <h2>Available Blood Stock</h2>
        <table id="blood-results-table">
            <thead>
                <tr>
                    <th>Hospital</th>
                    <th>City</th>
                    <th>Blood Group</th>
                    <th>Units</th>
                </tr>
            </thead>
            <tbody>
                <!-- Data will be dynamically loaded here -->
            </tbody>
        </table>
    </main>
    <script>
        document.getElementById('blood-search-form').addEventListener('submit', function(event) {
            event.preventDefault();
            const city = document.getElementById('city').value;
            const bloodGroup = document.getElementById('blood-group').value;

            fetch(`blood?city=${city}&blood_group=${bloodGroup}`)
                .then(response => response.json())
                .then(data => {
                    const tableBody = document.querySelector('#blood-results-table tbody');
                    tableBody.innerHTML = '';
                    data.forEach(stock => {
                        const row = `<tr>
                            <td>${stock.hospital}</td>
                            <td>${stock.city}</td>
                            <td>${stock.bloodGroup}</td>
                            <td>${stock.units}</td>
                        </tr>`;
                        tableBody.innerHTML += row;
                    });
                });
        });
    </script>
</body>
</html>
