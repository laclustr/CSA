import csv

data = []

with open("imdb_tvshows.csv", "r", encoding="utf-8") as f:
	reader = csv.DictReader(f)

	data = list(reader)

with open("imdb_tvshow.csv", "w", encoding="utf-8", newline="") as f:
	writer = csv.DictWriter(f, fieldnames=list(data[0].keys()), delimiter="=")

	writer.writerows(data)