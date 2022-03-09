package Bai3;

import java.util.Scanner;

public class NhanVien extends NhanSu{
    private String PhongBan;

    public NhanVien() {
        super();
    }

    public NhanVien(String phongBan) {
        PhongBan = phongBan;
    }

    public NhanVien(String hoTen, String gioiTinh, String diaChi, int tuoi, String phongBan) {
        super(hoTen, gioiTinh, diaChi, tuoi);
        PhongBan = phongBan;
    }

    public String getPhongBan() {
        return PhongBan;
    }

    public void setPhongBan(String phongBan) {
        PhongBan = phongBan;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner s = new Scanner(System.in);
        System.out.print("Phòng ban :");
        PhongBan = s.nextLine();
    }

    @Override
    public String toString() {
        return "NhanVien{" +super.toString()+
                ", PhongBan='" + PhongBan + '\'' +
                '}';
    }
}
