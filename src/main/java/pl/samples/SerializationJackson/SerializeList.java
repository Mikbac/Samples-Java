package pl.samples.SerializationJackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MikBac on 15.06.2021
 */

public class SerializeList {

    public static void main(String[] args) {
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

}
