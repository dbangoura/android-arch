package fr.soat.androidarchi.features.people_detail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import fr.soat.androidarchi.PeopleApplication;
import fr.soat.androidarchi.R;
import fr.soat.androidarchi.data.model.People;
import fr.soat.androidarchi.di.components.DaggerPeopleDetailComponent;
import fr.soat.androidarchi.di.modules.PeopleDetailModule;
import fr.soat.androidarchi.features.base.BaseActivity;
import fr.soat.androidarchi.utils.Constants;

public class PeopleDetailActivity extends BaseActivity implements PeopleDetailContract.View {

    @Inject
    public PeopleDetailContract.Presenter presenter;

    private TextView mNameTextView;
    private TextView mHeightTextView;
    private TextView mMassTextView;
    private TextView mHairColorTextView;
    private TextView mSkinColorTextView;
    private TextView mEyeColorTextView;
    private TextView mGenderTextView;

    private String mPeopleName;
    private int mPeopleId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_detail);

        Intent intent =  getIntent();
        if (intent != null) {
            mPeopleName = intent.getStringExtra(Constants.PEOPLE_NAME);
            mPeopleId = intent.getIntExtra(Constants.PEOPLE_ID,0);
        }

        DaggerPeopleDetailComponent.builder()
                .appComponent(((PeopleApplication) getApplication()).getmAppComponent())
                .peopleDetailModule(new PeopleDetailModule())
                .build()
                .inject(this);

        mNameTextView = findViewById(R.id.people_name);
        mHeightTextView = findViewById(R.id.people_height);
        mMassTextView = findViewById(R.id.people_mass);
        mHairColorTextView = findViewById(R.id.people_haircolor);
        mSkinColorTextView = findViewById(R.id.people_skincolor);
        mEyeColorTextView = findViewById(R.id.people_eyescolor);
        mGenderTextView = findViewById(R.id.people_gender);

        mNameTextView.setText(mPeopleName);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onViewReady(this);
        presenter.getPeopleDetail(mPeopleId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onViewDone();
    }

    @Override
    public void updatePeopleDetail(People people) {
        mNameTextView.setText(people.getName());
        mHeightTextView.setText(people.getHeight());
        mMassTextView.setText(people.getMass());
        mHairColorTextView.setText(people.getHairColor());
        mSkinColorTextView.setText(people.getSkinColor());
        mEyeColorTextView.setText(people.getEyeColor());
        mGenderTextView.setText(people.getGender());
    }

    @Override
    public void displayErrorMessage() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }
}
