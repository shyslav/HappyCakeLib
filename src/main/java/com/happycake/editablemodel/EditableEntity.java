package com.happycake.editablemodel;

import com.happycake.sitemodels.HappyCakeRoles;
import com.shyslav.mysql.interfaces.DBEntity;

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
    private DBEntity entity;
    private String fieldName;
    private String pattern;
    private String pathToSelectClass;
    private String pathToEnumClass;
    private String fieldJavaType;
    private String fieldJavaName;
    private HashMap<String, Integer> selectableMap;
    private Object value;

    public EditableEntity(Field field, DBEntity entity) {
        this.field = field;
        this.entity = entity;
    }

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

    public void setPathToEnumClass(String pathToEnumClass) {
        this.pathToEnumClass = pathToEnumClass;
    }

    public void setPathToSelectClass(String pathToSelectClass) throws EditableFieldException {
        if (pathToSelectClass == null || pathToSelectClass.isEmpty()) {
            return;
        }
        this.pathToSelectClass = pathToSelectClass;
        try {
            Class<?> clazz = Class.forName(pathToSelectClass);
            Method getValue = clazz.getMethod("getSelectableMap");
            selectableMap = (HashMap<String, Integer>) getValue.invoke(null);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new EditableFieldException("Unable to set path to select class", e);
        }
    }

    /**
     * Get enum class values
     *
     * @return array list of enum values
     * @throws EditableFieldException
     */
    public Object[] getEnumClassValues() throws EditableFieldException {
        if (pathToEnumClass == null) {
            return null;
        }
        try {
            Class<?> clazz = Class.forName(pathToEnumClass);
            return clazz.getEnumConstants();
        } catch (ClassNotFoundException e) {
            throw new EditableFieldException("Unable to get enum by path", e);
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

    public HashMap<String, Integer> getSelectableMap() {
        return selectableMap;
    }

    public Object getValue() {
        if (value != null) {
            return value;
        } else {
            return "";
        }
    }

    public void setValue(Object value) {
        field.setAccessible(true);
        try {
            field.set(entity, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        this.value = value;
    }

    /**
     * Validate value by regex pattern
     *
     * @return true if valid
     */
    public boolean checkWithRegExp() {
        if (value == null) {
            return false;
        }
        if (pattern.isEmpty()) {
            return value != null;
        }
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(value.toString());
        return m.matches();
    }

    /**
     * Get int value
     *
     * @return integer value
     */
    public int getIntValue() {
        if (value instanceof Integer) {
            return (Integer) value;
        } else {
            return 0;
        }
    }

    /**
     * Get long value
     *
     * @return long value
     */
    public long getLongValue() {
        if (value instanceof Integer) {
            return ((Integer) value).longValue();
        } else {
            return 0;
        }
    }
}
