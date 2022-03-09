package Bai3;

import java.util.Scanner;

public class GiangVien extends NhanSu{
    private String HocVi;

    public GiangVien() {
        super();
    }

    public GiangVien(String hocVi) {
        HocVi = hocVi;
    }

    public GiangVien(String hoTen, String gioiTinh, String diaChi, int tuoi, String hocVi) {
        super(hoTen, gioiTinh, diaChi, tuoi);
        HocVi = hocVi;
    }

    public String getHocVi() {
        return HocVi;
    }

    public void setHocVi(String hocVi) {
        HocVi = hocVi;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner s = new Scanner(System.in);
        System.out.print("Học vị :");
        HocVi = s.nextLine();
    }

    @Override
    public String toString() {
        return "GiangVien{" +super.toString()+
                ", HocVi='" + HocVi + '\'' +
                '}';
    }
}
