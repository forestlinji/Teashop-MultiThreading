package test;

import ingredient.Bubble;
import ingredient.Coconut;
import teaShop.TeaShop;

import java.util.Calendar;
//测试类
public class Test {
    public static void main(String[] args) {
        TeaShop teaShop=new TeaShop();
        teaShop.stock(new Bubble("b1", Calendar.getInstance()));
        teaShop.stock(new Coconut("c1", Calendar.getInstance()));
        teaShop.stock(new Bubble("b2", Calendar.getInstance()));
        teaShop.sell("milktea1","Bubble");
        teaShop.sell("milktea2","Bubble");
        teaShop.sell("milktea3","Coconut");

        //模拟配料不足
        teaShop.sell("milktea4","Coconut");
    }
}
