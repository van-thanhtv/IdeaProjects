package quanly;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySanhCuoi {

    private List<SanhCuoi> danhSachSC = new ArrayList<SanhCuoi>();

    public QuanLySanhCuoi() {
        quanly.SanhCuoi sanhCuoi = new quanly.SanhCuoi(1, "A1", 10, "Tầng 1", 90000);
        danhSachSC.add(sanhCuoi);
    }

    // thêm sảnh cưới
    public void themSanhCuoi(Scanner scanner) {
        System.out.println("=>NHẬP THÔNG TIN SẢNH CƯỚI CẦN THÊM");
        System.out.print(">Nhập tên sảnh: ");
        String tenSanh;
        tenSanh = scanner.nextLine();

        System.out.println("Chọn vị trí: ");
        System.out.println("1.Tầng 1");
        System.out.println("2.Tầng 2");
        System.out.println("3.Tầng 3");
        System.out.println("4.Tầng 4");
        System.out.println("Bạn chọn: ");

        String viTri = "null";
        int chonViTri = scanner.nextInt();
        switch (chonViTri) {
            case 1:
                viTri = "Tầng 1";
                break;
            case 2:
                viTri = "Tầng 2";
                break;
            case 3:
                viTri = "Tầng 3";
                break;
            case 4:
                viTri = "Tầng 4";
                break;
            default:
                break;
        }

        System.out.print(">Nhập sức chứa: ");
        int sucChua;
        sucChua = scanner.nextInt();

        System.out.print(">Nhập giá thuê cơ bản: ");
        double giaThueCb;
        giaThueCb = scanner.nextDouble();
        int maSanhCuoi = 1;
        if (danhSachSC.size() != 0) {
            maSanhCuoi = danhSachSC.size() + 1;
        }
        quanly.SanhCuoi sanhCuoi = new quanly.SanhCuoi(maSanhCuoi, tenSanh, sucChua, viTri, giaThueCb);
        danhSachSC.add(sanhCuoi);
        System.out.println("Thêm thành công");
    }

    // hiển thị danh sách sảnh cưới
    public void hienThiDanhSachSanhCuoi() {
        System.out.println("=>DANH SÁCH SẢNH CƯỚI HIỆN CÓ");
        for (SanhCuoi sc : danhSachSC) {
            sc.showInfo();
        }
    }

    // Cập nhật sảnh
    public void capNhatSanhCuoi(Scanner scanner) {
        System.out.print(">Nhập mã sảnh muốn cập nhật: S");
        int maSanhUpdate;
        maSanhUpdate = scanner.nextInt();

        scanner.nextLine();
        System.out.print(">Nhập tên sảnh mới: ");
        String tenSanh;
        tenSanh = scanner.nextLine();

        System.out.println("=>Chọn vị trí mới");
        System.out.println("1.Tầng 1");
        System.out.println("2.Tầng 2");
        System.out.println("3.Tầng 3");
        System.out.println("4.Tầng 4");
        System.out.print(">Bạn chọn: ");

        String viTri = "null";
        int chonViTri = scanner.nextInt();
        switch (chonViTri) {
            case 1:
                viTri = "Tầng 1";
                break;
            case 2:
                viTri = "Tầng 2";
                break;
            case 3:
                viTri = "Tầng 3";
                break;
            case 4:
                viTri = "Tầng 4";
                break;
            default:
                break;
        }
        System.out.print(">Nhập sức chứa mới: ");
        int sucChua;
        sucChua = scanner.nextInt();

        System.out.print(">Nhập giá thuê cơ bản mới: ");
        double giaThueCb;
        giaThueCb = scanner.nextDouble();
        for (SanhCuoi sc : danhSachSC) {
            if (sc.getMaSanh() == maSanhUpdate) {
                sc.setGiaThueCoBan(giaThueCb);
                sc.setTenSanh(tenSanh);
                sc.setSucChua(sucChua);
                sc.setViTri(viTri);
                System.out.println("Cập nhật sảnh thành công");
            }
        }
    }

    // xóa sảnh cưới
    public void xoaSanhCuoi(Scanner scanner) {
        System.out.print(">Nhập mã sảnh cần xóa: S");
        int maSanhDelete = scanner.nextInt();
        for (SanhCuoi sc : danhSachSC) {
            if (sc.getMaSanh() == maSanhDelete) {
                danhSachSC.remove(sc);
                System.out.println("Xóa sảnh thành công");
            }
        }
    }

    // tra cứu sảnh cưới theo tên
    public List<SanhCuoi> traCuuSanhCuoiTheoTen(String tenSanhTim) {
//		Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        List<SanhCuoi> kq = new ArrayList<SanhCuoi>();
        int check = 0;
        for (SanhCuoi sc : danhSachSC) {
            if (sc.getTenSanh().equals(tenSanhTim)) {
                kq.add(sc);
            } else {
                check++;
            }
        }
        if (check == danhSachSC.size()) {
            System.out.println("Không có sảnh nào có tên " + tenSanhTim);
        }
        return kq;
    }

    // tra cứu sảnh cưới theo sức chứa
    public List<SanhCuoi> traCuuSanhCuoiTheoSucChua(int sucChuaTim) {
        List<SanhCuoi> kq = new ArrayList<SanhCuoi>();
        for (SanhCuoi sc : danhSachSC) {
            if (sc.getSucChua() == sucChuaTim) {
                kq.add(sc);
            }
        }
        return kq;
    }

    // tra cứu sảnh cưới theo vị trí
    public List<SanhCuoi> traCuuSanhCuoiTheoViTri(String viTriSanh) {
        List<SanhCuoi> kq = new ArrayList<SanhCuoi>();
        for (SanhCuoi sc : danhSachSC) {
            if (sc.getViTri().equals(viTriSanh)) {
                kq.add(sc);
            }
        }
        return kq;
    }

    // getter and setter
    public List<SanhCuoi> getDanhSachSC() {
        return danhSachSC;
    }

    public void setDanhSachSC(List<SanhCuoi> danhSachSC) {
        this.danhSachSC = danhSachSC;
    }

}
