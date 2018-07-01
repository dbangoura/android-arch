package fr.soat.androidarchi.features.people_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import fr.soat.androidarchi.PeopleApplication;
import fr.soat.androidarchi.R;
import fr.soat.androidarchi.data.model.SimplifiedPeople;
import fr.soat.androidarchi.di.components.DaggerPeopleListComponent;
import fr.soat.androidarchi.di.modules.PeopleListModule;
import fr.soat.androidarchi.features.base.BaseActivity;
import fr.soat.androidarchi.features.people_detail.PeopleDetailActivity;
import fr.soat.androidarchi.utils.Constants;

public class PeopleListActivity extends BaseActivity implements PeopleListContract.View, PeopleItemCallback {

    @Inject
    public PeopleListContract.Presenter presenter;

    private RecyclerView mLiist;
    private PeopleListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_list);

        DaggerPeopleListComponent.builder()
                .appComponent(((PeopleApplication) getApplication()).getmAppComponent())
                .peopleListModule(new PeopleListModule())
                .build()
                .inject(this);

        mLiist = findViewById(R.id.people_list);
        mLiist.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new PeopleListAdapter(this);
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

    @Override
    public void onPeopleSelected(String name, int peopleId) {
        Intent intent = new Intent(this, PeopleDetailActivity.class);
        intent.putExtra(Constants.PEOPLE_NAME, name);
        intent.putExtra(Constants.PEOPLE_ID, peopleId);
        startActivity(intent);
    }
}
