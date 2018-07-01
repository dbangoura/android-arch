package fr.soat.androidarchi.features.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by DBANG on 07/07/2017.
 */

public class BaseActivity extends AppCompatActivity implements BaseView {

    private Handler mHandler;
    private ProgressDialogFragment mProgressDialogFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new Handler();
    }

    protected Handler getHandler() {
        return mHandler;
    }

    @Override
    public void onStop() {
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }

        super.onStop();
    }

    @Override
    public void showLoading() {
        getHandler().post(new Runnable() {
            @Override
            public void run() {
                mProgressDialogFragment = ProgressDialogFragment.newInstance();
                mProgressDialogFragment.show(getSupportFragmentManager(), ProgressDialogFragment.TAG);
            }
        });
    }

    @Override
    public void hideLoading() {
        getHandler().post(new Runnable() {
            @Override
            public void run() {
                if (mProgressDialogFragment != null) {
                    mProgressDialogFragment.dismissAllowingStateLoss();
                }
            }
        });
    }
}
