package com.master.annotation;

import java.lang.reflect.Field;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/8/12 19:17
 */
public class TestAnno {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @TestAnnotation
    private  String name;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        //TestAnno ta=new TestAnno();
        //Class<?> clazz= ta.getClass();
        Class<?>clazz=Class.forName("com.master.annotation.TestAnno");
        Field field= clazz.getDeclaredField("name");
        TestAnnotation anno=field.getAnnotation(TestAnnotation.class);
        String value=anno.name();
        System.out.println(value);
    }

}
