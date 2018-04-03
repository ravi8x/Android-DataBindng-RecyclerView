package info.androidhive.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import info.androidhive.databinding.databinding.PostRowItemBinding;
import info.androidhive.databinding.model.Post;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder> {

    private List<Post> postList;
    private LayoutInflater layoutInflater;
    private PostRowItemBinding binding;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(PostRowItemBinding itemBinding) {
            super(itemBinding.getRoot());
        }
    }


    public PostsAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.post_row_item, parent, false);
        return new MyViewHolder(binding);
    }

    public void bind(Post post) {
        binding.setPost(post);
        binding.executePendingBindings();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        bind(postList.get(position));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
