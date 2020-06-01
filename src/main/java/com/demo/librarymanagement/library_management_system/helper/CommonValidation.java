package com.demo.librarymanagement.library_management_system.helper;

@FunctionalInterface
public interface CommonValidation {

    boolean validateBook();

    static boolean validateProcureBook() {
        return false;
    }

}
