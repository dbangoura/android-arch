package fr.soat.androidarchi.features.people_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.soat.androidarchi.R;
import fr.soat.androidarchi.data.model.SimplifiedPeople;

public class PeopleListAdapter extends RecyclerView.Adapter<PeopleListAdapter.PeopleListViewHolder> {

    List<SimplifiedPeople> items = new ArrayList<SimplifiedPeople>();

    public void refresh(List<SimplifiedPeople> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PeopleListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.people_list_item, parent, false);
        return new PeopleListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleListViewHolder holder, int position) {
        holder.mId.setText("" + items.get(position).getId());
        holder.mName.setText(items.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class PeopleListViewHolder extends RecyclerView.ViewHolder {
        private final TextView mId;
        private final TextView mName;

        public PeopleListViewHolder(View itemView) {
            super(itemView);
            mId = itemView.findViewById(R.id.people_item_id);
            mName = itemView.findViewById(R.id.people_item_name);
        }
    }
}
