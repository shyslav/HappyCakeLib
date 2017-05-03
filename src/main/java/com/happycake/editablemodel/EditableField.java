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
    /**
     * String field name
     *
     * @return field name
     */
    @NotNull
    String name();


    /**
     * Minimum field length
     *
     * @return minimum length of field
     */
    @NotNull
    int minLength() default 0;

    /**
     * Maximum length
     *
     * @return maximum length of field
     */
    @NotNull
    int maxLength();


    /**
     * If can be null
     *
     * @return if true can be null
     */
    boolean canBeNull() default true;


    /**
     * Pattern string
     *
     * @return pattern string
     */
    String pattern() default "";


    /**
     * If field date
     *
     * @return if true current field is date
     */
    boolean isDate() default false;
}