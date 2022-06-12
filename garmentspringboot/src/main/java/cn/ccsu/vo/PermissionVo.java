package cn.ccsu.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/12 13:49
 * @Version 1.0
 */
public class PermissionVo implements Serializable {
    private List allPermissionsList;
    private List assignPermissions;

    public PermissionVo() {
    }

    public PermissionVo(List allPermissionsList, List assignPermissions) {
        this.allPermissionsList = allPermissionsList;
        this.assignPermissions = assignPermissions;
    }

    public List getAllPermissionsList() {
        return allPermissionsList;
    }

    public void setAllPermissionsList(List allPermissionsList) {
        this.allPermissionsList = allPermissionsList;
    }

    public List getAssignPermissions() {
        return assignPermissions;
    }

    public void setAssignPermissions(List assignPermissions) {
        this.assignPermissions = assignPermissions;
    }
}
