package CuongPQ_DeXX_20241_20225604;
public class Officer_5604 extends Person_5604 {
    private String department_5604;

    public Officer_5604(String name_5604, int age_5604, String address_5604, String department_5604) {
        super(name_5604, age_5604, address_5604);
        this.department_5604 = department_5604;
    }

    public String getDepartment_5604() {
        return department_5604;
    }

    public void setDepartment_5604(String department_5604) {
        this.department_5604 = department_5604;
    }

    //displayInfor trong lop Officer
    @Override
    public void displayInfo_5604() {
        System.out.println("Officer ("+ super.toString() + ", Department: " + department_5604 + ")");
    }
}