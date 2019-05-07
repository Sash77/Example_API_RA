package model.entity;

import com.google.gson.annotations.SerializedName;

public class EntityOverviewRequest {
    @SerializedName("documentType")
    private String documentType;

    @SerializedName("control")
    private String control;

    @SerializedName("size")
    private int size;

    @SerializedName("page")
    private int page;
}
