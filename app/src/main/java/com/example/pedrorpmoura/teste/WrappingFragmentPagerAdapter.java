package com.example.pedrorpmoura.teste;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public abstract class WrappingFragmentPagerAdapter extends FragmentPagerAdapter {

    private int mCurrentPosition = -1;

    public WrappingFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * @param container View container (instance of {@link WrappingViewPager}))
     * @param position  Item position
     * @param object    {@link Fragment}
     */
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);

        if (!(container instanceof WrappingViewPager)) {
            throw new UnsupportedOperationException("ViewPager is not a WrappingViewPager");
        }


        Fragment fragment = (Fragment) object;
        WrappingViewPager pager = (WrappingViewPager) container;
        if (fragment != null && fragment.getView() != null) {
            if (position != mCurrentPosition) {
                mCurrentPosition = position;
            }
            pager.onPageChanged(fragment.getView());
        }
    }
}
