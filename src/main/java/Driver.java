import reflection.*;

public class Driver {

    public static void main(String[] args) throws Exception{
        new Basic().start();
        new Initialization().start();
        new Accessing().start();
        new Generics().start();
        Foo foo = (Foo) DebugProxy.newInstance(new FooImpl());
        Object o = foo.bar("joice");
        System.out.println(o);
    }
}