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
     * If can be null
     *
     * @return if true can be null
     */
    boolean canBeNull() default false;


    /**
     * Pattern string
     *
     * @return pattern string
     */
    @NotNull
    String pattern() default "";


    /**
     * If field date
     *
     * @return if true current field is date
     */
    boolean isDate() default false;

    /**
     * Class name where can get array of elements to selection
     *
     * @return selection class path
     */
    String pathToSelectClass() default "";
}