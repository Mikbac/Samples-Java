package pl.samples.Feign;

import feign.Feign;
import feign.gson.GsonDecoder;
import lombok.extern.log4j.Log4j2;

import java.util.List;

/**
 * Created by MikBac on 30.08.2021
 */

@Log4j2
public class Main {

    private static final String ORGANIZATION = "microsoft";
    private static final String REPOSITORY = "TypeScript";

    public static void main(String[] args) {
        ContentService contentService = Feign.builder()
                .decoder(new GsonDecoder())
                .target(ContentService.class, "https://api.github.com");

        /*
         * Uri -> https://api.github.com/repos/{Organization}/{Repository}/contributors
         */
        List<UserModel> contributorList = contentService.contributors(ORGANIZATION, REPOSITORY);

        contributorList.forEach(c -> log.info("{} - {}", c.getLogin(), c.getContributions()));
    }
}