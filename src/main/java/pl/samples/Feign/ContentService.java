package pl.samples.Feign;

import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * Created by MikBac on 30.08.2021
 */

public interface ContentService {

    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    List<UserModel> contributors(@Param("owner") String owner, @Param("repo") String repository);

}
