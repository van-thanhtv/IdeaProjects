package quanly;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class DatTiec extends MainApp {
    private int maTiec = 1;
    private String tenBuoiTiec;
    private KhachHang khachHang;
    private SanhCuoi sanhThue;
    private String ngayThue;
    private ThoiDiem thoiDiemThue;
    private double donGiaThueSanh;
    private Menu menu;
    private double donGiaThucDon;
    private List<DichVu> dsDichVu = new ArrayList<DichVu>();
    private List<DatTiec> listDT = super.listDT;
    private List<Menu> listMN = new ArrayList<>();
    private double donGiaCacDichVu;

    public DatTiec() {

    }

    public DatTiec(int maTiec, String tenBuoiTiec, KhachHang khachHang, SanhCuoi sanhThue, String ngayThue, ThoiDiem thoiDiemThue, double donGiaThueSanh, Menu menu, double donGiaThucDon, double donGiaCacDichVu) {
        this.maTiec = maTiec;
        this.tenBuoiTiec = tenBuoiTiec;
        this.khachHang = khachHang;
        this.sanhThue = sanhThue;
        this.ngayThue = ngayThue;
        this.thoiDiemThue = thoiDiemThue;
        this.donGiaThueSanh = donGiaThueSanh;
        this.menu = menu;
        this.donGiaThucDon = donGiaThucDon;
        this.donGiaCacDichVu = donGiaCacDichVu;
    }

    // nhap thong tin khach hang
    public void nhapThongTinKhachHang(Scanner scanner) {
        ArrayList<KhachHang> listKH = new ArrayList<>();
        khachHang = new KhachHang();
        khachHang.nhapThongTin(scanner);
        int maKhachHang = 1;
        if (listKH.size() != 0) {
            maKhachHang = listKH.size() + 1;
        }
        khachHang.setMaKhachHang(maKhachHang);
        System.out.println("=>Hoàn tất nhập thông tin khách hàng");
        System.out.printf("-Tên khách hàng: %s\n", this.khachHang.getTenKhachHang());
        System.out.printf("-SĐT khách hàng: %s\n", this.khachHang.getSdtKhachHang());
    }

    // thue sanh
    public void thueSanh(Scanner scanner) {
        QuanLySanhCuoi qlsc = super.quanLySC;
        QuanLyThoiDiem qltd = super.quanLyTD;
        System.out.println("=>Danh sách sảnh cưới hiện có");
        for (SanhCuoi sc : qlsc.getDanhSachSC()) {
            sc.showInfo();
        }
        System.out.print("=>Nhập mã sảnh bạn muốn chọn: S");
        int maSanhMuonThue = scanner.nextInt();
        scanner.nextLine();
        for (SanhCuoi sc : qlsc.getDanhSachSC()) {
            if (sc.getMaSanh() == maSanhMuonThue) {
                sanhThue = new SanhCuoi(sc.getMaSanh(), sc.getTenSanh(), sc.getSucChua(), sc.getViTri(), sc.getGiaThueCoBan());
            }
        }
        System.out.println("=>Sảnh đã chọn cho buổi tiệc");
        sanhThue.showInfo();

        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("=>Nhập thông tin ngày thuê sảnh");
        System.out.println("-Nhập ngày: ");
        int ngay = scanner.nextInt();
        System.out.println("-Nhập tháng:");
        int thang = scanner.nextInt();
        System.out.println("-Nhập năm: ");
        int nam = scanner.nextInt();

        GregorianCalendar ngayDatTiec = new GregorianCalendar(nam, (thang - 1), ngay);
        int dayOfWeek = ngayDatTiec.get(Calendar.DAY_OF_WEEK);
        System.out.printf("=>Ngày buổi tiệc sẽ diễn ra: %s\n", f.format(ngayDatTiec.getTime()));
        setNgayThue(f.format(ngayDatTiec.getTime()));

        String thoiDiem;
        System.out.println("=>CHỌN THỜI ĐIỂM THUÊ");
        int chonThoiDiem =-1;
        if (dayOfWeek > 1 && dayOfWeek < 7)
            thoiDiem = "ngày thường";
        else
            thoiDiem = "ngày cuối tuần";
        for (ThoiDiem td : qltd.getDanhSach()) {
            if (td.getThoiDiemThue().equals(thoiDiem)) {
                td.showInfo();
                chonThoiDiem=td.getMaThoiDiem();
            }
        }
        int kt=0;
        for (ThoiDiem td : qltd.getDanhSach()) {
            if (td.getMaThoiDiem() == chonThoiDiem) {
                thoiDiemThue = new ThoiDiem(td.getMaThoiDiem(), td.getThoiDiemThue(), td.getHeSoChoThue());
                kt++;
            }
        }if (kt==0){
            System.out.println("Mã thời điểm chưa có !");
        }
        System.out.println("=>Thời điểm thuê đã chọn");
        thoiDiemThue.showInfo();
        System.out.printf("Đơn giá thuê sảnh: %,.2f\n", tinhDonGiaThueSanh());

    }

    // tinh don gia thue sanh
    public double tinhDonGiaThueSanh() {
        double donGiaThue = thoiDiemThue.getHeSoChoThue() * sanhThue.getGiaThueCoBan();
        return donGiaThue;
    }

    // tạo menu
    public int taoMenu(Scanner scanner) {
        scanner.nextLine();
        QuanLyMonAn ql = super.quanLyMA;
        System.out.print("Nhập tên menu: ");
        String tenMenu = scanner.nextLine();
        Menu menu = new Menu(tenMenu);
        this.setMenu(menu);
        int maMenu = 1;
        if (this.listMN.size() != 0) {
            maMenu = this.listMN.size() + 1;
        }
        listMN.add(menu);
        System.out.println("=>Hoàn tất nhập thông tin Menu");
        System.out.println("=>Danh sách món ăn nhà hàng hiện có");
        ql.hienThiDanhSachMonAn();
        boolean continued = true;
        do {
            System.out.print("=>Nhập mã món ăn cần thêm: ");
            int themMonAn = scanner.nextInt();
            scanner.nextLine();
            for (MonAn ma : ql.getDsMonAn()) {
                if (ma.getMaMon() == themMonAn) {
                    menu.themMonAn(ma);
                    System.out.println("=>Thêm thành công");
                }
            }
            System.out.println("=>Tiếp tục thêm món ăn vào menu (c,k): ");
            String tiepTuc = scanner.nextLine();
            if (tiepTuc.toLowerCase().contains("c"))
                continued = true;
            else
                continued = false;
        } while (continued == true);
        this.donGiaThucDon = menu.tinhDonGiaMenu();
        menu.showInfo();
        return maMenu;
    }

    // them dich vu
    public void themDichVu(Scanner scanner) {
        QuanLyDichVu qldv = super.quanLyDV;
        this.dsDichVu.clear();
        System.out.println("=>Danh sách dịch vụ nhà hàng hiện có");
        qldv.henThiDs();
        boolean continued = true;
        do {
            System.out.print("=>Nhập tên dịch vụ cần thêm: ");
            String tenDichVuThem = scanner.nextLine().toLowerCase();
            int thoiGianThue = 0;
            String tenCaSi = null;
            int soBaiHat = 0;
            if (tenDichVuThem.contains("karaoke")) {
                System.out.print("=>Nhập số giờ muốn thuê: ");
                thoiGianThue = scanner.nextInt();
                scanner.nextLine();
            } else if (tenDichVuThem.contains("thuê ca sĩ")) {
                System.out.print("=>Nhập tên ca sĩ muốn thuê: ");
                tenCaSi = scanner.nextLine();
                System.out.print("=>Nhập số lượng bài hát: ");
                soBaiHat = scanner.nextInt();
                scanner.nextLine();
            }
            for (DichVu dv : qldv.getDsDichVu()) {
                if (tenDichVuThem.contains("karaoke") && dv.tenDichVu.toLowerCase().contains(tenDichVuThem)) {
                    DichVu karaoke = new Karaoke(dv.maDichVu, dv.tenDichVu, dv.giaDichVu, thoiGianThue);
                    this.dsDichVu.add(karaoke);
                } else if (tenDichVuThem.contains("thuê ca sĩ")
                        && dv.tenDichVu.toLowerCase().contains(tenDichVuThem)) {
                    DichVu thueCaSi = new ThueCaSi(dv.maDichVu, dv.tenDichVu, dv.giaDichVu, tenCaSi, soBaiHat);
                    this.dsDichVu.add(thueCaSi);
                }else if(tenDichVuThem.equals(dv.tenDichVu)){
                    DichVu dvk = new DichVu(dv.maDichVu, dv.tenDichVu, dv.giaDichVu) {
                    };
                    this.dsDichVu.add(dvk);
                }
            }
            System.out.println("=>Bạn muốn thêm dịch vụ nào nữa không(c,k): ");
            String tiepTuc = scanner.nextLine();
            if (tiepTuc.toLowerCase().contains("c"))
                continued = true;
            else {
                System.out.println("=>Kết thúc thêm dịch vụ");
                continued = false;
            }
        } while (continued == true);

        System.out.println("=>Danh sách dịch vụ đã chọn");
        this.dsDichVu.forEach(dichVu -> dichVu.showInfo());
        System.out.printf("=>Tổng tiền các dịch vụ: %,.2f\n", this.tinhTongTienDichVu());
    }

    public double tinhTongTienDichVu() {
        double tongTienDichVu = 0;
        for (DichVu dv : this.dsDichVu)
            tongTienDichVu += dv.giaDichVu;
        return tongTienDichVu;
    }

    //xuat hoat don
    public void xuatHoaDon() {
        System.out.println("==========>HÓA ĐƠN THANH TOÁN<==========");

        System.out.println("=>Thông tin khách hàng");
        System.out.printf("-Tên khách hàng: %s\n", this.khachHang.getTenKhachHang());
        System.out.printf("-SĐT khách hàng: %s\n", this.khachHang.getSdtKhachHang());
        System.out.println("=>Thông tin sảnh");

        //this.sanhThue.showInfo();
        System.out.printf("-Mã sảnh: %d --- Tên sảnh: %s --- Sức chứa: %d (bàn) --- Vị trí: %s\n",
                this.sanhThue.getMaSanh(), this.sanhThue.getTenSanh(), this.sanhThue.getSucChua(),
                this.sanhThue.getViTri());
        //this.thoiDiemThue.showInfo();
        System.out.printf("-Thời điểm thuê: %s\n", this.thoiDiemThue.getThoiDiemThue());
        System.out.printf("Đơn giá thuê sảnh: %,.2f\n", this.tinhDonGiaThueSanh());

        System.out.println("=>Thông tin Menu");
        this.menu.showInfo();

        System.out.println("=>Thông tin các dịch vụ đính kèm");
        this.dsDichVu.forEach(dichVu -> dichVu.showInfo());

        System.out.println();
        System.out.printf("Tổng số tiền phải trả là: %,.2f\n", this.tinhTongTienPhaiTra());
    }

    //cho thue sanh
    public void choThueSanh(Scanner scanner) {

        //this.nhapThongTinBuoiTiec();
        scanner.nextLine();
        System.out.println("=>NHẬP THÔNG TIN KHÁCH HÀNG");
        this.nhapThongTinKhachHang(scanner);
        System.out.print("Nhập tên buổi tiệc: ");
        tenBuoiTiec = scanner.nextLine();
        System.out.println("=>CHỌN SẢNH CHO BUỔI TIỆC");
        this.thueSanh(scanner);
        System.out.println("=>CHỌN MÓN ĂN CHO MENU");
        this.taoMenu(scanner);
        System.out.println("=>CHỌN DỊCH VỤ ĐÍNH KÈM CHO BUỔI TIỆC");
        this.themDichVu(scanner);
        if (listDT.size() != 0) {
            this.maTiec = listDT.size() + 1;
        }
        System.out.print("=>Bạn có muốn xuất hóa đơn không (c,k): ");
        String xuatHoaDon = scanner.nextLine().toLowerCase();
        listDT.add(new DatTiec(this.maTiec, this.tenBuoiTiec, this.khachHang, this.sanhThue, this.ngayThue, this.thoiDiemThue, this.donGiaThueSanh, this.menu, this.donGiaThucDon, this.donGiaCacDichVu));
        if (xuatHoaDon.toLowerCase().contains("c") == true)
            this.xuatHoaDon();
        else
//            listDT.forEach(dv -> dv.toString());
            System.out.println("=>KẾT THÚC NHẬP THÔNG TIN CHO BUỔI TIỆC");
    }

    // tinh tong tien phải tra
    public double tinhTongTienPhaiTra() {
        double tienPhaiTra = 0;

        tienPhaiTra = this.tinhDonGiaThueSanh() + this.tinhTongTienDichVu() + this.menu.tinhDonGiaMenu() * this.sanhThue.getSucChua();

        return tienPhaiTra;
    }

    //bao cao doanh thu theo thang
    public void baoCaoDoanhThuTheoThang(Scanner scanner) {
        SimpleDateFormat f = new SimpleDateFormat("MM/yyyy");
        SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("=>NHẬP THÔNG TIN ĐỂ XUẤT BÁO CÁO DOANH THU");
        System.out.print(">Nhập tháng cần báo cáo doanh thu: ");
        Integer thang = scanner.nextInt();
        System.out.print(">Nhập năm cần báo cáo doanh thu: ");
        Integer nam = scanner.nextInt();
        System.out.printf("=>Danh sách tiệc trong tháng: %d<=\n", thang);
        GregorianCalendar ngayDatTiec = new GregorianCalendar(nam, (thang - 1), 1);
        double tongDoanhThu = 0;
        int soTiec = 0;
        for (DatTiec dt : listDT) {
            try {
                if (f.format(f1.parse(dt.ngayThue)).equalsIgnoreCase(f.format(ngayDatTiec.getTime()))) {
                    double tongTien = dt.tinhDonGiaThueSanh() + dt.tinhTongTienDichVu() + dt.menu.tinhDonGiaMenu() * dt.sanhThue.getSucChua();
                    System.out.printf("Mã tiệc: %d - Ngày thuê: %s - Tổng tiền: %,.2f\n", dt.maTiec, dt.ngayThue, tongTien);
                    tongDoanhThu += tongTien;
                    soTiec++;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("-Tổng số tiệc trong tháng %s: %d\n", thang, soTiec);
        System.out.printf("-Tổng doanh thu tháng %s: %,.2f\n", thang, tongDoanhThu);
    }

    //bao cao doanh thu theo nam
    public void baoCaoDoanhThuTheoNam(Scanner scanner) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy");
        SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("=>NHẬP THÔNG TIN ĐỂ XUẤT BÁO CÁO DOANH THU");
        System.out.print(">Nhập năm cần báo cáo doanh thu: ");
        Integer nam = scanner.nextInt();
        System.out.printf(">Danh sách tiệc trong năm: %d<=\n", nam);

        double tongDoanhThu = 0;
        int soTiec = 0;
        for (DatTiec dt : listDT) {
            try {
                if (Integer.parseInt(f.format(f1.parse(dt.ngayThue))) == nam) {
                    double tongTien = dt.tinhDonGiaThueSanh() + dt.tinhTongTienDichVu() + dt.menu.tinhDonGiaMenu() * dt.sanhThue.getSucChua();
                    System.out.printf("Mã tiệc: %d - Ngày thuê: %s - Tổng tiền: %,.2f\n", dt.maTiec, dt.ngayThue, tongTien);
                    tongDoanhThu += tongTien;
                    soTiec++;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("-Tổng số tiệc trong năm %s: %d\n", nam, soTiec);
        System.out.printf("-Tổng doanh thu năm %s: %,.2f\n", nam, tongDoanhThu);
    }

    // getter and setter
    public int getMaTiec() {
        return maTiec;
    }

    public void setMaTiec(int maTiec) {
        this.maTiec = maTiec;
    }

    public String getTenBuoiTiec() {
        return tenBuoiTiec;
    }

    public void setTenBuoiTiec(String tenBuoiTiec) {
        this.tenBuoiTiec = tenBuoiTiec;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public SanhCuoi getSanhThue() {
        return sanhThue;
    }

    public void setSanhThue(SanhCuoi sanhThue) {
        this.sanhThue = sanhThue;
    }

    public String getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(String ngayThue) {
        this.ngayThue = ngayThue;
    }

    public ThoiDiem getThoiDiemThue() {
        return thoiDiemThue;
    }

    public void setThoiDiemThue(ThoiDiem thoiDiemThue) {
        this.thoiDiemThue = thoiDiemThue;
    }

    public double getDonGiaThueSanh() {
        return donGiaThueSanh;
    }

    public void setDonGiaThueSanh(double donGiaThueSanh) {
        this.donGiaThueSanh = donGiaThueSanh;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public double getDonGiaThucDon() {
        return donGiaThucDon;
    }

    public void setDonGiaThucDon(double donGiaThucDon) {
        this.donGiaThucDon = donGiaThucDon;
    }

    public List<DichVu> getDsDichVu() {
        return dsDichVu;
    }

    public void setDsDichVu(List<DichVu> dsDichVu) {
        this.dsDichVu = dsDichVu;
    }

    public double getDonGiaCacDichVu() {
        return donGiaCacDichVu;
    }

    public void setDonGiaCacDichVu(double donGiaCacDichVu) {
        this.donGiaCacDichVu = donGiaCacDichVu;
    }


    @Override
    public String toString() {
        return "DatTiec{" +
                "maTiec=" + maTiec +
                ", tenBuoiTiec='" + tenBuoiTiec + '\'' +
                ", khachHang=" + khachHang +
                ", sanhThue=" + sanhThue +
                ", ngayThue='" + ngayThue + '\'' +
                ", thoiDiemThue=" + thoiDiemThue +
                ", donGiaThueSanh=" + donGiaThueSanh +
                ", donGiaThucDon=" + donGiaThucDon +
                ", donGiaCacDichVu=" + donGiaCacDichVu +
                '}';
    }
}
