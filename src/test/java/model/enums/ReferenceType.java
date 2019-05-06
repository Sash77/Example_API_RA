package model.enums;

import com.google.gson.annotations.SerializedName;

public enum ReferenceType {
    @SerializedName("NONE")
    NONE,
    @SerializedName("DOCUMENT")
    DOCUMENT,
    @SerializedName("DESCRIPTION")
    DESCRIPTION,
    @SerializedName("UNIT")
    UNIT,
    @SerializedName("CURRENCY ")
    CURRENCY
}
