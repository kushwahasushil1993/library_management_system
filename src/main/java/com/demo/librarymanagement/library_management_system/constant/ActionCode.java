package com.demo.librarymanagement.library_management_system.constant;

public enum ActionCode {

    NEW("new"),
    MODIFY("modify"),
    DELETE("delete");

    private String actionCode;

    ActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getActionCode() {
        return actionCode;
    }
}
