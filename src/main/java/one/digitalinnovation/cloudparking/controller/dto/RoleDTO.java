package one.digitalinnovation.cloudparking.controller.dto;

import one.digitalinnovation.cloudparking.model.Role;

import java.io.Serializable;
import java.util.UUID;

public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID id;
    private String authority;

    public RoleDTO() {
    }

    public RoleDTO(UUID id, String roleName) {
        this.id = id;
        this.authority = roleName;
    }

    public RoleDTO(Role entity) {
        id = entity.getRoleId();
        authority = entity.getAuthority();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRoleName() {
        return authority;
    }

    public void setRoleName(String roleName) {
        this.authority = authority;
    }
}
