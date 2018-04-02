package info.androidhive.databinding.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class User {
    String name;
    String email;
    String profileImage;
    String website;
    long numberOfPosts;
    long numberOfFollowers;
    long numberOfFollowing;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @BindingAdapter({"bind:profileImage"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(view);

        // If you consider Picasso, follow the below
        /*Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.placeholder)
                .into(view);*/
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public long getNumberOfPosts() {
        return numberOfPosts;
    }

    public void setNumberOfPosts(long numberOfPosts) {
        this.numberOfPosts = numberOfPosts;
    }

    public long getNumberOfFollowers() {
        return numberOfFollowers;
    }

    public void setNumberOfFollowers(long numberOfFollowers) {
        this.numberOfFollowers = numberOfFollowers;
    }

    public long getNumberOfFollowing() {
        return numberOfFollowing;
    }

    public void setNumberOfFollowing(long numberOfFollowing) {
        this.numberOfFollowing = numberOfFollowing;
    }
}
