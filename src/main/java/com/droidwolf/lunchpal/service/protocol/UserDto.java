package com.droidwolf.lunchpal.service.protocol;

public class UserDto {
    private String name;
    private String groupDesc;

    public UserDto() {
    }

    public UserDto(String name, String groupDesc) {
        this.name = name;
        this.groupDesc = groupDesc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }
}
