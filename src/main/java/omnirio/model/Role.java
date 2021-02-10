package omnirio.model;

import java.util.Objects;

public class Role {

    private String roleID;
    private String roleName;
    private String code;

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleID='" + roleID + '\'' +
                ", roleName='" + roleName + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(roleID, role.roleID) &&
                Objects.equals(roleName, role.roleName) &&
                Objects.equals(code, role.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roleID, roleName, code);
    }
}
