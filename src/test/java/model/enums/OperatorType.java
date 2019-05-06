package model.enums;

import com.google.gson.annotations.SerializedName;

public enum OperatorType {
    @SerializedName(value = "==",alternate = "EQUAL")
    EQUAL,
    @SerializedName(value = "!=", alternate = "NOT_EQUAL")
    NOT_EQUAL,
    @SerializedName(value = ">", alternate = "GREATER")
    GREATER,
    @SerializedName(value = ">=", alternate = "GREATER_OR_EQUAL")
    GREATER_OR_EQUAL,
    @SerializedName(value = "<", alternate = "LESSER")
    LESSER,
    @SerializedName(value = "<=", alternate = "LESSER_OR_EQUAL")
    LESSER_OR_EQUAL,
    @SerializedName(value = "<>", alternate = "BETWEEN")
    BETWEEN,
}
