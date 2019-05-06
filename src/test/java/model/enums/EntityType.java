package model.enums;

import com.google.gson.annotations.SerializedName;

public enum EntityType {

    @SerializedName("ENTITY")
    ENTITY,
    @SerializedName("HEADER")
    HEADER,
    @SerializedName("TABLE")
    TABLE,
    @SerializedName("ATTACHMENT_LIST")
    ATTACHMENT_LIST,
    @SerializedName("NOTES")
    NOTES,
    @SerializedName("CONTAINER")
    CONTAINER

}
