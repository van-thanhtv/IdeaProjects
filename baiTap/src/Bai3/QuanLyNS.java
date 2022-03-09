package Bai3;


import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyNS {
    public static void main(String[] args) {
        // write your code herehelo
        int x;
        ArrayList<NhanSu> ns = new ArrayList<NhanSu>();
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("\n\t ---------------------------------- ");
            System.out.println("\t0. Thoát");
            System.out.println("\t1. Thêm mới nhân sự");
            System.out.println("\t2. Xuất danh sách nhân sự");
            System.out.println("\t3. Tìm kiếm nhân sự (tìm theo tên)");
            System.out.println("\t------------------------------------");
            x =  scanner.nextInt();
            System.out.println("--------------------End--------------------");
            switch (x){
                case 1:
                    System.out.println("Bạn muốn thêm nhân sự nào");
                    System.out.println("1.Nhân viên");
                    System.out.println("2.Giảng viên");
                    System.out.println("3.Sinh viên");
                    int i = scanner.nextInt();
                    if (i==1){
                        NhanSu nv = new NhanVien();
                        nv.nhap();
                        ns.add(nv);
                    }else if(i==2){
                        NhanSu gv = new GiangVien();
                        gv.nhap();
                        ns.add(gv);
                    }else{
                        NhanSu sv = new SinhVien();
                        sv.nhap();
                        ns.add(sv);
                    }
                    break;
                case 2:
                    for (NhanSu s : ns){
                        System.out.println(s.toString());
                    }
                    break;
                case 3:
                    System.out.println("Nhập họ tên bạn muốn tìm :");
                    scanner.nextLine();
                    String ten =scanner.nextLine();
                    int kt = ns.size();
                    int tb=0;
                    for (NhanSu s : ns){
                        if (ten.equals(s.getHoTen())){
                            System.out.println(s.toString());
                        }else{
                            tb++;
                        }
                    }
                    if (kt==tb){
                        System.out.println("Không có nhân viên nào tên như thế !");
                    }
                    break;
            }
        }while(x != 0);
        System.out.println(" ");
    }
}
