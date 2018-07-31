package vw.ds.nlp.postagger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.List;

public class LambdaRequestHandler implements RequestHandler<String, List<PosPair>> {
    private final PosTaggerService posTaggerService;
    public LambdaRequestHandler() {
        posTaggerService = new PosTaggerService();
    }

    public List<PosPair> handleRequest(String input, Context context) {
        context.getLogger().log("Input: " + input);
        return posTaggerService.tagPos(input);
    }
}
