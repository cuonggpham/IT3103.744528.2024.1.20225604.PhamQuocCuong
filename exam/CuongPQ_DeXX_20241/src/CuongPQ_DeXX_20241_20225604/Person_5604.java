package CuongPQ_DeXX_20241_20225604;
//PhamQuocCuong_20225604

public class Person_5604 {
    protected String name_5604;
    protected int age_5604;
    protected String address_5604;

    public Person_5604(String name_5604, int age_5604, String address_5604) {
        this.name_5604 = name_5604;
        this.age_5604 = age_5604;
        this.address_5604 = address_5604;
    }

    public String getName_5604() {
        return name_5604;
    }

    public void setName_5604(String name_5604) {
        this.name_5604 = name_5604;
    }

    public int getAge_5604() {
        return age_5604;
    }

    public void setAge_5604(int age_5604) {
        this.age_5604 = age_5604;
    }

    public String getaddress_5604() {
        return address_5604;
    }

    public void setaddress_5604(String address_5604) {
        this.address_5604 = address_5604;
    }

    public String toString() {
        return "Name: " + name_5604 + ", Age: " + age_5604 + ", Address: " + address_5604;
    }

    //displayInfor trong lop Person
    public void displayInfo_5604() {
        System.out.println(this.toString());
    }
}
