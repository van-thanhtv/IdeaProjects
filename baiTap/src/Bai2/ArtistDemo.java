package Bai2;

import java.util.Scanner;

public class ArtistDemo {
    public static void main(String[] args) {
        int chieuDai,chieuRong,canhV;
        Scanner sc= new Scanner(System.in);
        Shape s = new Rectangle(8,4);
        new Artist().drawShape(s);
        System.out.println("----------------------------------------------");
        Shape ss = new RightTriangle(20);
        new Artist().drawShape(ss);
        System.out.println("----------------------------------------------");
        System.out.print("Nhập vào chiều dài :");
        chieuDai = sc.nextInt();
        System.out.print("Nhận vào chiều rộng :");
        chieuRong = sc.nextInt();
        System.out.print("Nhận vào cạnh :");
        canhV = sc.nextInt();
        System.out.println("------------------Vẽ hình --------------");
        System.out.println("Hình chữ nhật ");
        Shape cn = new Rectangle(chieuDai,chieuRong);
        new Artist().drawShape(cn);
        System.out.println("Hình tam giác vuông ");
        Shape tg = new RightTriangle(canhV);
        new Artist().drawShape(tg);
    }
}
