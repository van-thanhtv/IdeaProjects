package Bai1;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code herehelo
        int x;
        System.out.println("\n\t---------------------------------");

        Scanner scanner = new Scanner(System.in);
        ListTamGiac dstg = new ListTamGiac();
        do{
            System.out.println("\n\t ---------------------------------- ");
            System.out.println("\t0. Thoát");
            System.out.println("\t1. Thêm danh sách các tam giác");
            System.out.println("\t2. Xuất danh sách các tam giác");
            System.out.println("\t3. In tam giác có diện tích lớn nhất");
            System.out.println("\t4. Tìm kiếm tam giác theo vị trí index (Nhập từ người dùng)");
            System.out.println("\t5. Xóa 1 tam giác theo vị trí index (Nhập từ người dùng)");
            System.out.println("\t------------------------------------");
            x = scanner.nextInt();
            System.out.println("--------------------End--------------------");
            switch (x){
                case 1:
                    dstg.List();
                    break;
                case 2:
                    dstg.xuat();
                    break;
                case 3:
                    dstg.xuatLN();
                    break;
                case 4:
                    dstg.timKiem();
                    break;
                case 5:
                    dstg.xoa();
                    break;
                case 6:
                    dstg.sapXep();
                    break;
            }
        }while(x != 0);
        System.out.println(" ");
    }
}
