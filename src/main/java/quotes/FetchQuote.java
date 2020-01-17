package quotes;

import com.google.gson.Gson;

import java.io.*;

import java.net.HttpURLConnection;
import java.net.URL;

public class FetchQuote {

    public FetchQuote() {
    }

    public void getRandomQuoteInternet(String apiUrl, String path) throws IOException {
        ReadAndWrite readAndWrite = new ReadAndWrite();
        InternetQuote internetQuote;
        StringBuilder str = new StringBuilder();

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //define type of method.
            connection.setRequestMethod("GET");

            //Set request header
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;

            StringBuffer content = new StringBuffer();
            while ((inputLine = reader.readLine()) != null) {
                content.append(inputLine);
            }
            reader.close();

            str = readAndWrite.readMyFile(path,str);
            str.setLength(str.length() - 1);
            readAndWrite.writeToFile(str.toString(),path);
            readAndWrite.closeFile();


            Gson gson = new Gson();
            internetQuote = gson.fromJson(content.toString(), InternetQuote.class);
            System.out.println("..::>> Quote from internet <<::.. \n Author : " + internetQuote.getQuoteAuthor() + "  Quote : " + internetQuote.getQuoteText());

            //adding to JSON file
            readAndWrite.usingBufferedWritter("src/main/resources/quotes.json","," + content.toString() + "]");

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void getRandomQuoteLocal(String path) throws IOException {
        ReadAndWrite readAndWrite = new ReadAndWrite();
        Quote randomQuote;
        StringBuilder str = new StringBuilder();
        try {
            Gson gson = new Gson();

            readAndWrite.readMyFile(path,str);

            Quote[] quotes = gson.fromJson(str.toString(), Quote[].class);
            randomQuote = quotes[randomNumGenerator(quotes.length)];
            System.out.println("..::>> Quote From Computer <<::.. \n Author : " + randomQuote.getAuthor() + "  Quote : " + randomQuote.getText());

        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
            throw exception;
        }
    }

    public int randomNumGenerator(int upperLimit) {
        return (int) Math.ceil(Math.random() * upperLimit);
    }
}
