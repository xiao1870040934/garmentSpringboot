package cn.ccsu.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/10 20:34
 * @Version 1.0
 */
public class RoleVo implements Serializable {
    private List allRolesList;
    private List assignRoles;

    public RoleVo() {
    }

    public RoleVo(List allRolesList, List assignRoles) {
        this.allRolesList = allRolesList;
        this.assignRoles = assignRoles;
    }

    public List getAllRolesList() {
        return allRolesList;
    }

    public void setAllRolesList(List allRolesList) {
        this.allRolesList = allRolesList;
    }

    public List getAssignRoles() {
        return assignRoles;
    }

    public void setAssignRoles(List assignRoles) {
        this.assignRoles = assignRoles;
    }
}
