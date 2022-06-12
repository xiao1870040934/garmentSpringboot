package cn.ccsu.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 潇洒哥queen
 * @Date 2022/5/31 8:32
 * @Version 1.0
 */
public class UserInfo implements Serializable {
    String name;
    String avatar;
    List roles;
    List routes;

    public UserInfo() {
    }

    public UserInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List getRoles() {
        return roles;
    }

    public void setRoles(List roles) {
        this.roles = roles;
    }

    public List getRoutes() {
        return routes;
    }

    public void setRoutes(List routes) {
        this.routes = routes;
    }
}
