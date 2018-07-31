package vw.ds.nlp.postagger;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;

import java.util.List;
import java.util.stream.Collectors;

public class PosTaggerService {
    private final Komoran komoran;

    public PosTaggerService() {
        komoran = new Komoran(DEFAULT_MODEL.FULL);
//        komoran.setFWDic("user_data/fwd.user");
//        komoran.setUserDic("user_data/dic.user");
    }

    public List<PosPair> tagPos(String text) {
        KomoranResult result = komoran.analyze(text);
        return result.getList().stream()
                .map(pair -> new PosPair(pair.getFirst(), pair.getSecond()))
                .collect(Collectors.toList());
    }
}
