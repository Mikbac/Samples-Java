package pl.samples.Gson.Serialization;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import pl.samples.Gson.Serialization.Model.FeatureModel;

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

        String json = new Gson().toJson(featureModelMap);

        log.info(json);
        // {"Key-1":{"key":"aaa","value":"111"},"Key-2":{"key":"bbb","value":"222"},"Key-3":{"key":"ccc","value":"333"}}

    }

}
