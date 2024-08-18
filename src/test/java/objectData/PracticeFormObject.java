package objectData;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

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


}
