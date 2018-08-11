package reflection;

import data.PrivateUser;
import data.User;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Accessing {

    private void classFields(User object) throws Exception{
        Class aClass = object.getClass();
        //getting values
        Field field = aClass.getField("name");
        System.out.println(field.get(object));
        // setting values
        field.set(object, "Joice PJ");
        System.out.println(field.get(object));
        //or String name = (String) aClass.getField("name").get(object);
        // getting data type
        Field field1 = aClass.getField("age");
        System.out.println(field1.getGenericType());
    }

    private void classMethods(Object object) throws Exception{
        Method getName = User.class.getMethod("getName"); // getter method
        System.out.println(getName.invoke(object)); // invoking the method
        Method setName = User.class.getMethod("setName",String.class); // setter method
        setName.invoke(object,"Joice PJ"); // invoking the method
        System.out.println(getName.invoke(object)); // checking value is set or not
        // setName.getReturnType(); to get return type
        //setName.getParameterTypes(); to get parameter types
        //Class userClass = object.getClass();//obtain class object
        //userClass.getMethod("getName");
    }

    private void privateMethods(Object object) throws Exception{
        Method getName = PrivateUser.class.getDeclaredMethod("getName"); // getter method
        getName.setAccessible(true); // making method accessible
        System.out.println(getName.invoke(object)); // invoking the method
        Method setName = PrivateUser.class.getDeclaredMethod("setName",String.class); // setter method
        setName.setAccessible(true);
        setName.invoke(object,"Joice PJ"); // invoking the method
        System.out.println(getName.invoke(object)); // checking value is set or not
    }

    private void privateFields(Object object) throws Exception{
        Field name = PrivateUser.class.getDeclaredField("name"); // getter method
        name.setAccessible(true); // making method accessible
        System.out.println(name.get(object));
    }

    public void start()throws Exception{
        classFields(new User("Joice",22,"Pump house","8050808132"));
        classMethods(new User("Joice",22,"Pump house","8050808132"));
        privateMethods(new PrivateUser("Joice"));
        privateFields(new PrivateUser("Joice"));
    }
}