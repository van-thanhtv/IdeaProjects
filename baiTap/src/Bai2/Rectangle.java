package Bai2;

public class Rectangle extends Shape{
    // Thuoc tinh
    int chieuDai;
    int chieuRong;

    public Rectangle() {
    }

    @Override
    public void draw() {
        for (int i = 1 ;i <= chieuRong;i++){
            for (int j = 1;j<= chieuDai;j++){
                if (i==1||i==chieuRong||j==1||j==chieuDai){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }

    public Rectangle(int chieuDai, int chieuRong) {
        if (chieuDai>=1&&chieuDai<=15&&chieuRong>=1&chieuRong<=15){
            this.chieuDai = chieuDai;
            this.chieuRong = chieuRong;
        }
    }

    public int getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(int chieuDai) {
        this.chieuDai = chieuDai;
    }

    public int getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(int chieuRong) {
        this.chieuRong = chieuRong;
    }
}
