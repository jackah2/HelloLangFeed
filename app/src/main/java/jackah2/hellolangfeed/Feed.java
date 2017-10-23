package jackah2.hellolangfeed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Feed extends AppCompatActivity {

    private static Context _context;

    private final List<User> users = new ArrayList<>();
    private final List<User> filteredUsers = new ArrayList<>();
    private static final UserFilter userFilter = new UserFilter();
    FeedAdapter feedAdapter;
    ListView listView;
    Button filterUsersButton;

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


        filterUsersButton = (Button) findViewById(R.id.filter_users_button);
        filterUsersButton.setText(R.string.filter_users_button);
        filterUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FilterChooser.class));
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

    public static UserFilter getUserFilter(){
        return userFilter;
    }

    public List<User> getUsers(){
        // TODO
        // Implement method to get all users of app
        // Can filter this list

        return null;
    }


}
