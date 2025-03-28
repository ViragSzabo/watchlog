from collections import Counter
from datetime import datetime

# Prices for drinks and food
prices = {
    "Cinnamon Chai Latte": 4.80,
    "Pumpkin Spice Latte": 5.00,
    "Caramel Latte": 6.00,
    "Caffe mocha": 4.95,
    "Golden Turmeric latte": 4.50,
    "Cappuccino": 4.95,
    "White tea": 3.95,
    "Matcha latte": 4.50,
    "Vanilla Honey Chai latte": 4.50,
    "Iced strawberry matcha": 6.00,
    "Water klein": 1.50,
    "Appeltaart": 4.50,
    "Chocolate brownie cake": 4.80,
    "Pistachio cheesecake": 6.00,
    "Carrot cake": 4.80,
    "Matcha roll": 6.00
}

# Order history with timestamps
order_data = [
    (["Cinnamon Chai Latte", "Water klein"], "2024.10.25."),
    (["Pumpkin Spice Latte", "Caramel Latte"], "2024.11.10."),
    (["Caffe mocha", "Water klein", "Cappuccino"], "2024.11.28."),
    (["Golden Turmeric latte", "Appeltaart", "Cappuccino"], "2024.11.28."),
    (["White tea", "Chocolate brownie cake", "Cinnamon Chai Latte"], "2024.12.03."),
    (["Cappuccino"], "2024.12.11."),
    (["Cappuccino", "Pistachio cheesecake", "White tea"], "2025.02.19."),
    (["White tea", "Matcha latte"], "2025.02.26."),
    (["Cappuccino", "Carrot cake", "Vanilla Honey Chai latte"], "2025.03.19."),
    (["White tea", "Matcha roll"], "2025.03.23."),
    (["Iced strawberry matcha"], "2025.03.27.")
]

# Convert dates to datetime objects
order_data = [(order, datetime.strptime(date, "%Y.%m.%d.")) for order, date in order_data]

# Calculate total spending per year and month
spending_per_year = {}
spending_per_month = {}
order_totals = []  # Store order totals

for order, date in order_data:
    total = sum(prices[item] for item in order)
    order_totals.append(total)

    year = date.year
    month = (date.year, date.month)  # (year, month) tuple

    spending_per_year[year] = spending_per_year.get(year, 0) + total
    spending_per_month[month] = spending_per_month.get(month, 0) + total

# Find most and least expensive orders
max_order = max(order_totals)
min_order = min(order_totals)

# Count item frequency
item_counts = Counter(item for order, _ in order_data for item in order)
top_5_items = item_counts.most_common(5)

# Calculate averages
average_order_spend = sum(order_totals) / len(order_totals)

# Output results
summary = {
    "Total Spending Per Year": spending_per_year,
    "Total Spending Per Month": spending_per_month,
    "Top 5 Most Ordered Items": top_5_items,
    "Average Order Spend": round(average_order_spend, 2),
    "Most Expensive Order": max_order,
    "Least Expensive Order": min_order
}

for key, value in summary.items():
    print(f"{key}:")
    if isinstance(value, dict):
        for sub_key, sub_value in value.items():
            print(f"    {sub_key}: {sub_value}")
    else:
        print(f"    {value}")
    print()  