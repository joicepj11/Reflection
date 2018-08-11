package reflection;

import data.User;
import java.lang.reflect.Constructor;

public class Initialization {

    private void classConstructor(Class c) throws  Exception{
        Constructor[] constructor = c.getConstructors();
        //or User.class.getConstructors()
        // or Object.getClass().getConstructors()
        User myObject = (User) constructor[1].newInstance("constructor-arg1",1,"joi","joi");
        System.out.println(myObject.getAddress());
    }

    public void start()throws Exception{
        classConstructor(User.class);
    }
}