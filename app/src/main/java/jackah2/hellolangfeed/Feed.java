package jackah2.hellolangfeed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Feed extends AppCompatActivity {

    private static Context context;

    private List<User> users;
    FeedAdapter feedAdapter;
    ListView listView;

    public static final String USER_NAME = "user_name";
    public static final String USER_LANGUAGE = "user_language";
    public static final String USER_STATUS = "user_status";
    public static final String USER_TYPE = "user_type";
    public static final String USER_STATUS_COLOR = "user_status_color";
    public static final String USER_OBJECT = "user_object";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        users = new ArrayList<User>();
        feedAdapter = new FeedAdapter(this, users);

        listView = (ListView) findViewById(R.id.user_list);
        listView.setAdapter(feedAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = (User) parent.getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), UserActvity.class);

                intent.putExtra(USER_OBJECT, user);

                //intent.putExtra(USER_NAME, user.getUserName());
                //intent.putExtra(USER_LANGUAGE, user.getMainLanguage().toString());
                //intent.putExtra(USER_STATUS, user.getStatus().toString());
                //intent.putExtra(USER_TYPE, user.getType().toString());

                startActivity(intent);

            }
        });

        users.add(new User("Jack", Language.ENGLISH, UserType.STUDENT, Status.ONLINE));
        users.add(new User("Bob", Language.MANDARIN, UserType.STUDENT, Status.OFFLINE));
        users.add(new User("Nick", Language.SPANISH, UserType.STUDENT, Status.OFFLINE));
        users.add(new User("Charlie", Language.FRENCH, UserType.TEACHER, Status.ONLINE));
        users.add(new User("user1", Language.ENGLISH, UserType.TEACHER, Status.ONLINE));

        this.context = this;
    }

    public static Context getContext(){
        return context;
    }

    public List<User> getUsers(){
        // TODO
        // Implement method to get all users of app
        // Can filter this list

        return null;
    }

    public List<User> filterUsers(List<User> users, Language lang, Status status, UserType type){
        if(lang != null){
            // TODO
            // Implement filter to only show people with this language
        }

        if(status != null){
            // TODO
            // Implement filter to only show people that are online / offline
        }

        if(type != null){
            // TODO
            // Implement filter to only show people of this type
        }

        // filterUsers(Users, Language.ENGLISH,

        return null;

    }
}
