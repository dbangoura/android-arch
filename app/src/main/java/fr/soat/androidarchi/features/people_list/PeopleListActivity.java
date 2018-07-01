package fr.soat.androidarchi.features.people_list;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import fr.soat.androidarchi.R;
import fr.soat.androidarchi.data.model.SimplifiedPeople;
import fr.soat.androidarchi.features.base.BaseActivity;

public class PeopleListActivity extends BaseActivity implements PeopleListContract.View {

    PeopleListContract.Presenter presenter;

    private RecyclerView mLiist;
    private PeopleListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_list);

        presenter = new PeopleListPresenter();

        mLiist = findViewById(R.id.people_list);
        mLiist.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new PeopleListAdapter();
        mLiist.setAdapter(mAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onViewReady(this);
        presenter.getPeopleForPage(1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onViewDone();
    }

    @Override
    public void updatePeopleList(List<SimplifiedPeople> peopleList) {
        mAdapter.refresh(peopleList);
    }

    @Override
    public void displayErrorMessage() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }
}
