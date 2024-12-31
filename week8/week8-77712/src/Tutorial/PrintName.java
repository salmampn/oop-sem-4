package Tutorial;

import myPackage.myClass;

public class PrintName {
    public static void main(String[] args) {
        String name = "Pemrograman Berorientasi Objek";
        myClass obj = new myClass();
        obj.getNames(name);
    }
}
