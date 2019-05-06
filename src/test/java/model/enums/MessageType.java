package model.enums;

import com.google.gson.annotations.SerializedName;

public enum MessageType {
    @SerializedName("SUCCESS")
    SUCCESS,
    @SerializedName("ERROR")
    ERROR,
    @SerializedName("INFO")
    INFO,
    @SerializedName("WARNING")
    WARNING
}
