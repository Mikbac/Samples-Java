package pl.samples.Gson.Serialization.Model;

/**
 * Created by MikBac on 15.06.2021
 */
public class FeatureModel {

    private String key;

    private String value;

    public FeatureModel(final String key, final String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}
