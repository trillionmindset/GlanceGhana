package com.example.glanceghana;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tips_layout, container, false);

        //        create an array list and add custom details to it
        ArrayList<Items> items = new ArrayList<>();
        items.add(new Items(R.drawable.map, "Ghana","Ghana officially the Republic of Ghana, is a country located along the Gulf of Guinea and Atlantic Ocean, in the subregion of West Africa. Spanning a land mass of 238,535 km2 (92,099 sq mi), Ghana is bordered by the Ivory Coast in the west, Burkina Faso in the north, Togo in the east and the Gulf of Guinea and Atlantic Ocean in the south.\n" +
                "\n"));
        items.add(new Items(R.drawable.map, "Ghana","Ghana officially the Republic of Ghana, is a country located along the Gulf of Guinea and Atlantic Ocean, in the subregion of West Africa. Spanning a land mass of 238,535 km2 (92,099 sq mi), Ghana is bordered by the Ivory Coast in the west, Burkina Faso in the north, Togo in the east and the Gulf of Guinea and Atlantic Ocean in the south.\n" +
                "\n"));
        items.add(new Items(R.drawable.map, "Ghana","Ghana officially the Republic of Ghana, is a country located along the Gulf of Guinea and Atlantic Ocean, in the subregion of West Africa. Spanning a land mass of 238,535 km2 (92,099 sq mi), Ghana is bordered by the Ivory Coast in the west, Burkina Faso in the north, Togo in the east and the Gulf of Guinea and Atlantic Ocean in the south.\n" +
                "\n"));


        // gets the listView and populates it with the items array adapter we created earlier
        ListView listView = view.findViewById(R.id.tipsListContents);
        ItemsArrayAdapter itemsAdapter = new ItemsArrayAdapter(getContext(), items);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//          when an item is clicked all the indicated attributes of the item clicked
//              are passed to a new item details intent
                Items tipsItem = (Items) parent.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), ItemsDetails.class);
                intent.putExtra(getResources().getString(R.string.intentshort), tipsItem.getshortItemDescription());
                intent.putExtra(getResources().getString(R.string.intentlong), tipsItem.getlongItemDescription());
                intent.putExtra(getResources().getString(R.string.intentsimage), tipsItem.getItemImage());

                startActivity(intent);
            }
        });

        return view;
    }
}
