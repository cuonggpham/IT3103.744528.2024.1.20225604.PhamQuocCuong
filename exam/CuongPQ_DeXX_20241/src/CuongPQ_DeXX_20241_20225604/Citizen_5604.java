package CuongPQ_DeXX_20241_20225604;
//PhamQuocCuong_20225604

public class Citizen_5604 extends Person_5604 {
    private String job_5604;

    public Citizen_5604(String name_5604, int age_5604, String address_5604, String job_5604) {
        super(name_5604, age_5604, address_5604);
        this.job_5604 = job_5604;
    }

    public String getJob_5604() {
        return job_5604;
    }

    public void setJob_5604(String job_5604) {
        this.job_5604 = job_5604;
    }

    //displayInfor trong lop Citizen
    @Override
    public void displayInfo_5604() {
        System.out.println("Citizen (" + this.toString() + ", Job: " + job_5604 + ")");
    }
}
