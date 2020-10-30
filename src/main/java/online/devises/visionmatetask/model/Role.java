package online.devises.visionmatetask.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@JsonDeserialize
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String roleName;
    @ElementCollection(targetClass=Permission.class)
    private List<Permission> permissions;

    public Role(){
    }

    public Role(String roleName) {
        this.roleName = roleName;
        this.permissions = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void addPermission(Permission permission){
        this.permissions.add(permission);
    }

    public void removePermission(Permission permission){
        this.permissions.remove(permission);
    }

    public List<Permission> getPermissionsList(){
        return this.permissions;
    }

    public void setPermissions(List<Permission> permissionsList) {
        this.permissions = permissionsList;
    }
}
