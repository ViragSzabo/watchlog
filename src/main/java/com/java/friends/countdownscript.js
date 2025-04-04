function getNextSunday6AM() {
    const now = new Date();
    const day = now.getDay();
    const diff = (7 - day) % 7;
    const nextSunday = new Date(now);

    nextSunday.setDate(now.getDate() + diff);
    nextSunday.setHours(6, 0, 0, 0); // 6AM

    if (now > nextSunday) {
        nextSunday.setDate(nextSunday.getDate() + 7);
    }

    return nextSunday;
}

function updateCountdown() {
    const now = new Date().getTime();
    const target = getNextSunday6AM().getTime();
    const timeLeft = target - now;

    const seconds = Math.floor((timeLeft / 1000) % 60);
    const minutes = Math.floor((timeLeft / 1000 / 60) % 60);
    const hours = Math.floor((timeLeft / (1000 * 60 * 60)) % 24);
    const days = Math.floor(timeLeft / (1000 * 60 * 60 * 24));

    const distance = timeLeft;

    document.getElementById("days").innerText = days;
    document.getElementById("hours").innerText = hours;
    document.getElementById("minutes").innerText = minutes;
    document.getElementById("seconds").innerText = seconds;

    if (distance < 0) {
        clearInterval(x);
        document.getElementById("countdown").innerHTML = "⏰ It's Time! 💕";
        showPopup();
    }
}

const playlist = ['music/getawaycar.mp3', 'music/foreveralways.mp3', 'music/paperrings.mp3',
                            'music/readytorun.mp3', 'music/whatafeeling.mp3', 'music/oial.mp3'];
let currentTrack = 0;
const audio = document.getElementById("bg-music");
const lyricElement = document.getElementById('current-lyric');

document.getElementById("play").addEventListener("click", () => {
    audio.play();
});

document.getElementById("pause").addEventListener("click", () => {
    audio.pause();
});

document.getElementById("next").addEventListener("click", () => {
    currentTrack = (currentTrack + 1) % playlist.length;
    changeTrack();
});

document.getElementById("prev").addEventListener("click", () => {
    currentTrack = (currentTrack - 1 + playlist.length) % playlist.length;
    changeTrack();
});

document.getElementById("volume-control").addEventListener("input", function(event) {
    const music = document.getElementById("bg-music");
    music.volume = event.target.value;
});

function changeTrack() {
    audio.src = playlist[currentTrack];
    audio.play();
}

function confetti() {
    confetti({
        particleCount: 100,
        spread: 70,
        origin: { y: 0.6 }
    });
}

function showPopup() {
    const popup = document.getElementById("popup");
    popup.classList.add("show");
    confetti();
}

setInterval(updateCountdown, 1000);