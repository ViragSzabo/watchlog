const players = [
    { name: "Geri", skills: { Strength: 7, Cardio: 1, Stretching: 3, Magic: 4, Weapon: 4, Combat: 1 }, totalScore: 0, matches: [] },
    { name: "Dirk", skills: { Strength: 1, Cardio: 1, Stretching: 1, Magic: 1, Weapon: 1, Combat: 1 }, totalScore: 0, matches: [] },
    { name: "Virag", skills: { Strength: 4, Cardio: 0, Stretching: 3, Magic: 1, Weapon: 0, Combat: 0 }, totalScore: 0, matches: [] },
    { name: "Rina", skills: { Strength: 2, Cardio: 0, Stretching: 0, Magic: 3, Weapon: 0, Combat: 0 }, totalScore: 0, matches: [] },
    { name: "Adel", skills: { Strength: 2, Cardio: 5, Stretching: 0, Magic: 5, Weapon: 0, Combat: 2 }, totalScore: 0, matches: [] },
    { name: "Fanni", skills: { Strength: 6, Cardio: 5, Stretching: 2, Magic: 4, Weapon: 3, Combat: 0 }, totalScore: 0, matches: [] },
    { name: "Mithrillion", skills: { Strength: 5, Cardio: 6, Stretching: 0, Magic: 0, Weapon: 0, Combat: 0 }, totalScore: 0, matches: [] }
];

let currentlyOpenPlayer = null;

function compete(player1, player2) {
    let score1 = 0, score2 = 0;

    Object.keys(player1.skills).forEach(skill => {
        if (player1.skills[skill] > player2.skills[skill]) score1++;
        else if (player1.skills[skill] < player2.skills[skill]) score2++;
    });

    let winner = null;
    if (score1 > score2) {
        winner = player1.name;
        player1.totalScore += 3;
    } else if (score2 > score1) {
        winner = player2.name;
        player2.totalScore += 3;
    } else {
        winner = "Draw";
        player1.totalScore += 1;
        player2.totalScore += 1;
    }

    const matchResult = {
        player1: player1.name,
        player2: player2.name,
        score1,
        score2,
        winner
    };

    player1.matches.push(matchResult);
    player2.matches.push(matchResult);
}

function displayMatchResult(match) {
    return `<div class="match">
            <strong>${match.player1} vs ${match.player2}</strong><br>
            <div class="result">
                <strong>Score:</strong> ${match.score1} - ${match.score2}<br>
                <strong>Winner:</strong> ${match.winner}
            </div>
        </div>`;
}

function togglePlayerMatches(playerName) {
    const player = players.find(p => p.name === playerName);
    const playerMatchesSection = document.getElementById('player-matches');

    if (currentlyOpenPlayer === playerName) {
        playerMatchesSection.style.display = 'none';
        currentlyOpenPlayer = null;
    } else {
        if (currentlyOpenPlayer) {
            document.getElementById('player-matches').style.display = 'none';
        }

        const matchList = player.matches.map(displayMatchResult).join('');
        playerMatchesSection.innerHTML = `
            <h3>Matches for ${player.name}:</h3>
            ${matchList}
        `;
        playerMatchesSection.style.display = 'block';
        currentlyOpenPlayer = playerName;
    }
}

function runTournament() {
    players.forEach(player => {
        const row = standingsTableBody.insertRow();
        const cellName = row.insertCell(0);
        const cellScore = row.insertCell(1);

        // Add emoji and make it clickable
        cellName.innerHTML = `📂 <span style="cursor: pointer; text-decoration: underline;">${player.name}</span>`;
        cellScore.textContent = player.totalScore;

        cellName.onclick = function() {
            togglePlayerMatches(player.name);
        };
    });
}

function runTournament2() {
    console.log("Tournament is starting...");

    // Run the matches and calculate the scores
    for (let i = 0; i < players.length; i++) {
        for (let j = i + 1; j < players.length; j++) {
            compete(players[i], players[j]);
        }
    }

    // Sort players by score
    players.sort((a, b) => b.totalScore - a.totalScore);

    // Log to verify if players' scores and data are correctly calculated
    console.log(players);

    // Populate the standings table with player names and scores
    const standingsTableBody = document.getElementById('standings').getElementsByTagName('tbody')[0];
    standingsTableBody.innerHTML = ''; // Clear any previous content (if any)

    players.forEach(player => {
        const row = standingsTableBody.insertRow();
        const cellName = row.insertCell(0);
        const cellScore = row.insertCell(1);

        cellName.textContent = player.name;
        cellScore.textContent = player.totalScore;

        cellName.style.cursor = 'pointer';
        cellName.onclick = function() {
            togglePlayerMatches(player.name);
        };
    });
}

window.onload = function() {
    runTournament(); // This should trigger the population of standings
};