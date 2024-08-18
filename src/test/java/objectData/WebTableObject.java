package objectData;

public class WebTableObject extends GeneralObject {

    private String firstName;
    private String lastName;
    private String userEmail;
    private String ageValue;
    private String salaryValue;
    private String departmentValue;
    private String editRecord;

    public  WebTableObject(String path){
        fromJsonToObject(path);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAgeValue() {
        return ageValue;
    }

    public void setAgeValue(String ageValue) {
        this.ageValue = ageValue;
    }

    public String getSalaryValue() {
        return salaryValue;
    }

    public void setSalaryValue(String salaryValue) {
        this.salaryValue = salaryValue;
    }

    public String getDepartmentValue() {
        return departmentValue;
    }

    public void setDepartmentValue(String departmentValue) {
        this.departmentValue = departmentValue;
    }

    public String getEditRecord() {
        return editRecord;
    }

    public void setEditRecord(String editRecord) {
        this.editRecord = editRecord;
    }
}
