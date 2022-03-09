package Bai3;

import java.util.Scanner;

public class NhanSu {
    private String HoTen,gioiTinh,diaChi;
    private int Tuoi;

    public NhanSu() {
    }

    public NhanSu(String hoTen, String gioiTinh, String diaChi, int tuoi) {
        HoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        Tuoi = tuoi;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int tuoi) {
        Tuoi = tuoi;
    }
    public void nhap(){
        Scanner s = new Scanner(System.in);
        System.out.print("Họ và tên :");
        HoTen = s.nextLine();
        System.out.print("Tuổi :");
        Tuoi = Integer.parseInt(s.nextLine());
        System.out.print("Giới tính :");
        gioiTinh = s.nextLine();
        System.out.print("Dịa chỉ :");
        diaChi= s.nextLine();
    }
    @Override
    public String toString() {
        return
                "HoTen='" + HoTen + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", Tuoi=" + Tuoi
                ;
    }
}
