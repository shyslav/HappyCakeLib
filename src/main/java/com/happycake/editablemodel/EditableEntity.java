package com.happycake.editablemodel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Shyshkin Vladyslav on 08.05.17.
 */
public class EditableEntity {
    private EditableField.EditableFields type;
    private Field field;
    private String fieldName;
    private String pattern;
    private String pathToSelectClass;
    private String fieldJavaType;
    private String fieldJavaName;
    private HashMap<Integer, String> selectableMap;
    private Object value;

    public EditableField.EditableFields getType() {
        return type;
    }

    public void setType(EditableField.EditableFields type) {
        this.type = type;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setPathToSelectClass(String pathToSelectClass) throws EditableFieldException {
        if (pathToSelectClass == null || pathToSelectClass.isEmpty()) {
            return;
        }
        this.pathToSelectClass = pathToSelectClass;
        try {
            Class<?> clazz = Class.forName(pathToSelectClass);
            Method getValue = clazz.getMethod("getSelectableMap");
            selectableMap = (HashMap<Integer, String>) getValue.invoke(null);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new EditableFieldException("Unable to set path to select class", e);
        }
    }

    public String getFieldJavaType() {
        return fieldJavaType;
    }

    public void setFieldJavaType(String fieldJavaType) {
        this.fieldJavaType = fieldJavaType;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public String getFieldJavaName() {
        return fieldJavaName;
    }

    public void setFieldJavaName(String fieldJavaName) {
        this.fieldJavaName = fieldJavaName;
    }

    public HashMap<Integer, String> getSelectableMap() {
        return selectableMap;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean checkWithRegExp() {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(value.toString());
        return m.matches();
    }
}
