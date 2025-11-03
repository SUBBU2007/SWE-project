<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Health Assessment - Comprehensive Healthcare</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
    <main>
        <h1>Health Condition Assessment</h1>
        <form id="assessment-form" class="search-form">
            <div class="form-group">
                <label for="symptoms">Enter your symptoms (comma-separated):</label>
                <input type="text" id="symptoms" name="symptoms" required>
            </div>
            <button type="submit">Get Assessment</button>
        </form>
        <hr>
        <h2>Possible Conditions & Suggestions</h2>
        <div id="assessment-results">
            <!-- Data will be dynamically loaded here -->
        </div>
    </main>
    <script>
        document.getElementById('assessment-form').addEventListener('submit', function(event) {
            event.preventDefault();
            const symptoms = document.getElementById('symptoms').value;

            fetch(`assessment?symptoms=${symptoms}`)
                .then(response => response.json())
                .then(data => {
                    const resultsDiv = document.getElementById('assessment-results');
                    resultsDiv.innerHTML = '';
                    if (data.length > 0) {
                        const list = document.createElement('ul');
                        data.forEach(suggestion => {
                            const listItem = document.createElement('li');
                            listItem.textContent = suggestion;
                            list.appendChild(listItem);
                        });
                        resultsDiv.appendChild(list);
                    } else {
                        resultsDiv.innerHTML = '<p>No suggestions found for the entered symptoms.</p>';
                    }
                });
        });
    </script>
</body>
</html>
