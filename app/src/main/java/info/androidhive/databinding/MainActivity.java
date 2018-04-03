package info.androidhive.databinding;

import android.content.Context;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.databinding.databinding.ActivityMainBinding;
import info.androidhive.databinding.model.Post;
import info.androidhive.databinding.model.User;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    MyClickHandlers handlers;

    private List<Post> postList = new ArrayList<>();
    private PostsAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        handlers = new MyClickHandlers(this);

        User user = new User();
        user.setName("Ravi Tamada");
        user.setEmail("ravi8x@gmail.com");
        user.setProfileImage("https://avatars2.githubusercontent.com/u/497670?s=400&v=4");
        user.setWebsite("www.rxjava.wtf");
        user.setNumberOfFollowers(3050890);
        user.setNumberOfFollowing(150);
        user.setNumberOfPosts(3400);

        binding.setUser(user);
        binding.content.setHandlers(handlers);

        recyclerView = binding.content.recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new PostsAdapter(postList);
        recyclerView.setAdapter(mAdapter);


        preparePosts();
    }

    private void preparePosts() {
        for (int i = 0; i < 10; i++) {
            Post post = new Post();
            post.setImageUrl("https://instagram.fbpm1-1.fna.fbcdn.net/vp/26595d76ac9cf7d5a87f13febf4e7d97/5B753E1F/t51.2885-15/e35/26866951_335026793666205_6102243513582223360_n.jpg");

            postList.add(post);
        }

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class MyClickHandlers {

        Context context;

        public MyClickHandlers(Context context) {
            this.context = context;
        }

        public void onProfileFabClicked(View view) {
            Toast.makeText(getApplicationContext(), "Profile FAB is clicked!", Toast.LENGTH_LONG).show();
        }

        public boolean onProfileImageLongPressed(View view) {
            Toast.makeText(getApplicationContext(), "Profile image long pressed!", Toast.LENGTH_LONG).show();
            return false;
        }


        public void onFollowersClicked(View view) {
            Toast.makeText(context, "Followers is clicked!", Toast.LENGTH_SHORT).show();
        }

        public void onFollowingClicked(View view) {
            Toast.makeText(context, "Following is clicked!", Toast.LENGTH_SHORT).show();
        }

        public void onPostsClicked(View view) {
            Toast.makeText(context, "Posts is clicked!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
