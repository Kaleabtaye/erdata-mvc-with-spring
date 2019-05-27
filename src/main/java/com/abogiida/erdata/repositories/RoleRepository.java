package com.abogiida.erdata.repositories;
import org.springframework.data.repository.CrudRepository;

import com.abogiida.erdata.security.Role;

public interface RoleRepository  extends CrudRepository<Role,Long>{
	Role findByRole(String role);
}
