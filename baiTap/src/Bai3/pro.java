package Bai3;
import java.util.Scanner;

public class pro {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] arr = new String[]{"Không", "Một", "Hai", "Ba", "Bốn", "Năm", "Sáu", "Bảy", "Tám", "Chín"};
        String[] arr2 = new String[]{"Mười", "Mươi", "Lẻ", "Mốt"};
        while (true) {
            System.out.println("Nhap a :");
            int a = s.nextInt();
            String Stringa = String.valueOf(a);
            if (a >= 0 && a < 10) {
                for (int i = 0; i < arr.length; i++) {
                    if (a == i) {
                        System.out.println(arr[i]);
                    }
                }
            } else if (a >= 10 && a < 100) {
                for (int i = 1; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        String[] mangA = Stringa.split("");
                        if (i == Integer.valueOf(mangA[0]) && j == Integer.valueOf(mangA[1])) {
                            if (Integer.valueOf(mangA[1]) == 1) {
                                System.out.println(arr[i] + " Mươi" + " " + arr2[3]);
                            } else if (Integer.valueOf(mangA[0]) == 1 && Integer.valueOf(mangA[1]) == 0) {
                                System.out.println(arr2[0]);
                            } else if (Integer.valueOf(mangA[1]) == 0) {
                                System.out.println(arr[i] + " " + arr2[1]);
                            } else if (Integer.valueOf(mangA[0]) == 1) {
                                System.out.println(arr2[0] + " " + arr[j]);
                            } else {
                                System.out.println(arr[i] + " " + arr2[1] + " " + arr[j]);
                            }
                        }
                    }
                }
            } else if (a >= 100 && a < 1000) {
                for (int i = 1; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        for (int k = 0; k < arr.length; k++) {
                            String[] mangA = Stringa.split("");
                            if (Integer.valueOf(mangA[0]) == i && Integer.valueOf(mangA[1]) == j && Integer.valueOf(mangA[2]) == k) {
                                if (Integer.valueOf(mangA[1]) == 1) {
                                    System.out.println(arr[i] + " Trăm" + " " + arr2[0] + " " + arr[k]);
                                } else if (Integer.valueOf(mangA[2]) == 0 && Integer.valueOf(mangA[1]) == 0) {
                                    System.out.println(arr[i] + " " + "Trăm");
                                } else if (Integer.valueOf(mangA[1]) == 0) {
                                    System.out.println(arr[i] + " Trăm" + " " + arr2[2] + " " + arr[k]);
                                } else if (Integer.valueOf(mangA[2]) == 1) {
                                    System.out.println(arr[i] + " Trăm" + " " + arr[j] + " " + arr2[1] + " " + arr2[3]);
                                } else {
                                    System.out.println(arr[i] + " Trăm" + " " + arr[j] + " Mươi " + arr[k]);
                                }
                            }
                        }
                    }
                }
            } else if (a >= 1000 && a < 10000) {
                for (int i = 1; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        for (int k = 0; k < arr.length; k++) {
                            for (int m = 0; m < arr.length; m++) {
                                String[] mangA = Stringa.split("");
                                if (Integer.valueOf(mangA[0]) == i
                                        && Integer.valueOf(mangA[1]) == j
                                        && Integer.valueOf(mangA[2]) == k
                                        && Integer.valueOf(mangA[3]) == m
                                ) {
                                    if (Integer.valueOf(mangA[1]) == 0
                                            && Integer.valueOf(mangA[2]) == 0
                                            && Integer.valueOf(mangA[3]) == 0) {
                                        System.out.println(arr[i] + "Nghìn");
                                    } else if (Integer.valueOf(mangA[2]) == 0 && Integer.valueOf(mangA[3]) == 0) {
                                        System.out.println(arr[i] + " Nghìn " + arr[j] + " Trăm ");
                                    } else if (Integer.valueOf(mangA[1]) == 0 && Integer.valueOf(mangA[2]) == 0 && Integer.valueOf(mangA[3]) == 1) {
                                        System.out.println(arr[i] + " Nghìn " + arr[j] + " Trăm " + arr2[2] + " " + arr[m]);
                                    } else if (Integer.valueOf(mangA[3]) == 1 && Integer.valueOf(mangA[2]) != 0) {
                                        System.out.println(arr[i] + " Nghìn " + arr[j] + " Trăm " + arr[k] + " " + arr2[1] + " " + arr2[3]);
                                    } else if (Integer.valueOf(mangA[2]) == 1 && Integer.valueOf(mangA[3]) != 0) {
                                        System.out.println(arr[i] + " Nghìn " + arr[j] + " Trăm " + arr2[0] + " " + arr[m]);
                                    } else if (Integer.valueOf(mangA[2]) == 1 && Integer.valueOf(mangA[3]) == 0) {
                                        System.out.println(arr[i] + " Nghìn " + arr[j] + "Trăm " + arr2[0]);
                                    } else if (Integer.valueOf(mangA[2]) == 0) {
                                        System.out.println(arr[i] + " Nghìn " + arr[j] + " Trăm " + arr2[2] + " " + arr[m]);
                                    } else {
                                        System.out.println(arr[i] + " Nghìn " + arr[j] + " Trăm " + arr[k] + " Mươi " + arr[m]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
