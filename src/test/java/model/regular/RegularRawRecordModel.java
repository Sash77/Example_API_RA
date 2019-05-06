package model.regular;

import com.google.gson.annotations.SerializedName;
import model.enums.MessageType;
import model.enums.RecordType;
import model.helpers.HelperAttribute;
import model.helpers.HelperMessage;

public class RegularRawRecordModel extends RegularModel {

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
    private HelperMessage[] messages;

    @SerializedName("attributes")
    private HelperAttribute[] attributes;

    @SerializedName("tables")
    private RegularRawEntityModel[] tables;

    private MessageType messageResult = MessageType.SUCCESS;

    public RegularRawRecordModel withCode(int code) {
        this.code = code;
        return this;
    }

    public RegularRawRecordModel withDescription(String description) {
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

    public HelperMessage[] getMessages() {
        return messages;
    }

    public HelperAttribute[] getAttributes() {
        return attributes;
    }

    public RegularRawEntityModel[] getTables() {
        return tables;
    }

    @Override
    public void processResponce(){

        if (messages!=null){
            for (HelperMessage item:messages) {
                if (item.getType()!= MessageType.SUCCESS){
                    messageResult = item.getType();
                    break;
                }
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegularRawRecordModel regularRawRecordModel = (RegularRawRecordModel) o;

        if (code != regularRawRecordModel.code) return false;
        if ((id==null||id.equals(""))&(regularRawRecordModel.id==null||regularRawRecordModel.id.equals(""))) return false;
        if ((type==null)&(regularRawRecordModel.type==null)) return false;
        return messageResult==regularRawRecordModel.messageResult;
    }

    @Override
    public String toString() {
        return "RawRecord{" +
                "testCase=" + getTestCase() + '\'' +
                "code=" + code + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", message='" + messages + '\'' +
                '}';
    }
}
