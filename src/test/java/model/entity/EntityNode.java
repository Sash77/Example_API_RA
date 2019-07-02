package model.entity;

import com.google.gson.annotations.SerializedName;

public class EntityNode {

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
    private EntityNode[] children;

    @SerializedName("hierarchyLevel")
    private int hierarchyLevel;

    @SerializedName("filters")
    private EntityWorkListFilter[] filters;

    @SerializedName("errorMessage")
    private String errorMessage;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getControl() {
        return control;
    }

    public String getDocumentType() {
        return documentType;
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

    public EntityNode[] getChildren() {
        return children;
    }

    public int getHierarchyLevel() {
        return hierarchyLevel;
    }

    public EntityWorkListFilter[] getFilters() {
        return filters;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
