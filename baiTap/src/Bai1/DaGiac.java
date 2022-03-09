package Bai1;

import java.util.Arrays;
import java.util.Scanner;

public class DaGiac {
    //Khai báo các thuộc tính
    protected int soCanh;
    protected int a[];
    Scanner scanner = new Scanner(System.in);

    //khởi tạo constructor mặc định
    public DaGiac() {
        this.soCanh = 0;
        this.a = null;
    }

    //Khởi tạo constructor có tham số
    public DaGiac(int soCanh, int[] a, Scanner scanner) {
        this.soCanh = soCanh;
        this.a = a;
        this.scanner = scanner;
    }

    public int getSoCanh() {
        return soCanh;
    }

    public void setSoCanh(int soCanh) {
        this.soCanh = soCanh;
    }

    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    //Khởi tạo phương thức nhập
    protected void nhap() {
        do {
            System.out.println("Nhập vào số cạnh: ");
            this.soCanh = scanner.nextInt();

        } while (this.soCanh <= 2);
        for (int i = 0; i < this.soCanh; i++) {
            System.out.println("Nhập cạnh thứ " + (i + 1) + " :");
            this.a[i] = scanner.nextInt();
        }
    }

    //khởi tạo phương thức tính chu vi
    protected int tinhCV() {
        int cv = 0;
        for (int i = 0; i < this.soCanh; i++) {
            cv += this.a[i];
        }
        return cv;
    }

    @Override
    public String toString() {
        return "DaGiac{" +
                "soCanh=" + soCanh +
                ", a=" + Arrays.toString(a) +
                '}';
    }

    //khởi tạo phương thức xuất đa giác
    protected void xuatDaGiac() {
        System.out.println("Độ dài các cạnh lần lượt là: ");
        for (int i = 0; i < this.soCanh; i++) {
            if (i < (this.soCanh - 1)) {
                System.out.print(this.a[i] + "\t  \t");
            } else {
                System.out.println(this.a[i]);
            }
        }
        System.out.println("--------------------End--------------------");
    }
}
