package jackah2.hellolangfeed;

import java.io.Serializable;

/**
 * Created by xmrpo on 10/6/2017.
 */

@SuppressWarnings("serial")
public class User implements Serializable{

    private final String userName;
    private final Language mainLanguage;
    private final UserType userType;
    private Status status;

    public User(String userName, Language mainLanguage, UserType userType, Status status){
        this.userName = userName;
        this.mainLanguage = mainLanguage;
        this.userType = userType;
        this.status = status;
    }

    public String getUserName(){
        return userName;
    }

    public Language getMainLanguage(){
        return mainLanguage;
    }

    public UserType getType(){
        return userType;
    }

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }
}
