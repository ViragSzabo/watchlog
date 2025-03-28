from collections import defaultdict, Counter
from datetime import datetime

# Watching data (date: episodes watched)
watch_log = {
    "2025.02.23": ["S1E1", "S1E2", "S1E3", "S1E4", "S1E5", "S1E6", "S1E7", "S1E8"],
    "2025.03.01": ["S1E9", "S1E1", "S1E2", "S1E3", "S1E4"],
    "2025.03.02": ["S1E5", "S1E6", "S1E7", "S1E8", "S1E9"],
    "2025.03.07": ["S1E10"],
    "2025.03.14": ["S1E11", "S1E11"],
    "2025.03.21": ["S1E12", "S1E12"],
    "2025.03.23": ["S1E1", "S1E2", "S1E3", "S1E4", "S1E5", "S1E6", "S1E7"],
    "2025.03.24": ["S1E8", "S1E9", "S1E10"],
    "2025.03.25": ["S1E11", "S1E12"],
    "2025.03.26": ["S1E1", "S1E2", "S1E3", "S1E4", "S1E5"],
    "2025.03.27": ["S1E6", "S1E7"],
    "2025.03.28": ["S1E8","S1E9", "S1E10", "S1E11","S1E12","S1E13"],
}

# 1. Total episodes watched
total_episodes = sum(len(episodes) for episodes in watch_log.values())

# 2. Count how many times each episode was watched
episode_counts = Counter([ep for episodes in watch_log.values() for ep in episodes])

# 3. Most-watched day of the week
day_counts = defaultdict(int)
for date in watch_log:
    day_of_week = datetime.strptime(date, "%Y.%m.%d").strftime("%A")
    day_counts[day_of_week] += 1
most_watched_day = max(day_counts, key=day_counts.get)

# 4. Total rewatch count (episodes watched more than once)
rewatch_count = sum(count - 1 for count in episode_counts.values() if count > 1)

# 5. Total watching sessions
total_sessions = len(watch_log)

# 6. Calculate total watch time per day
episode_duration = 50  # in minutes
watch_time_per_day = {date: len(episodes) * episode_duration for date, episodes in watch_log.items()}
total_watch_time = sum(watch_time_per_day.values())

# Print results
print("The Pitt Watching Stats:\n")
print(f"Total episodes watched: {total_episodes}")
print(f"Total watching sessions: {total_sessions}")
print(f"Most-watched day: {most_watched_day}")
print(f"Total rewatches: {rewatch_count}")
print("\nEpisodes watched counts:")
for ep in range(1,14):
    ep = f"S1E{ep}"
    count = episode_counts.get(ep, 0)
    print(f"  {ep}: {count} times")
print("\nWatch Time Per Day:")
for date, time in watch_time_per_day.items():
    print(f"{date}: {time} minutes ({time // 60} hours and {time % 60} minutes)")