# Information Scraper
# CS-321
# The purpose of this information scraper is to extract the menu item name, calorie count, protein count, and allergens
# into a CSV file


# imports
from typing import TextIO

import pandas as pd
import bs4
import csv
import requests
from bs4 import BeautifulSoup

# Getting Access to the website to scrape the information from
page = requests.get("https://menus.sodexomyway.com/BiteMenu/Menu?menuId=16652&locationId=27747003&whereami=http://masondining.sodexomyway.com/dining-near-me/southside")
soup = BeautifulSoup(page.content, 'html.parser')

# Finding respective meal time menus
day = soup.find("div", class_="bite-day-menu", id="menuid-27-day")
breakfast = day.find(class_="accordion-block breakfast")
lunch = day.find(class_="accordion-block lunch")
dinner = day.find(class_="accordion-block dinner")
lateNight = day.find(class_="accordion-block late night")

# name = soup.find_all(class_= "col-xs-9")
# calories = soup.find_all(class_="col-xs-3 text-right")

# extracting name and calories of each eating time
breakName = breakfast.find_all(class_="col-xs-9")
breakCalories = breakfast.find_all(class_="col-xs-3 text-right")

lunchName = lunch.find_all(class_="col-xs-9")
lunchCalories = lunch.find_all(class_="col-xs-3 text-right")

dinnerName = dinner.find_all(class_="col-xs-9")
dinnerCalories = dinner.find_all(class_="col-xs-3 text-right")

lateNightName = lateNight.find_all(class_="col-xs-9")
lateNightCalories = lateNight.find_all(class_="col-xs-3 text-right")

df = pd.DataFrame(list())
df.to_csv('empty_csv.csv')
foodTypeBreakfast = ['Breakfast']
foodTypeLunch = ['Lunch']
foodTypeDinner = ['Dinner']
foodTypeLateNight = ['Late Night']

listFile = open('empty_csv.csv', 'w')
writer = csv.writer(listFile)
writer.writerow(foodTypeBreakfast)

# Breakfast Portion
x = 0
print("\nBreakfast")
for i in breakName:
    first = breakName[x]
    second = breakCalories[x]

    x += 1
    test = first.find(class_="get-nutritioncalculator primary-textcolor").get_text()
    test1 = second.find(class_="get-nutrition primary-textcolor").get_text()

    test = test.replace('', "")
    test1 = test1.replace('', "")

    result = [test, test1]
    writer.writerow(result)

    print("\n................")
    print(test)
    print(test1)

x = 0
# Lunch Portion
writer.writerow(foodTypeLunch)
print("\nLunch")
for i in lunchName:
    first = lunchName[x]
    second = lunchCalories[x]
    x += 1
    test = first.find(class_="get-nutritioncalculator primary-textcolor").get_text()
    test1 = second.find(class_="get-nutrition primary-textcolor").get_text()

    test = test.replace('', "")
    test1 = test1.replace('', "")

    result = [test, test1]
    writer.writerow(result)

    print("\n................")
    print(test)
    print(test1)

# Dinner Portion
print("\nDinner")
x = 0
writer.writerow(foodTypeDinner)
for i in dinnerName:
    first = dinnerName[x]
    second = dinnerCalories[x]
    x += 1
    test = first.find(class_="get-nutritioncalculator primary-textcolor").get_text()
    test1 = second.find(class_="get-nutrition primary-textcolor").get_text()

    test = test.replace('', "")
    test1 = test1.replace('', "")

    result = [test, test1]
    writer.writerow(result)

    print("\n................")
    print(test)
    print(test1)

x = 0
writer.writerow(foodTypeLateNight)

# Late Night Portion
print("\nLate Night")
for i in lateNightName:
    first = lateNightName[x]
    second = lateNightCalories[x]
    x += 1
    test = first.find(class_="get-nutritioncalculator primary-textcolor").get_text()
    test1 = second.find(class_="get-nutrition primary-textcolor").get_text()

    test = test.replace('', "")
    test1 = test1.replace('', "")

    result = [test, test1]
    writer.writerow(result)

    print("\n................")
    print(test)
    print(test1)

f = open("empty_csv.csv", 'rt')
try:
    for row in csv.reader(f, delimiter=",", skipinitialspace=False):
        (''.join(row))
finally:
    f.close()
