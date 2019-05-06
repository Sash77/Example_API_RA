package model.exception;

import com.google.gson.annotations.SerializedName;
import model.helpers.HelperWorkListFilter;

public class ExceptionNodeModel extends ExceptionModel {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("control")
    private String control;

    @SerializedName("documentType")
    private String documentType;

    @SerializedName("active")
    private boolean active;

    @SerializedName("documentCounter")
    private int documentCounter;

    @SerializedName("topNode")
    private boolean topNode;

    @SerializedName("leaf")
    private boolean leaf;

    @SerializedName("children")
    private String[] children;

    @SerializedName("hierarchyLevel")
    private int hierarchyLevel;

    @SerializedName("filters")
    private HelperWorkListFilter[] filters;

    @SerializedName("additionalUrl")
    private String addressUrl;


    public ExceptionNodeModel withCode(int code) {
        this.code = code;
        return this;
    }

    public ExceptionNodeModel withDescription(String description) {
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

    public String getName() {
        return name;
    }

    public String getControl() {
        return control;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getAdditionalUrl() {
        return addressUrl;
    }

    public boolean isActive() {
        return active;
    }

    public int getDocumentCounter() {
        return documentCounter;
    }

    public boolean isTopNode() {
        return topNode;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public String[] getChildren() {
        return children;
    }

    public int getHierarchyLevel() {
        return hierarchyLevel;
    }

    public HelperWorkListFilter[] getFilters() {
        return filters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExceptionNodeModel regularNodeModel = (ExceptionNodeModel) o;

        if (code != regularNodeModel.code) return false;
        if ((id==null||id.equals(""))&(regularNodeModel.id==null||regularNodeModel.id.equals(""))) return false;
        if ((name==null||name.equals(""))&(regularNodeModel.name==null||regularNodeModel.name.equals(""))) return false;
        if ((documentType==null||documentType.equals(""))&(regularNodeModel.documentType==null||regularNodeModel.documentType.equals(""))) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Node{" +
                "testCase=" + getTestCase() + '\'' +
                "code=" + code + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", documentType='" + documentType + '\'' +
                '}';
    }
}
