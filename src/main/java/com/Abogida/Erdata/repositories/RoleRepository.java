package com.Abogida.Erdata.repositories;
import org.springframework.data.repository.CrudRepository;
import com.Abogida.Erdata.security.Role;

public interface RoleRepository  extends CrudRepository<Role,Long>{
	Role findByRole(String role);
}
