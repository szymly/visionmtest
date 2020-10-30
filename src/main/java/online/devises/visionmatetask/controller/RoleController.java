package online.devises.visionmatetask.controller;

import online.devises.visionmatetask.model.Role;
import online.devises.visionmatetask.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    @ResponseBody
    public Iterable<Role> getAllRoles() {
        return roleService.getRoles();
    }

    @PostMapping("/roles")
    @ResponseBody
    public void createRole(@RequestBody Role role)
    {
        roleService.createRole(role);
    }

    @DeleteMapping("/roles/{roleId}")
    @ResponseBody
    public void deleteRole(@PathVariable Integer roleId)
    {
        roleService.deleteRole(roleId);
    }

    @PutMapping("/roles/{roleId}")
    @ResponseBody
    public void updateRole(@PathVariable Integer roleId, @RequestBody Role role)
    {
        roleService.updateRole(roleId, role);
    }

}
