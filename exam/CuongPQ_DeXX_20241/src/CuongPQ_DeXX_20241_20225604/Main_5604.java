package CuongPQ_DeXX_20241_20225604;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_5604 {
    public static void main(String[] args) {
        DistrictManagement_5604 management_5604 = new DistrictManagement_5604();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Quan ly Nhan khau - 5604 - PhamQuocCuong - ky 2024.1 - Ngay 11");

        while (running) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Them Nhan khau");
                System.out.println("2. Hien thi tat ca nhan khau");
                System.out.println("3. Tim kiem nhan khau theo ten");
                System.out.println("4. Thoat");
                System.out.print("Chon: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Nhap du lieu - PhamQuocCuong - 5604");
                        System.out.println("a. Them Nhan khau - Citizen_5604");
                        System.out.println("b. Them Nhan khau - Officer_5604");
                        
                        char type;
                        while (true) {
                            System.out.print("Chon loai nhan khau: ");
                            String input = scanner.nextLine();
                            if (input.length() == 1 && (input.charAt(0) == 'a' || input.charAt(0) == 'b')) {
                            type = input.charAt(0);
                            break;
                            }
                            System.out.println("Lua chon khong hop le. Vui long nhap 'a' hoac 'b'.");
                        }

                        System.out.print("Ho va ten: ");
                        String name_5604 = scanner.nextLine();

                        int age_5604;
                        while (true) {
                            System.out.print("Tuoi: ");
                            try {
                                age_5604 = scanner.nextInt();
                                scanner.nextLine();
                                if (age_5604 > 0) break;
                                else System.out.println("Tuoi phai la so duong. Vui long thu lai.");
                            } catch (InputMismatchException e) {
                                System.out.println("Vui long nhap mot so nguyen hop le cho tuoi.");
                                scanner.nextLine();
                            }
                        }

                        System.out.print("Dia chi: ");
                        String address_5604 = scanner.nextLine();

                        if (type == 'a') {
                            System.out.print("Nghe nghiep: ");
                            String job_5604 = scanner.nextLine();
                            management_5604.addPerson_5604(new Citizen_5604(name_5604, age_5604, address_5604, job_5604));
                        } else if (type == 'b') {
                            System.out.print("Phong ban cong tac: ");
                            String department_5604 = scanner.nextLine();
                            management_5604.addPerson_5604(new Officer_5604(name_5604, age_5604, address_5604, department_5604));
                        } else {
                            System.out.println("Lua chon khong hop le.");
                        }
                        break;

                    case 2:
                        management_5604.displayAll_5604();
                        break;

                    case 3:
                        System.out.println("Tim kiem - PhamQuocCuong - 5604:");
                        System.out.print("Nhap ten nhan khau _ 5604 can tim: ");
                        String searchName_5604 = scanner.nextLine();
                        management_5604.searchByName_5604(searchName_5604);
                        break;

                    case 4:
                        System.out.println("Thoat khoi chuong trinh - PhamQuocCuong - 744528.");
                        running = false;
                        break;

                    default:
                        System.out.println("Lua chon khong hop le. Vui long thu lai.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Lua chon khong hop le. Vui long nhap so tu 1 den 4.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}