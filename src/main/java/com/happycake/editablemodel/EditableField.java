package com.happycake.editablemodel;

import com.sun.istack.internal.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Shyshkin Vladyslav on 03.05.17.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EditableField {
    enum EditableFields {
        TEXTFIELD,
        TEXTAREA,
        FILEFIELD,
        CALENDAR,
        SELECTFIELD
    }

    /**
     * String field name
     *
     * @return field name
     */
    @NotNull
    String name();

    /**
     * Field type
     *
     * @return type of field
     */
    @NotNull
    EditableFields type();

    /**
     * Pattern string
     *
     * @return pattern string
     */
    @NotNull
    String pattern();

    /**
     * Class name where can get array of elements to selection
     *
     * @return selection class path
     */
    String pathToSelectClass() default "";
}