package model.helpers;

import com.google.gson.annotations.SerializedName;
import model.enums.OperatorType;

public class HelperWorkListFilter {

    @SerializedName("workListId")
    private String workListId;

    @SerializedName("fieldId")
    private String fieldId;

    @SerializedName("fieldName")
    private String fieldName;

    @SerializedName("fieldDescription")
    private String fieldDescription;

    @SerializedName("lowValue")
    private String lowValue;

    @SerializedName("highValue")
    private String highValue;

    @SerializedName("operator")
    private OperatorType operator;

    public String getWorkListId() {
        return workListId;
    }

    public String getFieldId() {
        return fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public String getLowValue() {
        return lowValue;
    }

    public String getHighValue() {
        return highValue;
    }

    public OperatorType getOperator() {
        return operator;
    }
}
