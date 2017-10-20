package jackah2.hellolangfeed;

/**
 * Created by xmrpo on 10/12/2017.
 */

public enum UserType {
    TEACHER(R.string.teacher),
    STUDENT(R.string.student);

    private int typeID;

    UserType(int typeID){
        this.typeID = typeID;
    }

    @Override
    public String toString() {
        return Feed.getContext().getResources().getString(typeID);
    }
}
