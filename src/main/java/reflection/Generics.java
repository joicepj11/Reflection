package reflection;

import data.GenericData;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class Generics {

   private void accessingGenericReturnType() throws Exception{
       Method method = GenericData.class.getMethod("getStringList");
       Type returnType = method.getGenericReturnType();
       if(returnType instanceof ParameterizedType){
           ParameterizedType type = (ParameterizedType) returnType;
           Type[] typeArguments = type.getActualTypeArguments();
           for(Type typeArgument : typeArguments){
               Class typeArgClass = (Class) typeArgument;
               System.out.println("typeArgClass = " + typeArgClass);
           }
       }
   }

    private void accessingGenericSetter() throws Exception{
        Method method  = GenericData.class.getMethod("setStringList", List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for(Type genericParameterType : genericParameterTypes){
            if(genericParameterType instanceof ParameterizedType){
                ParameterizedType pType = (ParameterizedType) genericParameterType;
                Type[] parameterArgTypes = pType.getActualTypeArguments();
                for(Type parameterArgType : parameterArgTypes){
                    Class parameterArgClass = (Class) parameterArgType;
                    System.out.println("parameterArgClass = " + parameterArgClass);
                }
            }
        }
    }

    private void accessingGenericFields(Object o) throws Exception{
        Field field = GenericData.class.getDeclaredField("stringList");
        Type genericFieldType = field.getGenericType();
        if(genericFieldType instanceof ParameterizedType){
            ParameterizedType aType = (ParameterizedType) genericFieldType;
            Type[] fieldArgTypes = aType.getActualTypeArguments();
            for(Type fieldArgType : fieldArgTypes){
                Class fieldArgClass = (Class) fieldArgType;
                System.out.println("fieldArgClass = " + fieldArgClass);
            }
        }
        field.setAccessible(true);
        System.out.println(field.get(o));
    }

    public void start() throws Exception{
        accessingGenericReturnType();
        accessingGenericSetter();
        accessingGenericFields(new GenericData());
    }
}