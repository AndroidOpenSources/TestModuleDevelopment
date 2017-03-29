package com.help.reward.shop.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.help.reward.shop.Component;
import com.help.reward.shop.R;
import com.help.reward.shop.flip.IntentTransfer;
import com.help.reward.shop.module.BaseModule;

import java.lang.reflect.Field;

/**
 * Created by richsjeson on 17/3/23.
 */

public class BaseFragment extends Fragment{

    private IntentTransfer transfer;

    protected BaseFragment currentFragment;

    protected  int moduleId;

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

        FragmentTransaction fragmentTransaction = Component.getActivity().getSupportFragmentManager().beginTransaction();
        if (fragment != toFragment) {
            if (!toFragment.isAdded()) {
                Log.i("toFragment", "toFragment");
                fragmentTransaction.hide(fragment).add(fragmentid, toFragment).addToBackStack(null).commitAllowingStateLoss();
            } else {
                fragmentTransaction.hide(fragment).show(toFragment).commitAllowingStateLoss();
            }
            currentFragment=toFragment;
        }
    }

    public void detach() {
        try {
            FragmentTransaction fragmentTransaction = Component.getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.remove(Component.getActivity().getSupportFragmentManager().findFragmentById(R.id.frl_launcher_sh)).commitAllowingStateLoss();
            onDetach();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
