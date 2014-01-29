package com.youreffect.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

/**
 * @author Deeban Ramalingam
 * User POJO
 */
@Document(collection = "users")
public class User {

    /** unique user id for database indexing */
    @Id
    private String userId;
    /** user's username */
    private String username;
    /** user's email */
    private String email;
    /** user's hashed password */
    private String password;
    /** user's state */
    private String state;
    /** user's item map */
    private HashMap<String, Item> items;

    /**
     * get user id
     * @return user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * set user id
     * @param userId set user id to this
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * get user username
     * @return user username
     */
    public String getUsername() {
        return username;
    }

    /**
     * set user username
     * @param username set username to this
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get user email
     * @return user email
     */
    public String getEmail() {
        return email;
    }

    /**
     * set user email
     * @param email set user email to this
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get user state
     * @return user state
     */
    public String getState() {
        return state;
    }

    /**
     * set user state
     * @param state set user state to this
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * get user password
     * @return user password
     */
    public String getPassword() {
        return password;
    }

    /**
     * set user password
     * @param password set password to this
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * string representation of User
     * @return string representation of User
     */
    public String toString() {
        return String.format(
                "User[id=%s, username='%s', email='%s', state='%s', password='%s']",
                userId, username, email, state, password);
    }

    /**
     * get user items
     * @return user items
     */
    public HashMap getItems() {
        return items;
    }

    /**
     * set user items
     * @param items set user items to this
     */
    public void setItems(HashMap items) {
        this.items = items;
    }

    /**
     * add item to items map
     * @param item to add to items map
     */
    public void addItem(Item item) {
        if (items.containsKey(item.getItemId())) {
            items.get(item.getItemId()).addToQuantity(item.getQuantity());
        }
        else {
            items.put(item.getItemId(), item);
        }
    }

    /**
     * remove item from items map
     * @param item to remove from items map
     */
    public void rmvItem(Item item) {
        items.remove(item.getItemId());
    }
}
