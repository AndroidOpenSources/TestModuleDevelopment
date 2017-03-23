package com.help.reward.shop.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.help.reward.shop.flip.IntentTransfer;

/**
 * Created by richsjeson on 17/3/23.
 */

public class BaseFragment extends Fragment {

    private IntentTransfer transfer;

    protected BaseFragment currentFragment;

    @Override
    public void onAttach(Activity activity) {

        if(activity instanceof IntentTransfer){
            transfer= (IntentTransfer) activity;
        }
        super.onAttach(activity);
    }

    public IntentTransfer getTransfer() {
        return transfer;
    }
    /**
     * @see <p>fragment切换</p>
     */
    public void changeFragment(BaseFragment fragment,BaseFragment toFragment,int fragmentid){

        FragmentTransaction fragmentTransaction = this.getChildFragmentManager().beginTransaction();;
        if (fragment != toFragment) {
            if (!toFragment.isAdded()) {
                Log.i("toFragment", "toFragment");
                fragmentTransaction.hide(fragment).add(fragmentid, toFragment).commitAllowingStateLoss();
            } else {
                fragmentTransaction.hide(fragment).show(toFragment).commitAllowingStateLoss();
            }
            currentFragment=toFragment;
        }
    }
}
