package Bai3;

import java.util.Scanner;

public class SinhVien extends NhanSu{
    private String KhoaHoc;

    public SinhVien() {
        super();
    }

    public SinhVien(String khoaHoc) {
        KhoaHoc = khoaHoc;
    }

    public SinhVien(String hoTen, String gioiTinh, String diaChi, int tuoi, String khoaHoc) {
        super(hoTen, gioiTinh, diaChi, tuoi);
        KhoaHoc = khoaHoc;
    }

    public String getKhoaHoc() {
        return KhoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        KhoaHoc = khoaHoc;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner s = new Scanner(System.in);
        System.out.print("Khóa Học :");
        KhoaHoc = s.nextLine();
    }

    @Override
    public String toString() {
        return "SinhVien{" +super.toString()+
                ", KhoaHoc='" + KhoaHoc + '\'' +
                '}';
    }
}
