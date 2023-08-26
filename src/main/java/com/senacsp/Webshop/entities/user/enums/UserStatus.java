package com.senacsp.Webshop.entities.user.enums;

public enum UserStatus {

    ATIVO("ativo"),
    INATIVO("inativo");

    private String status;

    UserStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public static UserStatus valueOfStatus(String status) {
        for (UserStatus userStatus : UserStatus.values()) {
            if (userStatus.getStatus().equals(status)) {
                return userStatus;
            }
        }
        throw new IllegalArgumentException("Invalid status: " + status);
    }
}
