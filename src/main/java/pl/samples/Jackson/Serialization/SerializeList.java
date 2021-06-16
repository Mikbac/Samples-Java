package pl.samples.Jackson.Serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.samples.Jackson.Serialization.Model.FeatureModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MikBac on 15.06.2021
 */

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

        ObjectMapper mapper = new ObjectMapper();

        String json = null;
        try {
            json = mapper.writeValueAsString(featureModelList);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // Error while parasing List<FeatureModel> to JSON
        }

        System.out.println(json);
        // [{"key":"aaa","value":"111"},{"key":"bbb","value":"222"},{"key":"ccc","value":"333"}]
    }

    private static void serializeStringList() {
        List<String> wordsList = new ArrayList<>();

        wordsList.add("aaa");
        wordsList.add("bbb");
        wordsList.add("ccc");

        ObjectMapper mapper = new ObjectMapper();

        String json = null;
        try {
            json = mapper.writeValueAsString(wordsList);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // Error while parasing List<String> to JSON
        }

        System.out.println(json);
        // ["aaa","bbb","ccc"]
    }

}
