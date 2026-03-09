[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=23047966)

# INSTRUCTIONS (From canvas) <><><><><>
Common Requirements (Everyone)
Step 1 — OOP Data Model (required)
Create Car.java with:

private fields for all columns

constructor

getters

toString() (one clean line: ID, Brand, Model, Year, Fuel, Color, Mileage)

Step 2 — Load the CSV (required)
Create loadCars(String filename) that:

skips header

parses each row into a Car

stores in ArrayList<Car>

skips malformed rows safely

prints: total cars loaded

Step 3 — Simple Sort (required)
You must write selection sort OR insertion sort (your choice).


Do NOT use Collections.sort() for this assessment.

After sorting, print the first 10 cars.

(You will choose how to sort the cars - choices below)

Step 4 — Binary Search (Required)
You must:

Sort the list by the correct key first.

Implement your own binary search method (no built-in search).

Return either:

The matching Car

Or index of match

Or null if not found

Binary search must:

Use low, high, mid

Use a loop (not recursion required)

Work correctly on sorted data

So depending on which field you chose to sort your data is what field you will search for.

Step 5 — Stats (required)
Print:

average mileage (working list)

counts by fuel type (working list)

Step 6 — Menu (required)
Your Main.java must show a menu that matches your project choice and includes:

one search

one sort

stats

exit

Choose ONE Project Option - one field to sort and search for Car objects
✅ Project A — “Brand + Efficiency Finder”
Your searches (choose one of these)
Search by Brand (case-insensitive exact match) OR

Search by Fuel_Type (case-insensitive exact match)

Your sort should match the field you chose to search.
Menu for Project A
Sort

Search by Brand OR

Search by Fuel Type

Show found car object(s)

Exit

✅ Project B — “Year + Color Explorer”
Your searches (choose one of these)
Search by Year Range (startYear–endYear inclusive) OR

Search by Color (case-insensitive exact match)

Your sort should match the field you chose to search.
Menu for Project B
Sort

Search by Year Range OR

Search by Color

Show found car object(s)

Exit

✅ Project C — “Model Search + Multi-Key Sort”
Your searches (choose one of these)
Search by Model (case-insensitive contains search, e.g., “civic” matches “Civic LX”) OR

Search by Mileage Threshold (find cars with mileage >= user value)

Your sort should match the field you chose to search.
Menu for Project C
Sort

Search by Model (contains) OR

Search by Mileage Threshold

Show found car object(s)
Exit

Submission
Push your repo to GitHub Classroom. Your program must run in Codespaces.

Grading (100 points)
Car class and Main class - separate files with proper methods in each.  Main contains an arraylist of type Car objects. Cars are created from the file and read into the arraylist.

Code is to standards - indentation, proper naming of variables and class names.  You name, date and comments in the code.
Code is pushed to github both days.  Pushing changes to the code to the assigned github repo.
Logic is implemented and works - at least one simple sort and binary search algorithms are implemented.