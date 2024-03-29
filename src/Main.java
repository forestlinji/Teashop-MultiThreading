


import java.util.Scanner;

class HelloWorld {
    private int n;
    private boolean firstHello;//是否输出了第一个hello
    public HelloWorld( int n){
        this.n = n;
        firstHello=false;
    }
    public void hello() throws InterruptedException{
        for (int i = 0; i < n; i++) {
            synchronized (this){
                System.out.print("Hello");
                notifyAll();
                firstHello =true;
                this.wait();
            }
        }
    }

    public void world() throws InterruptedException{
        while(firstHello ==false);//当第一个hello没有被输出时，无限循环
        for (int i = 0; i < n; i++) {
            synchronized (this){
                System.out.println("World!");
                notifyAll();
                if(i!=n-1) this.wait();//最后一次，不进行切换
            }
        }
    }

}

class PrintWorld implements Runnable{
    HelloWorld helloWorld;
    public PrintWorld(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }
    @Override
    public void run(){
        try {
            helloWorld.world();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PrintHello implements Runnable {
    HelloWorld helloWorld;
    public PrintHello(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }
    @Override
    public void run() {
        try {
            helloWorld.hello();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HelloWorld helloWorld = new HelloWorld(n);
        PrintHello printHello = new PrintHello(helloWorld);
        PrintWorld printWorld = new PrintWorld(helloWorld);
        new Thread(printHello).start();

        new Thread(printWorld).start();
    }
}



