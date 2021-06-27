package com.systemc.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Product {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("price")
    private double price;
    @JsonProperty("itemCount")
    private int itemCount;
    @JsonProperty("isActive")
    private boolean isActive;
    @JsonProperty("createdDateTime")
    private String createdDateTime;
    @JsonProperty("modifiedDateTime")
    private String modifiedDateTime;

    @JsonProperty("id")
    public String getId() { return id; }
    @JsonProperty("id")
    public void setId(String id) { this.id = id; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String name) { this.name = name; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String description) { this.description = description; }

    @JsonProperty("price")
    public double getPrice() { return price; }
    @JsonProperty("price")
    public void setPrice(double price) { this.price = price; }

    @JsonProperty("itemCount")
    public int getItemCount() { return itemCount; }
    @JsonProperty("itemCount")
    public void setItemCount(int itemCount) { this.itemCount = itemCount; }

    @JsonProperty("isActive")
    public boolean isActive() { return isActive; }
    @JsonProperty("isActive")
    public void setIsActive(boolean isActive) { this.isActive = isActive; }

    @JsonProperty("createdDateTime")
    public String getCreatedDateTime() { return createdDateTime; }
    @JsonProperty("createdDateTime")
    public void setCreatedDateTime(String createdDateTime) { this.createdDateTime = createdDateTime; }

    @JsonProperty("modifiedDateTime")
    public String getModifiedDateTime() { return modifiedDateTime; }
    @JsonProperty("modifiedDateTime")
    public void setModifiedDateTime(String modifiedDateTime) { this.modifiedDateTime = modifiedDateTime; }
}
