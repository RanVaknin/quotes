package quotes;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class FetchQuote {
    public FetchQuote(){

    }
    public void getRandomQuote(String path) throws FileNotFoundException {
        StringBuilder str = new StringBuilder();
        try {
            Gson gson = new Gson();
            Scanner scanner = new Scanner(new File(path));
            while(scanner.hasNext()){
                str.append(scanner.nextLine());
            }

            Quote[] quotes = gson.fromJson(str.toString(), Quote[].class);

            Quote randomQuote = quotes[randomNumGenerator(quotes.length)];
            String authorAndQuote = "Author : " + randomQuote.getAuthor() + "  Quote : " + randomQuote.getText();
            System.out.println("authorAndQuote = " + authorAndQuote);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not find database/storage.");
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public int randomNumGenerator(int upperLimit){
        return (int) Math.ceil(Math.random()* upperLimit);
    }

}
