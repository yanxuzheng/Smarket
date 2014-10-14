package com.mobile.yanxu.smarket;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

/**
 * Created by yanxu on 10/09/2014.
 */
public class MeFragment extends Fragment {

	private List<Item> mHistoryList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.layout_my_info, container, false);

	    mHistoryList = LocalData.getHistoryLog();

	    // Create the list
	    ListView listViewPurchaseHistory = (ListView) rootView.findViewById(R.id.listViewPurchaseHistory);
	    listViewPurchaseHistory.setAdapter(new ItemAdapter(mHistoryList, inflater, false));

	    listViewPurchaseHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		    @Override
		    public void onItemClick(AdapterView<?> parent, View view, int position,
		                            long id) {
			    Intent ItemDetailsIntent = new Intent( getActivity(),ItemDetailsActivity.class);
			    ItemDetailsIntent.putExtra(LocalData.Item_INDEX, position);
			    startActivity(ItemDetailsIntent);
		    }
	    });
        return rootView;
    }
}
