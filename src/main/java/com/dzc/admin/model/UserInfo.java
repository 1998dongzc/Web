package com.dzc.admin.model;

public class UserInfo {
    private Integer id;

    private String role;

    private String name;

    private String avatar;

    private String introduction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}