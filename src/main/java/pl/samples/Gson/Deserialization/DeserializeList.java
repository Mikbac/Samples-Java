package pl.samples.Gson.Deserialization;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import pl.samples.Gson.Deserialization.Model.FeatureModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MikBac on 15.06.2021
 */

public class DeserializeList {

    public static void main(String[] args) {
        serializeFeatureModelList();

        serializeStringList();
    }

    private static void serializeFeatureModelList() {
        String json = "[{\"key\":\"aaa\",\"value\":\"111\"},{\"key\":\"bbb\",\"value\":\"222\"},{\"key\":\"ccc\",\"value\":\"333\"}]";

        Type listType = new TypeToken<ArrayList<FeatureModel>>() {
        }.getType();

        List<FeatureModel> featureModelList = new Gson().fromJson(json, listType);

        featureModelList.forEach(f -> System.out.println(f.getKey() + " <--> " + f.getValue()));
    }

    private static void serializeStringList() {
        String json = "[\"aaa\",\"bbb\",\"ccc\"]";

        Type listType = new TypeToken<ArrayList<String>>() {
        }.getType();

        List<String> wordsList = new Gson().fromJson(json, listType);

        wordsList.forEach(System.out::println);
    }

}
