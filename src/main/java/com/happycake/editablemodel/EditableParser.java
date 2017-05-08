package com.happycake.editablemodel;

import com.shyslav.mysql.interfaces.DBEntity;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @author Shyshkin Vladyslav on 08.05.17.
 */
public class EditableParser {
    private final HashMap<String, EditableEntity> entityHashMap = new HashMap<>();
    private final String modelName;

    public EditableParser(DBEntity entity) throws EditableFieldException {
        if (!entity.getClass().isAnnotationPresent(EditableModel.class)) {
            throw new EditableFieldException(" class doesn't have got model annotation ");
        }
        this.modelName = entity.getClass().getAnnotation(EditableModel.class).name();
        for (Field field : entity.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(EditableField.class)) {
                EditableEntity editableEntity = new EditableEntity(field, entity);

                field.setAccessible(true);
                editableEntity.setField(field);

                String fieldType = field.getType().getSimpleName();
                editableEntity.setFieldJavaType(fieldType);

                String fieldName = field.getName();
                editableEntity.setFieldJavaName(fieldName);

                String name = field.getAnnotation(EditableField.class).name();
                editableEntity.setFieldName(name);

                String pattern = field.getAnnotation(EditableField.class).pattern();
                editableEntity.setPattern(pattern);

                String selection = field.getAnnotation(EditableField.class).pathToSelectClass();
                editableEntity.setPathToSelectClass(selection);

                EditableField.EditableFields type = field.getAnnotation(EditableField.class).type();
                editableEntity.setType(type);

                Object value;
                try {
                    value = field.get(entity);
                } catch (IllegalAccessException e) {
                    throw new EditableFieldException("Unable to get field value " + e.getMessage(), e);
                }
                editableEntity.setValue(value);

                entityHashMap.put(fieldName, editableEntity);
            }
        }
    }

    public String getModelName() {
        return modelName;
    }

    public HashMap<String, EditableEntity> getEntityHashMap() {
        return entityHashMap;
    }
}
