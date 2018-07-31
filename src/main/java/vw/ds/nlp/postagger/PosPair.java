package vw.ds.nlp.postagger;


public class PosPair {
    private String word;
    private String pos;

    public PosPair(String word, String pos) {
        this.word = word;
        this.pos = pos;
    }

    public String getWord() {
        return word;
    }

    public String getPos() {
        return pos;
    }

    @Override
    public String toString() {
        // toString as json format
        return String.format("[\"%s\", \"%s\"]", word, pos);
    }
}
