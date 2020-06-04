package com.demo.librarymanagement.library_management_system.helper;

public enum Constant {

    NEW("new"),
    MODIFY("modify"),
    DELETE("delete");

    private String actionCode;

    Constant(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getActionCode(){
        return actionCode;
    }
}
