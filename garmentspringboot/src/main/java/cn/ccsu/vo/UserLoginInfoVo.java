package cn.ccsu.vo;

import java.io.Serializable;

/**
 * @Author 潇洒哥queen
 * @Date 2022/5/30 19:29
 * @Version 1.0
 */
public class UserLoginInfoVo implements Serializable {
    private String token;

    public UserLoginInfoVo(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
