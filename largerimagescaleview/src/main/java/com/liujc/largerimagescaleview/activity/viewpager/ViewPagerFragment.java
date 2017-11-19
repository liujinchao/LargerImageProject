package com.liujc.largerimagescaleview.activity.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liujc.largerimagescaleview.ImageSource;
import com.liujc.largerimagescaleview.LargerImageScaleView;
import com.liujc.largerimagescaleview.R;

public class ViewPagerFragment extends Fragment {

    private static final String BUNDLE_ASSET = "asset";

    private String asset;

    public ViewPagerFragment() {
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.view_pager_page, container, false);

        if (savedInstanceState != null) {
            if (asset == null && savedInstanceState.containsKey(BUNDLE_ASSET)) {
                asset = savedInstanceState.getString(BUNDLE_ASSET);
            }
        }
        if (asset != null) {
            LargerImageScaleView imageView = (LargerImageScaleView)rootView.findViewById(R.id.imageView);
            imageView.setImage(ImageSource.asset(asset));
        }

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        View rootView = getView();
        if (rootView != null) {
            outState.putString(BUNDLE_ASSET, asset);
        }
    }

}
