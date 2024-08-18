package objectData;

import java.util.List;

public class PracticeFormObject extends GeneralObject{
    private String firstNameValue;
    private String lastNameValue;
    private String userEmailValue;
    private String genderValue;
    private String phoneValue;
    private String dateOfBirthDaysValue;
    private String subjectValue;
    private String textareaValue;
    private String stateInputValue;
    private String cityInputValue;
    private String file;
    private List<String> hobbiesValues;


    public  PracticeFormObject(String filePath){
        fromJsonToObject(filePath);
    }

    public String getFirstNameValue() {
        return firstNameValue;
    }

    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
    }

    public String getLastNameValue() {
        return lastNameValue;
    }

    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
    }

    public String getUserEmailValue() {
        return userEmailValue;
    }

    public void setUserEmailValue(String userEmailValue) {
        this.userEmailValue = userEmailValue;
    }

    public String getGenderValue() {
        return genderValue;
    }

    public void setGenderValue(String genderValue) {
        this.genderValue = genderValue;
    }

    public String getPhoneValue() {
        return phoneValue;
    }

    public void setPhoneValue(String phoneValue) {
        this.phoneValue = phoneValue;
    }

    public String getDateOfBirthDaysValue() {
        return dateOfBirthDaysValue;
    }

    public void setDateOfBirthDaysValue(String dateOfBirthDaysValue) {
        this.dateOfBirthDaysValue = dateOfBirthDaysValue;
    }

    public String getSubjectValue() {
        return subjectValue;
    }

    public void setSubjectValue(String subjectValue) {
        this.subjectValue = subjectValue;
    }

    public String getTextareaValue() {
        return textareaValue;
    }

    public void setTextareaValue(String textareaValue) {
        this.textareaValue = textareaValue;
    }

    public String getStateInputValue() {
        return stateInputValue;
    }

    public void setStateInputValue(String stateInputValue) {
        this.stateInputValue = stateInputValue;
    }

    public String getCityInputValue() {
        return cityInputValue;
    }

    public void setCityInputValue(String cityInputValue) {
        this.cityInputValue = cityInputValue;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public List<String> getHobbiesValues() {
        return hobbiesValues;
    }

    public void setHobbiesValues(List<String> hobbiesValues) {
        this.hobbiesValues = hobbiesValues;
    }
}
