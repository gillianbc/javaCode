package lambdas;

public class Article {
	/*
	 * Articles can have a comma separated list of tags - it's just a String
	 */
	String description;
    String tags;
    int wordlength;

    public Article(String description, String tags, int wordlength) {
        this.description = description;
        this.tags = tags;
        this.wordlength = wordlength;
    }

    @Override
    public String toString() {

        return "=== " + description + " ====\n" 
        		+ tags + " [" + wordlength +"]" ;
    }

    public String getDescription() {
        return description;
    }

    public String getTags() {
        return tags;
    }

    public int getWordlength() {
        return wordlength;
    }
}
