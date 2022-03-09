package Bai1;

import java.util.Scanner;

/*
Trong class này chúng ta cần khai báo một mảng để chứa số lượng tam giác do người dùng nhập vào. Sau khi khai báo chúng ta sẽ bắt đầu thực hiện tạo các phương thức nhập xuất tam giác.
Xây dựng phương thức xuatLN() để xuất tam giác có diện tích lớn nhất.
* */
public class ListTamGiac {
    private int n;
    private TamGiac[] list = new TamGiac[100];
    Scanner scanner = new Scanner(System.in);

    public void ListTG() {
        for (int i = 0; i < 100; i++) {
            list[i] = new TamGiac();
        }
    }

    public void List() {
        System.out.println("Nhập số tam giác: ");
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            TamGiac tg = new TamGiac();
            tg.nhap();
            list[i] = tg;
        }
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("Tam giác thứ : " + (i + 1));
            list[i].xuatDaGiac();
        }
    }

    public void xuatLN() {
        double max = list[0].tinhDT();
        int Max = 0;
        for (int i = 0; i < n; i++) {
            if (list[i].tinhDT() > max) {
                max = list[i].tinhDT();
                Max = i;
            }
        }
        System.out.println("Lon nhat: ");
        list[Max].xuatDaGiac();
    }

    public void timKiem() {
        System.out.println("Nhập vị trí của tam giác cần tìm kiếm: ");
        int t = scanner.nextInt();
        if (t > n) {
            System.out.println("Vị trí không tồn tại");
        } else {
            list[t - 1].xuatDaGiac();
        }
    }

    public void xoa() {
        int k = 0;
        System.out.println("Nhập vào vị trí của tam giác cần xóa");
        int x = scanner.nextInt();
        if (x >= n) {
            System.out.println("Vị trí không tồn tại");
        } else {
            for (int i = 0; i < n; i++) {
                if (i != (x - 1)) {
                    list[k] = list[i];
                    k++;
                }
            }
        }
        n = k;
    }

    public void sapXep() {
        TamGiac temp = list[0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (list[i].tinhDT() > list[j].tinhDT()) {
                    temp = list[j];
                    list[j] = list[i];
                    list[i] = temp;
                }
            }
        }
    }
}
