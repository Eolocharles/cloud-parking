package one.digitalinnovation.cloudparking.model;

import one.digitalinnovation.cloudparking.enums.RoleName;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_role")
public class Role  implements GrantedAuthority, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID roleId;

    private String roleName;

    public Role() {
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role role)) return false;
        return Objects.equals(roleId, role.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId);
    }

    @Override
    public String getAuthority() {
        return this.roleName;
    }
}
