package pl.samples.Gson.Deserialization;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import pl.samples.Gson.Deserialization.Model.FeatureModel;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by MikBac on 15.06.2021
 */

public class DeserializeMap {

    public static void main(String[] args) {
        deserializeFeatureModelMap();
    }

    private static void deserializeFeatureModelMap() {
        String json = "{\"Key-1\":{\"key\":\"aaa\",\"value\":\"111\"},\"Key-2\":{\"key\":\"bbb\",\"value\":\"222\"},\"Key-3\":{\"key\":\"ccc\",\"value\":\"333\"}}";

        Type listType = new TypeToken<Map<String, FeatureModel>>() {
        }.getType();

        Map<String, FeatureModel> featureModelMap = new Gson().fromJson(json, listType);

        featureModelMap.forEach((key, value) -> System.out.println(key + " -key-> " + value.getKey() + " -value-> " + value.getValue()));
    }

}
