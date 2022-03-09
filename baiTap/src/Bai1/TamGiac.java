package Bai1;

/*
Trong class này chúng ta sẽ kế thừa từ class DaGiac với các thuộc tính soCanh, a[ ], kèm theo các constructor và getter, setter.
Sau đó viết đè thêm hàm tính chu vi tinhCV() và hàm tính diện tích tinhDT() và kế thừa hàm xuatDaGiac() từ class cha DaGiac.
* */
public class TamGiac extends DaGiac {
    TamGiac() {
        this.a = new int[3];
        this.soCanh = 3;
    }

    public void nhap() {
        do {
            System.out.println("Nhập số cạnh cho tam giác: ");
            for (int i = 0; i < 3; i++) {
                System.out.println("Nhập cạnh thứ " + (i + 1) + " :");
                this.a[i] = scanner.nextInt();
            }
        } while ((a[0] + a[1]) <= a[2] || (a[1] + a[2]) <= a[0] || (a[0] + a[2]) <= a[1]);
    }

    public int tinhCV() {
        int cv = 0;
        for (int i = 0; i < 3; i++) {
            cv += this.a[i];
        }
        return cv;
    }

    public double tinhDT() {
        double dt = 0;
        int A = a[0];
        int B = a[1];
        int C = a[2];
        double P = (A + B + C) / 2;
        dt = Math.sqrt(P * (P - A) * (P - B) * (P - C));
        return dt;
    }

    public void xuat() {
        super.xuatDaGiac();
    }
}
