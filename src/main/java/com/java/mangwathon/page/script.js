class Tournament {
    constructor(name, players) {
        this.name = name;
        this.players = players.map(player => ({
            ...player,
            totalScore: 0,
            matches: [],
        }));
        this.currentlyOpenPlayer = null;
    }

    compete(player1, player2) {
        let score1 = 0;
        let score2 = 0;

        for (const skill of Object.keys(player1.skills)) {
            if (player1.skills[skill] > player2.skills[skill]) score1++;
            else if (player1.skills[skill] < player2.skills[skill]) score2++;
        }

        let winner;
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

        const matchResult = { player1: player1.name, player2: player2.name, score1, score2, winner };
        player1.matches.push(matchResult);
        player2.matches.push(matchResult);
    }

    displayMatchResult(match) {
        return `
      <div class="match">
        <strong>${match.player1} vs ${match.player2}</strong><br>
        <div class="result">
          <strong>Score:</strong> ${match.score1} - ${match.score2}<br>
          <strong>Winner:</strong> ${match.winner}
        </div>
      </div>
    `;
    }

    togglePlayerMatches(playerName) {
        const player = this.players.find(p => p.name === playerName);
        const playerMatchesSection = document.getElementById('player-matches');
        if (!playerMatchesSection) return;

        if (this.currentlyOpenPlayer === playerName) {
            playerMatchesSection.style.display = 'none';
            this.currentlyOpenPlayer = null;
        } else {
            const matchesHTML = player.matches.map(match => this.displayMatchResult(match)).join('');
            playerMatchesSection.innerHTML = `<h3>Matches for ${player.name}:</h3>${matchesHTML}`;
            playerMatchesSection.style.display = 'block';
            this.currentlyOpenPlayer = playerName;
        }
    }

    run() {
        console.log(`${this.name} is starting...`);

        // Reset players scores and matches
        this.players.forEach(player => {
            player.totalScore = 0;
            player.matches = [];
        });

        // Run all unique matchups
        for (let i = 0; i < this.players.length; i++) {
            for (let j = i + 1; j < this.players.length; j++) {
                this.compete(this.players[i], this.players[j]);
            }
        }

        // Sort by totalScore descending
        this.players.sort((a, b) => b.totalScore - a.totalScore);

        // Render standings table
        const standingsBody = document.querySelector('#standings tbody');
        if (!standingsBody) return;

        standingsBody.innerHTML = '';
        this.players.forEach(player => {
            const row = standingsBody.insertRow();
            const nameCell = row.insertCell(0);
            const scoreCell = row.insertCell(1);

            nameCell.innerHTML = `<span class="player-name" style="cursor:pointer; text-decoration: underline;">📂 ${player.name}</span>`;
            scoreCell.textContent = player.totalScore;

            nameCell.querySelector('.player-name').onclick = () => this.togglePlayerMatches(player.name);
        });
    }

    generatePlayerStatsHTML() {
        return this.players.map(player => `
      <div class="player-stats">
        <h3>${player.name}</h3>
        <p><strong>Total Score:</strong> ${player.totalScore}</p>
        <p><strong>Skills:</strong></p>
        <ul>
          ${Object.entries(player.skills).map(([skill, value]) => `<li>${skill}: ${value}</li>`).join('')}
        </ul>
      </div>
    `).join('');
    }
}

const showPlayerStats = (tournament) => {
    const standingsSection = document.getElementById('standings');
    const matchesSection = document.getElementById('player-matches');
    const statsSection = document.getElementById('player-stats');

    if (standingsSection) standingsSection.style.display = 'none';
    if (matchesSection) matchesSection.style.display = 'none';

    if (statsSection) {
        statsSection.innerHTML = `<h2>Player Stats - ${tournament.name}</h2>${tournament.generatePlayerStatsHTML()}`;
        statsSection.style.display = 'block';
    }
};

// Example players
const sprintPlayers = [
    { name: "Geri", skills: { Strength: 7, Cardio: 1, Stretching: 3, Magic: 4, Weapon: 4, Combat: 1 } },
    { name: "Dirk", skills: { Strength: 1, Cardio: 1, Stretching: 1, Magic: 1, Weapon: 1, Combat: 1 } },
    { name: "Virag", skills: { Strength: 4, Cardio: 0, Stretching: 3, Magic: 1, Weapon: 0, Combat: 0 } },
    { name: "Rina", skills: { Strength: 2, Cardio: 0, Stretching: 0, Magic: 3, Weapon: 0, Combat: 0 } },
    { name: "Adel", skills: { Strength: 2, Cardio: 5, Stretching: 0, Magic: 5, Weapon: 0, Combat: 2 } },
    { name: "Fanni", skills: { Strength: 6, Cardio: 5, Stretching: 2, Magic: 4, Weapon: 3, Combat: 0 } },
    { name: "Mithrillion", skills: { Strength: 5, Cardio: 6, Stretching: 0, Magic: 0, Weapon: 0, Combat: 0 } },
    { name: "Ruby", skills: { Strength: 2, Cardio: 2, Stretching: 0, Magic: 0, Weapon: 0, Combat: 1 } },
];

const summerPlayers = [
    ...sprintPlayers,
    { name: "New Player", skills: { Strength: 0, Cardio: 0, Stretching: 0, Magic: 0, Weapon: 0, Combat: 0 } }
];

// Instantiate tournaments
const sprintTournament = new Tournament("Sprint Tournament", sprintPlayers);
const summerTournament = new Tournament("Summer Tournament", summerPlayers);

// Setup UI & event listeners on window load
window.onload = () => {
    let currentTournament = sprintTournament;

    const switchButtons = {
        sprint: document.getElementById('switch-to-sprint'),
        summer: document.getElementById('switch-to-summer'),
    };

    const standingsSection = document.getElementById('standings');
    const playerStatsSection = document.getElementById('player-stats');

    const setActiveButton = (active) => {
        Object.entries(switchButtons).forEach(([key, btn]) => {
            if (btn) btn.classList.toggle('active', key === active);
        });
    };

    // Date check: only enable summer tournament after July 27
    const now = new Date();
    const enableSummerDate = new Date(now.getFullYear(), 6, 27); // Month is 0-based, so 6 = July

    if (switchButtons.sprint) {
        switchButtons.sprint.onclick = () => {
            sprintTournament.run();
            currentTournament = sprintTournament;
            setActiveButton('sprint');
            if (playerStatsSection) playerStatsSection.style.display = 'none';
            if (standingsSection) standingsSection.style.display = 'block';
        };
    }

    if (switchButtons.summer) {
        if (now >= enableSummerDate) {
            // Enable summer tournament button and functionality
            switchButtons.summer.onclick = () => {
                summerTournament.run();
                currentTournament = summerTournament;
                setActiveButton('summer');
                if (playerStatsSection) playerStatsSection.style.display = 'none';
                if (standingsSection) standingsSection.style.display = 'block';
            };
        } else {
            // Disable or hide summer tournament button before July 27
            switchButtons.summer.disabled = true;
            switchButtons.summer.title = "Available after July 27";
            // Or: switchButtons.summer.style.display = 'none';
        }
    }

    const showPlayersBtn = document.getElementById('show-players');
    if (showPlayersBtn) {
        showPlayersBtn.onclick = () => showPlayerStats(currentTournament);
    }

    // Initial run
    sprintTournament.run();
    setActiveButton('sprint');
};