package custom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nguyentviet3513 on 1/12/2018.
 */

public class PageAdapter extends FragmentPagerAdapter {
    public List<Fragment> fragmentList = new ArrayList<>();

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int pos) {
        return fragmentList.get(pos);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
