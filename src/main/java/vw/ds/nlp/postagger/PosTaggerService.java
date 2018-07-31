package vw.ds.nlp.postagger;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PosTaggerService {
    private static final String USER_DIC = "dic.user";
    private static final String USER_DIC_TMP_PATH = "/tmp/" + USER_DIC;

    private static final String USER_FWD = "fwd.user";
    private static final String USER_FWD_TMP_PATH = "/tmp/" + USER_FWD;


    private final Komoran komoran;

    public PosTaggerService() {
        copyUserDicFiles();
        komoran = new Komoran(DEFAULT_MODEL.FULL);
        komoran.setUserDic(USER_DIC_TMP_PATH);
        komoran.setFWDic(USER_FWD_TMP_PATH);
    }

    public List<PosPair> tagPos(String text) {
        KomoranResult result = komoran.analyze(text);
        return result.getList().stream()
                .map(pair -> new PosPair(pair.getFirst(), pair.getSecond()))
                .collect(Collectors.toList());
    }

    private void copyUserDicFiles() {
        try {
            ClassPathResource dicUserPath = new ClassPathResource(USER_DIC);
            ClassPathResource fwdUserPath = new ClassPathResource(USER_FWD);
            Files.delete(Paths.get(USER_DIC_TMP_PATH));
            Files.delete(Paths.get(USER_FWD_TMP_PATH));
            Files.copy(dicUserPath.getInputStream(), Paths.get(USER_DIC_TMP_PATH));
            Files.copy(fwdUserPath.getInputStream(), Paths.get(USER_FWD_TMP_PATH));
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid user dic files.");
        }
    }
}
