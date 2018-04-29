package com.example.carlos.navigationbarbaseapp.ui.mainactivity.item1;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.carlos.navigationbarbaseapp.R;
import com.example.carlos.navigationbarbaseapp.data.model.Card;
import com.example.carlos.navigationbarbaseapp.utils.AppConstants;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;


@EFragment(R.layout.fragment_item1)
public class Item1Fragment extends Fragment {

    @ViewById(R.id.card_view_pager)
    protected ViewPager mCardViewPager;

    private CardPagerAdapter mCardPagerAdapter;


    @AfterViews
    public void initView() {
        initAdapter();
    }

    private void initAdapter() {
        setMockedData();
        mCardViewPager.setAdapter(mCardPagerAdapter);
        mCardViewPager.setOffscreenPageLimit(AppConstants.CARD_VIEW_OFF_SCREEN_PAGE_LIMIT);

    }

    private void setMockedData() {
        mCardPagerAdapter = new CardPagerAdapter();
        mCardPagerAdapter.addCardItem(new Card(R.string.card_tittle_1, R.string.mocked_card_body));
        mCardPagerAdapter.addCardItem(new Card(R.string.card_tittle_2, R.string.mocked_card_body));
        mCardPagerAdapter.addCardItem(new Card(R.string.card_tittle_3, R.string.mocked_card_body));
        mCardPagerAdapter.addCardItem(new Card(R.string.card_tittle_4, R.string.mocked_card_body));
    }

}
