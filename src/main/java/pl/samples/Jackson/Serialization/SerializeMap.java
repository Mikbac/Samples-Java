package pl.samples.Jackson.Serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import pl.samples.Jackson.Serialization.Model.FeatureModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MikBac on 15.06.2021
 */

@Log4j2
public class SerializeMap {

    public static void main(String[] args) {
        Map<String, FeatureModel> featureModelMap = new HashMap<>();

        featureModelMap.put("Key-1", new FeatureModel("aaa", "111"));
        featureModelMap.put("Key-2", new FeatureModel("bbb", "222"));
        featureModelMap.put("Key-3", new FeatureModel("ccc", "333"));

        ObjectMapper mapper = new ObjectMapper();

        String json = null;
        try {
            json = mapper.writeValueAsString(featureModelMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // Error while parasing Map<String, FeatureModel> to JSON
        }

        log.info(json);
        // {"Key-1":{"key":"aaa","value":"111"},"Key-2":{"key":"bbb","value":"222"},"Key-3":{"key":"ccc","value":"333"}}

    }

}
