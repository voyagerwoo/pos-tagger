package vw.ds.nlp.postagger;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class PosTaggerServiceTest {

    private PosTaggerService posTaggerService = new PosTaggerService();

    @Test
    public void testTagPos() {
        List<PosPair> posPairs = posTaggerService.tagPos("마른 땅을 달리다.");
        System.out.println(posPairs);
        assertThat(posPairs.size(), greaterThan(0));
    }
}
