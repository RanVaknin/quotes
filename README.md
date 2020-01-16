## **Quotes**

- the app has two classes:
    - Quote class - digs through the object according to the requirments with 4 fields, text, author, tags and likes.
    - A FetchQuote class that utilizes two methods:
    
- method 1 getRandomQuote: this method creates an empty stirng to build upon. imports a gson object. 
Creates a scanner object to read through the input file path.

then creates a Quote array and de - serializes the JSON and stores it into an array of quote objects.

- method 2 randomNumberGenerator generates a random number between 0 and an upper limit.

method 1 utilizes method 2 by finding a random index in our Quote array and prints a string representing a random quote an author from the file.