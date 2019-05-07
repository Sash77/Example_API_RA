package model.entity;

import com.google.gson.annotations.SerializedName;
import model.enums.MessageType;

public class EntityMessage {

    @SerializedName("id")
   private String id;

    @SerializedName("type")
    private MessageType type;

    @SerializedName("sapClass")
    private String sapClass;

    @SerializedName("number")
    private String number;

    @SerializedName("text")
    private String text;

    public String getId() {
        return id;
    }

    public MessageType getType() {
        return type;
    }

    public String getSapClass() {
        return sapClass;
    }

    public String getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }
}
