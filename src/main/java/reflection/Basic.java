package reflection;

import data.User;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Basic {

    private void ClassMethods(Object object){
        System.out.println(" \n ");
        Method[] methods = object.getClass().getMethods();
        for(Method method : methods){
            System.out.println("method = " + method.getName());
        }
    }

    private void className(Object object) throws ClassNotFoundException {
        System.out.println(" \n ");
        Class aClass = object.getClass();
        Class className = Class.forName("reflection.Basic");
        System.out.println("Class Name: "+aClass.getName());
        System.out.println("Class Name: "+className.getName());
    }

    private void classPackage(Object object){
        System.out.println(" \n ");
        Class aClass = object.getClass();
        System.out.println(aClass.getPackage());
    }

    private void classModifiers(Object object){
        System.out.println(" \n ");
        Class aClass = object.getClass();
        int modifiers = aClass.getModifiers();
        System.out.println(Modifier.isPrivate(modifiers));
    }

    private void classInterface(Object object){
        System.out.println(" \n ");
        Class aClass = object.getClass();
        System.out.println(aClass.getInterfaces()[0]);
    }

    private void classConstructor(Object object){
        System.out.println(" \n ");
        Class aClass = object.getClass();
        Constructor[] constructors = aClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }

    private void classFields(Object object){
        System.out.println(" \n ");
        Class aClass = object.getClass();
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }
    
    public void start() throws Exception{
        classPackage(new User());
        className(new User());
        classInterface(new User());
        classConstructor(new User());
        classModifiers(new User());
        classFields(new User());
        ClassMethods(new User());
    }
}