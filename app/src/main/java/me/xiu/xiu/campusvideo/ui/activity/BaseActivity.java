package me.xiu.xiu.campusvideo.ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import me.xiu.xiu.campusvideo.common.Presenter;
import me.xiu.xiu.campusvideo.common.Viewer;
import me.xiu.xiu.campusvideo.util.Logger;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by felix on 15/9/18.
 */
public abstract class BaseActivity<P extends Presenter> extends AppCompatActivity implements
        View.OnClickListener, Viewer, EasyPermissions.PermissionCallbacks {
    private static final String TAG = "BaseActivity";

    private AlertDialog mLoadingDialog;

    private P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = newPresenter();
        initialize(savedInstanceState);
    }

    private void initialize(Bundle savedInstanceState) {
        mLoadingDialog = new AlertDialog.Builder(this).create();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initToolbarBar();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        initToolbarBar();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        initToolbarBar();
    }

    /**
     * 初始化Toolbar
     */
    protected void initToolbarBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0);
        }
    }

    /**
     * 添加事件监听
     *
     * @param resIds
     */
    protected void addOnClickListener(int... resIds) {
        if (resIds == null) return;
        for (int id : resIds) {
            View v = findViewById(id);
            if (v != null)
                v.setOnClickListener(this);
        }
    }

    /**
     * 添加事件监听
     *
     * @param views
     */
    protected void addOnClickListener(View... views) {
        if (views == null) return;
        for (View v : views) {
            v.setOnClickListener(this);
        }
    }

    /**
     * 事件监听回调
     *
     * @param v
     */
    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Context getContext() {
        return this;
    }

    public P getPresenter() {
        if (mPresenter == null) {
            mPresenter = newPresenter();
        }
        return mPresenter;
    }

    @Override
    public void showToastMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToastMessage(int resId) {
        showToastMessage(getString(resId));
    }

    @Override
    public void showLoadingDialog() {
        mLoadingDialog.setMessage("加载中...");
        if (!mLoadingDialog.isShowing()) {
            mLoadingDialog.show();
        }
    }

    @Override
    public void showLoadingDialog(String mes) {
        mLoadingDialog.setMessage(mes);
        if (!mLoadingDialog.isShowing()) {
            showLoadingDialog();
        }
    }

    @Override
    public void showLoadingDialog(int resId) {
        mLoadingDialog.setMessage(getString(resId));
        if (!mLoadingDialog.isShowing()) {
            showLoadingDialog();
        }
    }

    @Override
    public void cancelLoadingDialog() {
        if (mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            try {
                mPresenter.disposeAll();
            } catch (Exception e) {
                Logger.w(TAG, e);
            }
        }
        super.onDestroy();
    }

    @Override
    public String obtainString(int resId) {
        return getString(resId);
    }

    public P newPresenter() {
        return null;
    }

    public void hideNavigationBar() {
        View decorView = getWindow().getDecorView();
        if (decorView != null) {
            int uiFlags = decorView.getSystemUiVisibility()
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

            if (Build.VERSION.SDK_INT >= 19) {
                uiFlags |= 0x00001000;
            } else {
                uiFlags |= View.SYSTEM_UI_FLAG_LOW_PROFILE;
            }
            decorView.setSystemUiVisibility(uiFlags);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }
}
