package model.entity;

import com.google.gson.annotations.SerializedName;
import model.enums.OperatorType;

public class EntityValueRange {
    @SerializedName("low")
    private double low;

    @SerializedName("high")
    private double high;

    @SerializedName("operator")
    private OperatorType operator;

    @SerializedName("include")
    private boolean include;

    public double getLow() {
        return low;
    }

    public double getHigh() {
        return high;
    }

    public boolean isInclude() {
        return include;
    }

    public OperatorType getOperator() {
        return operator;
    }
}
