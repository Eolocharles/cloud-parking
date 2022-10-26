package one.digitalinnovation.cloudparking.controller.dto;

import one.digitalinnovation.cloudparking.model.User;

import java.io.Serializable;
import java.util.UUID;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID id;
    private String name;
    private String email;

    public UserDTO() {
    }

    public UserDTO(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}