package quotes;

public class Quote {
    private String[] tags;
    private String author;
    private String likes;
    private String text;


    public Quote(String[] tags, String author, String likes, String text) {
        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }
    public String[] getTags() {
        return tags;
    }

    public String getAuthor() {
        return author;
    }

    public String getLikes() {
        return likes;
    }

    public String getText() {
        return text;
    }
}

