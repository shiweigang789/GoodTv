package com.duoduolicai360.goodtv.mvp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.duoduolicai360.goodtv.R;
import com.duoduolicai360.goodtv.common.Constants;
import com.duoduolicai360.goodtv.mvp.fragment.AboutFragment;
import com.duoduolicai360.goodtv.mvp.fragment.FullRoomFragment;
import com.duoduolicai360.goodtv.mvp.fragment.LiveFragment;
import com.duoduolicai360.goodtv.mvp.fragment.LoginFragment;
import com.duoduolicai360.goodtv.mvp.fragment.RoomFragment;
import com.duoduolicai360.goodtv.mvp.fragment.SearchFragment;
import com.duoduolicai360.goodtv.mvp.fragment.WebFragment;
import com.king.base.util.LogUtils;

/**
 * Created by swg on 2017/9/21.
 */

public class ContentActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);

        swichFragment(getIntent());
    }

    public void swichFragment(Intent intent) {

        int fragmentKey = intent.getIntExtra(Constants.KEY_FRAGMENT, 0);
        switch (fragmentKey) {
            case Constants.ROOM_FRAGMENT:
                replaceFragment(RoomFragment.newInstance(intent.getStringExtra(Constants.KEY_UID)));
                break;
            case Constants.LIVE_FRAGMENT: {
                String title = intent.getStringExtra(Constants.KEY_TITLE);
                String slug = intent.getStringExtra(Constants.KEY_SLUG);
                boolean isTabLive = intent.getBooleanExtra(Constants.KEY_IS_TAB_LIVE, false);
                replaceFragment(LiveFragment.newInstance(title, slug, isTabLive));
                break;
            }
            case Constants.WEB_FRAGMENT: {
                String title = intent.getStringExtra(Constants.KEY_TITLE);
                String url = intent.getStringExtra(Constants.KEY_URL);
                replaceFragment(WebFragment.newInstance(url, title));
                break;
            }
            case Constants.LOGIN_FRAGMENT:
                replaceFragment(LoginFragment.newInstance());
                break;
            case Constants.ABOUT_FRAGMENT:
                replaceFragment(AboutFragment.newInstance());
                break;
            case Constants.FULL_ROOM_FRAGMENT:
                String uid = intent.getStringExtra(Constants.KEY_UID);
                String cover = intent.getStringExtra(Constants.KEY_COVER);
                replaceFragment(FullRoomFragment.newInstance(uid, cover));
                break;
            case Constants.SEARCH_FRAGMENT:
                replaceFragment(SearchFragment.newInstance());
                break;
            default:
                LogUtils.d("Not found fragment:" + Integer.toHexString(fragmentKey));
                break;
        }
    }

    public void replaceFragment(Fragment fragmnet){
        replaceFragment(R.id.fragmentContent,fragmnet);
    }

    public void replaceFragment(@IdRes int id, Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(id, fragment).commit();
    }

}
