package model.regular;

import com.google.gson.annotations.SerializedName;
import model.enums.EntityType;

public class RegularSimpleEntityModel extends RegularModel {

    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private EntityType type;

    @SerializedName("description")
    private String description;

    @SerializedName("messages")
    private String[] messages;

    @SerializedName("records")
    private String[] records;

    @SerializedName("actions")
    private String[] actions;

    @SerializedName("subDocuments")
    private String[] subDocuments;


    public RegularSimpleEntityModel withCode(int code) {
        this.code = code;
        return this;
    }

    public RegularSimpleEntityModel withDescription(String description) {
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

    public String[] getRecords() {
        return records;
    }

    public String[] getActions() {
        return actions;
    }

    public String[] getSubDocuments() {
        return subDocuments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegularSimpleEntityModel regularSimpleEntityModel = (RegularSimpleEntityModel) o;

        if (code != regularSimpleEntityModel.code) return false;
        if ((id==null||id.equals(""))&(regularSimpleEntityModel.id==null||regularSimpleEntityModel.id.equals(""))) return false;
        if ((type==null)&(regularSimpleEntityModel.type==null)) return false;
        return (messages==null&regularSimpleEntityModel.messages==null);
    }

    @Override
    public String toString() {
        return "SimpleEntity{" +
                "testCase=" + getTestCase() + '\'' +
                "code=" + code + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", message='" + messages + '\'' +
                '}';
    }
}
