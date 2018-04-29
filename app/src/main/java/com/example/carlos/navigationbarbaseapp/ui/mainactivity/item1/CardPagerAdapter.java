package com.example.carlos.navigationbarbaseapp.ui.mainactivity.item1;

import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.carlos.navigationbarbaseapp.R;
import com.example.carlos.navigationbarbaseapp.data.model.Card;
import com.example.carlos.navigationbarbaseapp.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

public class CardPagerAdapter extends PagerAdapter {


    private List<CardView> mViews;
    private List<Card> mData;
    private float mBaseElevation;

    public CardPagerAdapter() {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
    }

    public void addCardItem(Card item) {
        mViews.add(null);
        mData.add(item);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.fragment_card, container, false);
        container.addView(view);
        bind(mData.get(position), view);
        CardView cardView = view.findViewById(R.id.card_view);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * AppConstants.MAX_ELEVATION);
        mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(Card item, View view) {
        TextView titleTextView = view.findViewById(R.id.card_tittle);
        TextView contentTextView = view.findViewById(R.id.card_body);
        titleTextView.setText(item.getTittle());
        contentTextView.setText(item.getBody());
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

}
