package quanly;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyThoiDiem {
    private List<ThoiDiem> danhSach = new ArrayList<ThoiDiem>();

    public QuanLyThoiDiem() {
        ThoiDiem thoiDiemThue = new ThoiDiem(1, "ngày thường", 5);
        ThoiDiem thoiDiemThue1 = new ThoiDiem(2, "ngày cuối tuần", 10);
        danhSach.add(thoiDiemThue1);
        danhSach.add(thoiDiemThue);
    }

    //them thoi diem cho thue
    public void themThoiDiem(Scanner scanner) {
        System.out.println("=>NHẬP THÔNG TIN THỜI ĐIỂM CẦN THÊM");
        scanner.nextLine();
        System.out.print(">Nhập thời điểm: ");
        String thoiDiem;
        thoiDiem = scanner.nextLine();

        System.out.println(">Nhập hệ số cho thuê");
        double heSoChoThue;
        heSoChoThue = scanner.nextDouble();
        int maThoiDiem = 1;
        if (danhSach.size() != 0) {
            maThoiDiem = danhSach.size() + 1;
        }
        ThoiDiem thoiDiemThue = new ThoiDiem(maThoiDiem, thoiDiem, heSoChoThue);
        danhSach.add(thoiDiemThue);
        System.out.println("Thêm thành công");
    }

    //hien thi thoi diem cho thue
    public void hienThiThoiDiem(Scanner scanner) {
        for (ThoiDiem td:danhSach) {
            td.showInfo();
        }
    }
    public List<ThoiDiem> traCuuTDTheoTen(String tenTDCanTim) {
        List<ThoiDiem> kq = new ArrayList<ThoiDiem>();
        for (ThoiDiem TD : danhSach) {
            if (TD.getThoiDiemThue().equals(tenTDCanTim)) {
                kq.add(TD);
            }
        }
        return kq;
    }
    //getter and setter
    public List<ThoiDiem> getDanhSach() {
        return danhSach;
    }
    public void setDanhSach(List<ThoiDiem> danhSach) {
        this.danhSach = danhSach;
    }
}
