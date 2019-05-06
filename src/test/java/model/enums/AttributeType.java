package model.enums;

import com.google.gson.annotations.SerializedName;

public enum AttributeType {
    @SerializedName("ATTRIBUTE")
    ATTRIBUTE,
    @SerializedName("FIELD")
    FIELD,
    @SerializedName("ICON")
    ICON,
    @SerializedName("REFERENCE")
    REFERENCE,
    @SerializedName("SELECTION_FIELD")
    SELECTION_FIELD,
    @SerializedName("ACTION ")
    ACTION
}
