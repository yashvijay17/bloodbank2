package com.example.srishti.myapplication;

/**
 * Represents an item in a ToDo list
 */
public class ToDoItem {

    /**
     * Item text
     */
    @com.google.gson.annotations.SerializedName("name")
    private String name;

    /**
     * Item Id
     */
    @com.google.gson.annotations.SerializedName("hospital_id")
    private String hospital_id;

    /**
     * Indicates if the item is completed
     */
    @com.google.gson.annotations.SerializedName("address")
    private String address;

    /**
     * ToDoItem constructor
     */
    public ToDoItem() {

    }

    @Override
    public String toString() {
        return getText();
    }

    /**
     * Initializes a new ToDoItem
     *
     * @param name
     *            The item text
     * @param hospital_id
     *            The item id
     *            @param address
     */
    public ToDoItem(String name, String address,String hospital_id) {
        this.setText(name);
        this.setComplete(address);
        this.setId(hospital_id);
    }

    /**
     * Returns the item text
     */
    public String getText() {
        return name;
    }

    /**
     * Sets the item text
     *
     * @param text
     *            text to set
     */
    public final void setText(String text) {
        name = text;
    }

    /**
     * Returns the item id
     */
    public String getId() {
        return hospital_id;
    }

    /**
     * Sets the item id
     *
     * @param id
     *            id to set
     */
    public final void setId(String id) {
        hospital_id = id;
    }

    /**
     * Indicates if the item is marked as completed
     */
    public String Complete() {
        return address;
    }

    /**
     * Marks the item as completed or incompleted
     */
    public void setComplete(String complete) {
        address = complete;
    }

}