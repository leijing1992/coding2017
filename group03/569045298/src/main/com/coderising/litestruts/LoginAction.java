package com.coderising.litestruts;

/**
 * 这是一个用来展示登录的业务类， 其中的用户名和密码都是硬编码的。
 */
public class LoginAction {

    private String name;

    private String password;

    private String message;

    public String execute() {
        if ("test".equals(name) && "1234".equals(password)) {
            this.message = "login successful";
            return "success";
        }
        this.message = "login failed,please check your user/pwd";
        return "fail";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}