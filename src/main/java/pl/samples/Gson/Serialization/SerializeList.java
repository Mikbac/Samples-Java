package pl.samples.Gson.Serialization;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import pl.samples.Gson.Serialization.Model.FeatureModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MikBac on 15.06.2021
 */

@Log4j2
public class SerializeList {

    public static void main(String[] args) {
        serializeFeatureModelList();

        serializeStringList();
    }

    private static void serializeFeatureModelList() {
        List<FeatureModel> featureModelList = new ArrayList<>();

        featureModelList.add(new FeatureModel("aaa", "111"));
        featureModelList.add(new FeatureModel("bbb", "222"));
        featureModelList.add(new FeatureModel("ccc", "333"));

        String json = new Gson().toJson(featureModelList);

        log.info(json);
        // [{"key":"aaa","value":"111"},{"key":"bbb","value":"222"},{"key":"ccc","value":"333"}]
    }

    private static void serializeStringList() {
        List<String> wordsList = new ArrayList<>();

        wordsList.add("aaa");
        wordsList.add("bbb");
        wordsList.add("ccc");

        String json = new Gson().toJson(wordsList);

        log.info(json);
        // ["aaa","bbb","ccc"]
    }

}
