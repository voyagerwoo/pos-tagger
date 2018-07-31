package vw.ds.nlp.postagger;

public class PosTaggerCli {
    public static void main(String[] args) {
        final PosTaggerService posTaggerService = new PosTaggerService();

        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Required args.");
        }

        for (String arg : args) {
            System.out.println(posTaggerService.tagPos(arg));
        }
    }
}
