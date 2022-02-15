package cn.techflower;

import net.datafaker.Address;
import net.datafaker.Faker;

import java.util.Locale;

public class FakerTest {
    public static void main(String[] args) {
        Address app = new Faker(new Locale("zh_CN")).address();
        System.out.println(app.state());
        System.out.println(app.city());
        System.out.println(app.city());
        System.out.println(app.city());
        System.out.println(app.city());
    }
}
