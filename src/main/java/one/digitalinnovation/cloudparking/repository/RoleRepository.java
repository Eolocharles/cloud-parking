package one.digitalinnovation.cloudparking.repository;

import one.digitalinnovation.cloudparking.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

}
