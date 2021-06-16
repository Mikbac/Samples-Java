package pl.samples.Jackson.Deserialization.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by MikBac on 15.06.2021
 */
public class FeatureModel {

    @JsonProperty("key")
    private String key;

    @JsonProperty("value")
    private String value;

    /**
     * Required
     */
    public FeatureModel() {
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
