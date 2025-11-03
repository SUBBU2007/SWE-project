<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Surgeon Locator - Comprehensive Healthcare</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
    <main>
        <h1>Surgeon Locator</h1>
        <form id="surgeon-search-form" class="search-form">
            <div class="form-group">
                <label for="specialty">Specialty:</label>
                <input type="text" id="specialty" name="specialty" required>
            </div>
            <button type="submit">Search</button>
        </form>
        <hr>
        <h2>Surgeon Results</h2>
        <div id="surgeon-results">
            <!-- Data will be dynamically loaded here -->
        </div>
        <div id="map-placeholder" style="width: 100%; height: 400px; background-color: #eee; text-align: center; line-height: 400px; margin-top: 2rem;">
            Google Map Placeholder
        </div>
    </main>
    <script>
        document.getElementById('surgeon-search-form').addEventListener('submit', function(event) {
            event.preventDefault();
            const specialty = document.getElementById('specialty').value;

            fetch(`surgeon?specialty=${specialty}`)
                .then(response => response.json())
                .then(data => {
                    const resultsDiv = document.getElementById('surgeon-results');
                    resultsDiv.innerHTML = '';
                    data.forEach(surgeon => {
                        const surgeonCard = `
                            <div class="card">
                                <h3>${surgeon.name}</h3>
                                <p><strong>Specialty:</strong> ${surgeon.specialty}</p>
                                <p><strong>Hospital:</strong> ${surgeon.hospital}</p>
                                <p><strong>Location:</strong> ${surgeon.location}</p>
                                <p><strong>Contact:</strong> ${surgeon.contact}</p>
                            </div>
                        `;
                        resultsDiv.innerHTML += surgeonCard;
                    });
                });
        });
    </script>
</body>
</html>
