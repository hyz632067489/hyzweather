package com.hyz.hyzweather.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hyz.hyzweather.presenter.BasePresenter;
import com.hyz.hyzweather.view.BaseActivity;


/**
 * Author: Othershe
 * Time:  2016/8/11 11:14
 */
public abstract class BaseMvpActivity<V, P extends BasePresenter<V>> extends BaseActivity {
    protected P mPresenter;

    protected abstract P initPresenter();

    protected abstract void fetchData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        mPresenter.attach((V) this);

        fetchData();
    }

    @Override
    protected void onDestroy() {
        mPresenter.detach();
        super.onDestroy();
    }
}
