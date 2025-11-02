package prg25;

public class Printer {

//    public void print(int intValue) {
//        System.out.println("int value: " + intValue);
//    }

    public void print(String stringValue) {
        System.out.println("String value: " + stringValue);
    }

    public void print(Object object) {
        System.out.println("object class name: " + object.getClass().getName());
    }

    public void print(Integer integerValue) {
        System.out.println("Integer value: " + integerValue);
    }
}
