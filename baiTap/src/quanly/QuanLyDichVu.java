package quanly;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyDichVu {

    private List<DichVu> dsDichVu = new ArrayList<DichVu>();

    public QuanLyDichVu() {
        DichVu dv1 = new Karaoke(1, "karaoke", 9000, 0);
        DichVu dv2 = new ThueCaSi(2, "thuê ca sĩ", 8000, null, 0);
        dsDichVu.add(dv1);
        dsDichVu.add(dv2);
    }

    // them dich vu
    public void themDichVu(Scanner scanner) {
        System.out.println("=>Nhập thông tin dịch vụ cần thêm");
        System.out.println(">Nhập tên dịch vụ: ");
        String tenDichVu;
        tenDichVu = scanner.nextLine();
        System.out.println(">Nhập giá dịch vụ: ");
        double giaDichVu;
        giaDichVu = scanner.nextDouble();
        int maDichVu = 1;
        if (dsDichVu.size() != 0) {
            maDichVu = dsDichVu.size() + 1;
        }
        DichVu dv = new DichVu(maDichVu, tenDichVu, giaDichVu) {
            @Override
            public void showInfo() {
                super.showInfo();
            }

            @Override
            public int getMaDichVu() {
                return super.getMaDichVu();
            }

            @Override
            public void setMaDichVu(int maDichVu) {
                super.setMaDichVu(maDichVu);
            }

            @Override
            public String getTenDichVu() {
                return super.getTenDichVu();
            }

            @Override
            public void setTenDichVu(String tenDichVu) {
                super.setTenDichVu(tenDichVu);
            }

            @Override
            public double getGiaDichVu() {
                return super.getGiaDichVu();
            }

            @Override
            public void setGiaDichVu(double giaDichVu) {
                super.setGiaDichVu(giaDichVu);
            }
        };
        dsDichVu.add(dv);
    }

    // Hiển thị dịch vụ
    public void henThiDs() {
        for (DichVu dv : dsDichVu) {
            System.out.printf("Mã dịch vụ: DV-%d  ---- ", dv.maDichVu);
            System.out.println("Tên dịch vụ : " + dv.getTenDichVu() + "   ------   Giá dịch vụ : " + dv.getGiaDichVu());
        }
    }

    //Tra cứu dịch vụ theo tên
    public List<DichVu> traCuuDVTheoTen(String tenDVCanTim) {
        List<DichVu> kq = new ArrayList<DichVu>();
        for (DichVu dv : dsDichVu) {
            if (dv.getTenDichVu().equals(tenDVCanTim)) {
                kq.add(dv);
            }
        }
        return kq;
    }
    //Xóa dịch vụ
    public void xoaDichVu(Scanner scanner) {
        System.out.print(">Nhập mã dịch vụ cần xóa: DV");
        int maDVDelete = scanner.nextInt();
        for (DichVu dv: dsDichVu) {
            if (dv.getMaDichVu()==maDVDelete){
                dsDichVu.remove(dv);
                System.out.println("Xóa sảnh thành công");
            }
        }
    }
    //Getter and setter
    public List<DichVu> getDsDichVu() {
        return dsDichVu;
    }

    public void setDsDichVu(List<DichVu> dsDichVu) {
        this.dsDichVu = dsDichVu;
    }
}
