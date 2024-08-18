package objectData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
