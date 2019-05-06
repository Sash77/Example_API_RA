package model.helpers;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import model.enums.AttributeType;
import model.enums.ReferenceType;
import model.enums.ValueType;

import java.util.HashMap;

public class HelperAttribute {

    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private AttributeType type;

    @SerializedName("name")
    private String name;

    @SerializedName("value")
    private String value;

    @SerializedName("codeText")
    private String description;

    @SerializedName("icon")
    private String icon;

    @SerializedName("fieldLength")
    private int fieldLength;

    @SerializedName("placeholder")
    private int placeholder;

    @SerializedName("editable")
    private boolean editable;

    @SerializedName("mandatory")
    private boolean mandatory;

    @SerializedName("decimalPlaces")
    private int decimalPlaces;

    @SerializedName("searchAvailable")
    private boolean searchAvailable;

    @SerializedName("valueType")
    private ValueType valueType;

    @SerializedName("references")
    private String[] references;

    @SerializedName("valueRange")
    private ValueType valueRange;

    @SerializedName("iconCode")
    private String iconCode;

    @SerializedName("referenceType")
    private ReferenceType referenceType;

    @SerializedName("possibleValues")
    private HashMap<String,String> possibleValues;

    @SerializedName("multiSelection")
    private boolean multiSelection;

    @SerializedName("displayValue")
    private  String displayValue;

    public String getId() {
        return id;
    }

    public AttributeType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public int getFieldLength() {
        return fieldLength;
    }

    public int getPlaceholder() {
        return placeholder;
    }

    public boolean isEditable() {
        return editable;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public int getDecimalPlaces() {
        return decimalPlaces;
    }

    public boolean isSearchAvailable() {
        return searchAvailable;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public String[] getReferences() {
        return references;
    }

    public ValueType getValueRange() {
        return valueRange;
    }

    public String getIconCode() {
        return iconCode;
    }

    public ReferenceType getReferenceType() {
        return referenceType;
    }

    public HashMap<String, String> getPossibleValues() {
        return possibleValues;
    }

    public boolean isMultiSelection() {
        return multiSelection;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
