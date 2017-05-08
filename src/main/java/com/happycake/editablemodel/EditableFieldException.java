package com.happycake.editablemodel;

/**
 * @author Shyshkin Vladyslav on 08.05.17.
 */
public class EditableFieldException extends Exception {

    public EditableFieldException(String s) {
        super(s);
    }

    public EditableFieldException(String message, Throwable cause) {
        super(message, cause);
    }
}
