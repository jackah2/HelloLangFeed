package jackah2.hellolangfeed;

/**
 * Created by xmrpo on 10/20/2017.
 */

public class UserFilter {

    private Language language;
    private Status status;
    private UserType type;

    public UserFilter(Language language, Status status, UserType type){
        this.language = language;
        this.status = status;
        this.type = type;
    }

    public UserFilter(){
        clear();
    }

    public void clear(){
        this.language = null;
        this.status = null;
        this.type = null;
    }

    public Language getLanguage(){
        return language;
    }

    public void setLanguage(Language language){
        this.language = language;
    }

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public UserType getType(){
        return type;
    }

    public void setType(UserType type){
        this.type = type;
    }
}
