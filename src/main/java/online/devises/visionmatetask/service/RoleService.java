package online.devises.visionmatetask.service;

import online.devises.visionmatetask.model.Role;
import online.devises.visionmatetask.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Iterable<Role> getRoles() {
        return roleRepository.findAll();
    }

    public void createRole(Role role) {
        roleRepository.save(role);
    }

    public void deleteRole(Integer roleId) {
        roleRepository.deleteById(roleId);
    }

    public void updateRole(Integer roleId, Role role) {
        roleRepository.findById(roleId)
                .map(oldRole -> {
                    oldRole.setRoleName(role.getRoleName());
                    oldRole.setPermissions(role.getPermissionsList());
                    return roleRepository.save(oldRole);
                })
                .orElseGet(() -> {
                    role.setId(roleId);
                    return roleRepository.save(role);
                });
    }
}
