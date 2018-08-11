package data;

public class User implements IUser{

    public String name;
    public int age;
    public String Address;
    public String phoneNumber;

    public User() { }

    public User(String name, int age, String address, String phoneNumber) {
        this.name = name;
        this.age = age;
        Address = address;
        this.phoneNumber = phoneNumber;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void printUser(Object o) {
        System.out.println(o);
    }
}