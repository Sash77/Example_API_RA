package model.exception;

import com.google.gson.annotations.SerializedName;
import model.enums.EntityType;
import model.helpers.HelperAttribute;

public class ExceptionRawEntityModel extends ExceptionModel {

    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private EntityType type;

    @SerializedName("description")
    private String description;

    @SerializedName("messages")
    private String[] messages;

    @SerializedName("records")
    private String records;

    @SerializedName("actions")
    private HelperAttribute[] actions;

    @SerializedName("subDocuments")
    private String subDocuments;

    public ExceptionRawEntityModel withCode(int code) {
        this.code = code;
        return this;
    }

    public ExceptionRawEntityModel withDescription(String description) {
        this.description = description;
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getMessage() {
        return message;
    }

    public String getTestCase() {
        return testCase;
    }

    public String getId() {
        return id;
    }

    public EntityType getType() {
        return type;
    }

    public String[] getMessages() {
        return messages;
    }

    public String getRecords() {
        return records;
    }

    public HelperAttribute[] getActions() {
        return actions;
    }

    public String getSubDocuments() {
        return subDocuments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExceptionRawEntityModel regularRawEntityModel = (ExceptionRawEntityModel) o;

        if (code != regularRawEntityModel.code) return false;
        if ((id==null||id.equals(""))&(regularRawEntityModel.id==null||regularRawEntityModel.id.equals(""))) return false;
        if ((type==null)&(regularRawEntityModel.type==null)) return false;
        return (messages==null&regularRawEntityModel.messages==null);
    }

    @Override
    public String toString() {
        return "RawEntity{" +
                "testCase=" + getTestCase() + '\'' +
                "code=" + code + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", message='" + messages + '\'' +
                '}';
    }
}
