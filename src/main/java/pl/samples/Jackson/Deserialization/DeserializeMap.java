package pl.samples.Jackson.Deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.samples.Jackson.Deserialization.Model.FeatureModel;

import java.util.Map;

/**
 * Created by MikBac on 15.06.2021
 */

public class DeserializeMap {

    public static void main(String[] args) {
        deserializeFeatureModelMap();
    }

    private static void deserializeFeatureModelMap() {
        ObjectMapper mapper = new ObjectMapper();

        String json = "{\"Key-1\":{\"key\":\"aaa\",\"value\":\"111\"},\"Key-2\":{\"key\":\"bbb\",\"value\":\"222\"},\"Key-3\":{\"key\":\"ccc\",\"value\":\"333\"}}";

        Map<String, FeatureModel> featureModelMap = null;
        try {
            featureModelMap = mapper.readValue(json, new TypeReference<Map<String, FeatureModel>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // Error while deserialization JSON to Map<String, FeatureModel>
        }

        featureModelMap.forEach((key, value) -> System.out.println(key + " -key-> " + value.getKey() + " -value-> " + value.getValue()));
    }

}
