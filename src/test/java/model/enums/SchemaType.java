package model.enums;

import com.google.gson.annotations.SerializedName;

public enum SchemaType {
    @SerializedName("SCHEMA")
    SCHEMA,
    @SerializedName("OVERVIEW")
    OVERVIEW,
    @SerializedName("DETAIL")
    DETAIL,
    @SerializedName("MODAL")
    MODAL,
    @SerializedName("MODAL_CONTAINER")
    MODAL_CONTAINER
}
