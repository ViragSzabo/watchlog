let moods = [];

function logMood(mood) {
    const currentDate = new Date().toLocaleDateString();
    moods.push({ mood, date: currentDate });
    updateGraph();
}

function updateGraph() {
    const ctx = document.getElementById('moodChart').getContext('2d');
    const moodCount = moods.reduce((acc, { mood }) => {
        acc[mood] = (acc[mood] || 0) + 1;
        return acc;
    }, {});

    const chartData = {
        labels: Object.keys(moodCount),
        datasets: [{
            label: 'Mood Frequency',
            data: Object.values(moodCount),
            backgroundColor: ['#ff6f61', '#ff7f50', '#ff8c00', '#d32f2f', '#4caf50', '#ff5722', '#8e44ad', '#2980b9'],
            borderColor: '#333',
            borderWidth: 1
        }]
    };

    new Chart(ctx, {
        type: 'bar',
        data: chartData,
        options: {
            responsive: true,
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}