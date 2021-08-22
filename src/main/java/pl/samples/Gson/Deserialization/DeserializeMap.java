package pl.samples.Gson.Deserialization;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import pl.samples.Gson.Deserialization.Model.FeatureModel;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by MikBac on 15.06.2021
 */

@Log4j2
public class DeserializeMap {

    public static void main(String[] args) {
        deserializeFeatureModelMap();
    }

    private static void deserializeFeatureModelMap() {
        String json = "{\"Key-1\":{\"key\":\"aaa\",\"value\":\"111\"},\"Key-2\":{\"key\":\"bbb\",\"value\":\"222\"},\"Key-3\":{\"key\":\"ccc\",\"value\":\"333\"}}";

        Type listType = new TypeToken<Map<String, FeatureModel>>() {
        }.getType();

        Map<String, FeatureModel> featureModelMap = new Gson().fromJson(json, listType);

        featureModelMap.forEach((key, value) -> log.info("{} -key-> {} -value-> {}", key, value.getKey(), value.getValue()));
    }

}
