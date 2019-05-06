package model.enums;

import com.google.gson.annotations.SerializedName;

public enum RecordType {

    @SerializedName("RECORD")
    RECORD,
    @SerializedName("TAB")
    TAB,
    @SerializedName("LINE")
    LINE,
    @SerializedName("ATTACHMENT")
    ATTACHMENT,
    @SerializedName("UPLOAD_DATA")
    UPLOAD_DATA,
    @SerializedName("NOTE")
    NOTE

}
