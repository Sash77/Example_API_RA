package model.helpers;

import com.google.gson.annotations.SerializedName;

public class HelperOverviewRequest {
    @SerializedName("documentType")
    private String documentType;

    @SerializedName("control")
    private String control;

    @SerializedName("size")
    private int size;

    @SerializedName("page")
    private int page;
}
