<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Test Cost Comparison - Comprehensive Healthcare</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
    <main>
        <h1>Test Cost Comparison</h1>
        <form id="test-search-form" class="search-form">
            <div class="form-group">
                <label for="test-name">Test Name:</label>
                <input type="text" id="test-name" name="test_name" required>
            </div>
            <button type="submit">Search</button>
        </form>
        <hr>
        <h2>Test Results</h2>
        <table id="test-results-table">
            <thead>
                <tr>
                    <th>Test Name</th>
                    <th>Lab Name</th>
                    <th>Cost</th>
                    <th>Insurance Coverage</th>
                </tr>
            </thead>
            <tbody>
                <!-- Data will be dynamically loaded here -->
            </tbody>
        </table>
    </main>
    <script>
        document.getElementById('test-search-form').addEventListener('submit', function(event) {
            event.preventDefault();
            const testName = document.getElementById('test-name').value;

            fetch(`test?test_name=${testName}`)
                .then(response => response.json())
                .then(data => {
                    const tableBody = document.querySelector('#test-results-table tbody');
                    tableBody.innerHTML = '';
                    data.forEach(test => {
                        const row = `<tr>
                            <td>${test.testName}</td>
                            <td>${test.labName}</td>
                            <td>$${test.cost.toFixed(2)}</td>
                            <td>${test.insurance ? 'Yes' : 'No'}</td>
                        </tr>`;
                        tableBody.innerHTML += row;
                    });
                });
        });
    </script>
</body>
</html>
