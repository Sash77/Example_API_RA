package model.enums;

import com.google.gson.annotations.SerializedName;

public enum ValueType {
    @SerializedName("DEFAULT")
    DEFAULT,
    @SerializedName("NUMBER")
    NUMBER,
    @SerializedName("NUMERIC")
    NUMERIC,
    @SerializedName("DATE")
    DATE,
    @SerializedName("TIME ")
    TIME
}
