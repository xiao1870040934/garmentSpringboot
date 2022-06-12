package cn.ccsu.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/9 8:51
 * @Version 1.0
 */
public class Menu extends BaseEntity implements Serializable {
    private Integer id;
    private String name;
    private String route;
    private Integer pid;
    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) && Objects.equals(name, menu.name) && Objects.equals(route, menu.route) && Objects.equals(pid, menu.pid) && Objects.equals(isDelete, menu.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, route, pid, isDelete);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", route='" + route + '\'' +
                ", pid=" + pid +
                ", isDelete=" + isDelete +
                '}';
    }
}
