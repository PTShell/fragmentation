package me.yokeyword.sample.demo_flow.ui.fragment.shop;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import me.yokeyword.fragmentation.anim.DefaultNoAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.sample.R;
import me.yokeyword.sample.demo_flow.base.MySupportFragment;
import me.yokeyword.sample.demo_flow.ui.fragment.CycleFragment;

/**
 * Created by YoKeyword on 16/2/9.
 */
public class ContentFragment extends MySupportFragment {
    private static final String ARG_MENU = "arg_menu";

    private TextView mTvContent;
    private Button mBtnNext;

    private String mMenu;

    public static ContentFragment newInstance(String menu) {

        Bundle args = new Bundle();
        args.putString(ARG_MENU, menu);

        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            mMenu = args.getString(ARG_MENU);
        }
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultNoAnimator();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTvContent = (TextView) view.findViewById(R.id.tv_content);
        mBtnNext = (Button) view.findViewById(R.id.btn_next);

        mTvContent.setText("Content:\n" + mMenu);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ???MsgFragment?????????????????? ??????MsgFragment??????
                if (getParentFragment() instanceof ShopFragment) {
                    ((ShopFragment) getParentFragment()).start(CycleFragment.newInstance(1));
                }
            }
        });
    }

    @Override
    public boolean onBackPressedSupport() {
        // ContentFragment???ShopFragment????????????Fragment,????????????????????????????????????
        return super.onBackPressedSupport();
    }
}
