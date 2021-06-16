package pl.samples.Jackson.Deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.samples.Jackson.Deserialization.Model.FeatureModel;

import java.util.List;

/**
 * Created by MikBac on 15.06.2021
 */

public class DeserializeList {

    public static void main(String[] args) {
        deserializeFeatureModelList();

        deserializeStringList();
    }

    private static void deserializeFeatureModelList() {
        ObjectMapper mapper = new ObjectMapper();

        String json = "[{\"key\":\"aaa\",\"value\":\"111\"},{\"key\":\"bbb\",\"value\":\"222\"},{\"key\":\"ccc\",\"value\":\"333\"}]";

        List<FeatureModel> featureModelList = null;
        try {
            featureModelList = mapper.readValue(json, new TypeReference<List<FeatureModel>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // Error while deserialization JSON to List<FeatureModel>
        }

        featureModelList.forEach(f -> System.out.println(f.getKey() + " <--> " + f.getValue()));
    }

    private static void deserializeStringList() {
        ObjectMapper mapper = new ObjectMapper();

        String json = "[\"aaa\",\"bbb\",\"ccc\"]";

        List<String> wordsList = null;
        try {
            wordsList = mapper.readValue(json, new TypeReference<List<String>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // Error while deserialization JSON to List<String>
        }

        wordsList.forEach(System.out::println);
    }

}
