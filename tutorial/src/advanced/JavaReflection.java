/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */

/*
Java Reflection makes it possible to inspect classes, interfaces,
fields and methods at runtime, without knowing the names of the
classes, methods etc.
 */
package advanced;

import java.lang.reflect.*;

public class JavaReflection {
    public JavaReflection() {
        publicReflection();

//        // Doing bad things here! Need a lot of exception handling...
//        try {
//            privateReflection();
//        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
    }

    void privateReflection() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CustomClassReflection ccr = new CustomClassReflection("McMaster",
                23, 2000.00);

        Field privateAgeField = ccr.getClass().getDeclaredField("age");
        privateAgeField.setAccessible(true);
        System.out.println(privateAgeField.get(ccr));

        System.out.println();

        Method privateMethod = ccr.getClass().getDeclaredMethod("algerAge");
        privateMethod.setAccessible(true);
        privateMethod.invoke(ccr, null);

        System.out.println(privateAgeField.get(ccr));
    }

    void publicReflection() {
        CustomClassReflection ccr = new CustomClassReflection("McMaster",
                23, 2000.00);

        Method[] methods = ccr.getClass().getMethods();

        for (Method method : methods)
            System.out.println(method);

        System.out.println();

        try {
            Method method = ccr.getClass().getMethod("printMethod");
            method.invoke(ccr, null);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println();

        /*
         * Instances of the class {@code Class} represent classes and
         * interfaces in a running Java application.
         */
        Class ccrClass = ccr.getClass();

        System.out.println(ccrClass.getName());
        System.out.println(ccrClass.getSimpleName());
        System.out.println(ccrClass.getPackage());
        System.out.println(ccrClass.getPackageName());

        System.out.println();

        // None of them!
        System.out.println(ccrClass.getModifiers());
        System.out.println(Modifier.isAbstract(ccrClass.getModifiers()));
        System.out.println(Modifier.isPublic(ccrClass.getModifiers()));
        System.out.println(Modifier.isVolatile(ccrClass.getModifiers()));

        System.out.println();

        System.out.println(ccrClass.getSuperclass());

        System.out.println();

        Constructor[] constructors = ccrClass.getConstructors();
        for (Constructor constructor : constructors)
            System.out.println(constructor);

        System.out.println();

        Field[] fields = ccrClass.getFields();
        for (Field field : fields)
            System.out.println(field + " - " + field.getType());
    }

    public static void main(String[] args) {
        new JavaReflection();
    }
}

//class CustomClassReflection {
class CustomClassReflection extends Serialization {
    String name;
    private int age;
    public Double credit;

    public CustomClassReflection(String name, int age, Double credit) {
        this.name = name;
        this.age = age;
        this.credit = credit;
    }

    public CustomClassReflection() {
    }

    public void printMethod() {
        System.out.println("HELLO!");
    }

    private void algerAge() {
        age += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }
}
