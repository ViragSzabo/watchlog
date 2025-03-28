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
    const skillNames = Object.keys(player1.skills);
    let score1 = 0;
    let score2 = 0;

    skillNames.forEach(skill => {
        const p1Skill = player1.skills[skill];
        const p2Skill = player2.skills[skill];
        if (p1Skill > p2Skill) {
            score1++;
        } else if (p1Skill < p2Skill) {
            score2++;
        }
    });

    player1.totalScore += score1;
    player2.totalScore += score2;

    const matchResult = ` 
    <div class="match">
        <strong>${player1.name} vs ${player2.name}</strong><br>
        <div class="skills">
            <div><strong>${player1.name} Skills:</strong></div>
            <ul>
                ${Object.entries(player1.skills).map(([skill, value]) =>
        `<li><strong>${skill}:</strong> ${value}</li>`
    ).join('')}
            </ul>
            <div><strong>${player2.name} Skills:</strong></div>
            <ul>
                ${Object.entries(player2.skills).map(([skill, value]) =>
        `<li><strong>${skill}:</strong> ${value}</li>`
    ).join('')}
            </ul>
        </div>
        <div class="result">
            <strong>Winner:</strong> 
            ${score1 > score2 ? `<span class="winner">${player1.name}</span>` :
        score1 < score2 ? `<span class="winner">${player2.name}</span>` :
            `<span class="draw">Draw</span>`}
        </div>
    </div>
`;

    player1.matches.push(matchResult);
    player2.matches.push(matchResult);
}

function togglePlayerMatches(playerName) {
    const player = players.find(p => p.name === playerName);
    const playerMatchesSection = document.getElementById('player-matches');

    // If the clicked player's matches are already open, close them
    if (currentlyOpenPlayer === playerName) {
        playerMatchesSection.style.display = 'none';
        currentlyOpenPlayer = null;
    } else {
        // If another player's matches are open, close them first
        if (currentlyOpenPlayer) {
            document.getElementById('player-matches').style.display = 'none';
        }

        // Open the selected player's matches
        const matchList = player.matches.join('');
        playerMatchesSection.innerHTML = `
            <h3>Matches for ${player.name}:</h3>
            ${matchList}
        `;
        playerMatchesSection.style.display = 'block';
        currentlyOpenPlayer = playerName;
    }
}

function runTournament() {
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