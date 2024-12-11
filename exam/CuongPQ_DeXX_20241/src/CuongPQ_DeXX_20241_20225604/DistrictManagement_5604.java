package CuongPQ_DeXX_20241_20225604;
//PhamQuocCuong_20225604
import java.util.ArrayList;

public class DistrictManagement_5604 {
    // Lưu danh sách nhân khẩu bằng ArrayList
    private ArrayList<Person_5604> people_5604;

    public DistrictManagement_5604() {
        people_5604 = new ArrayList<>();
    }

    // Thêm một nhân khẩu vào danh sách
    public void addPerson_5604(Person_5604 p_5604) {
        people_5604.add(p_5604);
    }

    // Hiển thị danh sách tất cả nhân khẩu
    public void displayAll_5604() {
        System.out.println("Hien thi thong tin - PhamQuocCuong - 5604:");
        for (Person_5604 p : people_5604) {
            p.displayInfo_5604();
        }
    }

    // Tìm kiếm nhân khẩu theo tên
    public void searchByName_5604(String name_5604) {
        boolean found = false;
        for (Person_5604 p : people_5604) {
            if (p.getName_5604().equalsIgnoreCase(name_5604)) {
                p.displayInfo_5604();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay nhan khau co ten: " + name_5604);
        }
    }
}