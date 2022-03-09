package Bai2;

public class RightTriangle extends Shape{
    int canhv;

    public RightTriangle(int canhv) {
        if (canhv >=1 && canhv <=20) {
            this.canhv = canhv;
        }
    }

    public RightTriangle() {
    }

    public int getCanhv() {
        return canhv;
    }

    public void setCanhv(int canhv) {
        this.canhv = canhv;
    }
    @Override
    public void draw() {
        int q=0;
        int h= canhv*2-2;
        while (canhv>5) {
            for (int j = 0; j < canhv; j++) {
                System.out.print("  ");
            }
            for (int i = 0; i <= q; i++) {
                System.out.print("* ");
            }
            canhv--;
            q+=2;
            System.out.println();
        }
        while (canhv<=5&&canhv>0){
            for (int j = 0; j < h; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <=2; j++) {
                System.out.print("* ");
            }
            System.out.println();
            canhv--;
        }
    }
}
