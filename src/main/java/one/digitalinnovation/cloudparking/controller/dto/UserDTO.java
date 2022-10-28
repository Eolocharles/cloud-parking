package one.digitalinnovation.cloudparking.controller.dto;

import one.digitalinnovation.cloudparking.model.Role;
import one.digitalinnovation.cloudparking.model.User;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID id;
    @NotBlank(message = "Campo requerido")
    private String name;
    @Email(message = "Email inválido")
    private String email;

    Set<RoleDTO> roles = new HashSet<>();

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
        entity.getRoles().forEach(role -> {
            this.roles.add(new RoleDTO(role));
        });


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

    public Set<RoleDTO> getRoles() {
        return roles;
    }
}