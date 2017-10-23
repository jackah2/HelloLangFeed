package jackah2.hellolangfeed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class Feed extends AppCompatActivity {

    private static Context _context;

    private final List<User> users = new ArrayList<>();
    private final List<User> filteredUsers = new ArrayList<>();
    private final UserFilter userFilter = new UserFilter();
    FeedAdapter feedAdapter;
    ListView listView;
    Switch onlineOnlySwitch;

    public static final String USER_OBJECT = "user_object";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        _context = this;

        feedAdapter = new FeedAdapter(this, filteredUsers);

        listView = (ListView) findViewById(R.id.user_list);
        listView.setAdapter(feedAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = (User) parent.getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), UserActvity.class);

                intent.putExtra(USER_OBJECT, user);

                startActivity(intent);
            }
        });

        users.add(new User("Jack", Language.ENGLISH, UserType.STUDENT, Status.ONLINE));
        users.add(new User("Bob", Language.MANDARIN, UserType.STUDENT, Status.OFFLINE));
        users.add(new User("Nick", Language.SPANISH, UserType.STUDENT, Status.OFFLINE));
        users.add(new User("Charlie", Language.FRENCH, UserType.TEACHER, Status.ONLINE));
        users.add(new User("user1", Language.ENGLISH, UserType.TEACHER, Status.ONLINE));

        onlineOnlySwitch = (Switch) findViewById(R.id.online_only_switch);
        onlineOnlySwitch.setText(R.string.show_online_only);
        onlineOnlySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    userFilter.setStatus(Status.ONLINE);
                }else{
                    userFilter.clear();
                }
                updateFilter();
            }
        });

        updateFilter();
    }

    public static Context getContext(){
        return _context;
    }

    public void updateFilter(){
        filteredUsers.clear();
        filteredUsers.addAll(userFilter.filter(users));
        feedAdapter.notifyDataSetChanged();
    }

    public List<User> getUsers(){
        // TODO
        // Implement method to get all users of app
        // Can filter this list

        return null;
    }


}
