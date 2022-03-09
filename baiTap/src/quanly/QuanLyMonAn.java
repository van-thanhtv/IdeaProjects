package quanly;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyMonAn {

    List<MonAn> dsMonAn = new ArrayList<MonAn>();

    public QuanLyMonAn() {
        MonAn ma = new ThucAn(1, "gà", 90, "có");
        this.dsMonAn.add(ma);
    }

    //themThucUong
    public void themThucUong(Scanner scanner) {
        System.out.println("=>Nhập thông tin thức uống");
        System.out.print(">Tên thức uống: ");
        String tenThucUong;
        tenThucUong = scanner.nextLine();

        System.out.println(">Giá bán: ");
        double giaBan;
        giaBan = scanner.nextDouble();

        scanner.nextLine();
        System.out.print(">Hãng sản xuất: ");
        String hangSx;
        hangSx = scanner.nextLine();
        int maMonAn = 1;
        if (dsMonAn.size() != 0) {
            maMonAn = dsMonAn.size() + 1;
        }
        MonAn monAn = new ThucUong(maMonAn, tenThucUong, giaBan, hangSx);
        this.dsMonAn.add(monAn);
        System.out.println("Thêm thành công");
    }

    //them thuc an
    public void themThucAn(Scanner scanner) {
        System.out.println("=>Nhập thông tin thức ăn");
        System.out.print(">Tên thức ăn: ");
        String tenThucAn;
        tenThucAn = scanner.nextLine();

        System.out.print(">Giá bán: ");
        double giaBan;
        giaBan = scanner.nextDouble();

        scanner.nextLine();
        System.out.println(">Ăn chay không");
        System.out.println("1.Có");
        System.out.println("2.Không");
        String anChay = null;
        int chonAnChay = scanner.nextInt();
        switch (chonAnChay) {
            case 1:
                anChay = "Có";
                break;
            case 2:
                anChay = "Không";
                break;
            default:
                break;
        }
        int maMonAn = 1;
        if (dsMonAn.size() != 0) {
            maMonAn = dsMonAn.size() + 1;
        }
        MonAn monAn = new ThucAn(maMonAn, tenThucAn, giaBan, anChay);
        this.dsMonAn.add(monAn);
        System.out.println("Thêm thành công");

    }

    //them mon an
    public void themMonAn(Scanner scanner) {
        System.out.println("=>Bạn muốn thêm thức ăn hay thức uống");
        System.out.println("1.Thức ăn");
        System.out.println("2.Thức uống");
        System.out.print(">Bạn chọn: ");
        int select = scanner.nextInt();
        switch (select) {
            case 1:
                scanner.nextLine();
                this.themThucAn(scanner);
                break;
            case 2:
                scanner.nextLine();
                this.themThucUong(scanner);
                break;
            default:
                break;
        }
    }

    //hien thi danh sach mon an
    public void hienThiDanhSachMonAn() {
        for (MonAn ma : dsMonAn) {
            ma.showInfo();
        }
    }

    // tra cuu mon an theo ten
    public List<MonAn> traCuuMonAnTheoTen(String tenMonCanTim) {
        List<MonAn> kq = new ArrayList<MonAn>();
        for (MonAn ma : dsMonAn) {
            if (ma.getTenMon().equals(tenMonCanTim)) {
                kq.add(ma);
            }
        }
        return kq;
    }

    // getter and setter
    public List<MonAn> getDsMonAn() {
        return dsMonAn;
    }

    public void setDsMonAn(List<MonAn> dsMonAn) {
        this.dsMonAn = dsMonAn;
    }

}
