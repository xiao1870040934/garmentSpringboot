package cn.ccsu.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/12 13:58
 * @Version 1.0
 */
public class MenuVo implements Serializable {
    private List allMenuList;
    private List assignMenus;

    public MenuVo() {
    }

    public MenuVo(List allMenuList, List assignMenus) {
        this.allMenuList = allMenuList;
        this.assignMenus = assignMenus;
    }

    public List getAllMenuList() {
        return allMenuList;
    }

    public void setAllMenuList(List allMenuList) {
        this.allMenuList = allMenuList;
    }

    public List getAssignMenus() {
        return assignMenus;
    }

    public void setAssignMenus(List assignMenus) {
        this.assignMenus = assignMenus;
    }
}
