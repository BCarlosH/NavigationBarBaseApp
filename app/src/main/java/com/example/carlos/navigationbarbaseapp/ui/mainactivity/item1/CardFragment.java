package com.example.carlos.navigationbarbaseapp.ui.mainactivity.item1;


import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;

import com.example.carlos.navigationbarbaseapp.R;
import com.example.carlos.navigationbarbaseapp.utils.AppConstants;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;


@EFragment(R.layout.fragment_card)
public class CardFragment extends Fragment {

    @ViewById(R.id.card_view)
    protected CardView mCardView;

    @AfterViews
    public void initView() {
        mCardView.setMaxCardElevation(mCardView.getCardElevation() * AppConstants.MAX_ELEVATION);
    }


    public CardView getCardView() {
        return mCardView;
    }

}
