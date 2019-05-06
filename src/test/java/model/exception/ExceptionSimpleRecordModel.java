package model.exception;

import com.google.gson.annotations.SerializedName;
import model.enums.RecordType;

public class ExceptionSimpleRecordModel extends ExceptionModel {

    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private RecordType type;

    @SerializedName("editable")
    private boolean editable;

    @SerializedName("url")
    private String url;

    @SerializedName("note")
    private String note;

    @SerializedName("creatorName")
    private String creatorName;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("mimeType")
    private String mimeType;

    @SerializedName("sapMimeType")
    private String sapMimeType;

    @SerializedName("messages")
    private String[] messages;

    @SerializedName("attributes")
    private String[] attributes;

    @SerializedName("tables")
    private String[] tables;

    public ExceptionSimpleRecordModel withCode(int code) {
        this.code = code;
        return this;
    }

    public ExceptionSimpleRecordModel withDescription(String description) {
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

    public RecordType getType() {
        return type;
    }

    public boolean isEditable() {
        return editable;
    }

    public String getUrl() {
        return url;
    }

    public String getNote() {
        return note;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public String getName() {
        return name;
    }

    public String getMimeType() {
        return mimeType;
    }

    public String getSapMimeType() {
        return sapMimeType;
    }

    public String[] getMessages() {
        return messages;
    }

    public String[] getAttributes() {
        return attributes;
    }

    public String[] getTables() {
        return tables;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExceptionSimpleRecordModel regularSimpleRecordModel = (ExceptionSimpleRecordModel) o;

        if (code != regularSimpleRecordModel.code) return false;
        if ((id==null||id.equals(""))&(regularSimpleRecordModel.id==null||regularSimpleRecordModel.id.equals(""))) return false;
        if ((type==null)&(regularSimpleRecordModel.type==null)) return false;
        return (messages==null&regularSimpleRecordModel.messages==null);
    }

    @Override
    public String toString() {
        return "SimpleRecord{" +
                "testCase=" + getTestCase() + '\'' +
                "code=" + code + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", editable='" + editable + '\'' +
                ", message='" + messages + '\'' +
                '}';
    }
}
