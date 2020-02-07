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
public class HotelsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hotels_layout, container, false);
        //        create an array list and add custom details to it
        ArrayList<Items> items = new ArrayList<>();
        items.add(new Items(R.drawable.hotel,"Beautiful Hotels To Accommodate your Stay","Welcome to the beautiful city of Ghana, a unique journey through pleasant tours, business and amazing life. Enjoy an Environment that offers absolutely peace of mind, fulfilling all your lifestlye needs\n"));
        items.add(new Items(R.drawable.ala, "Accra Luxury Apartments","Accra Luxury Apartments is one of Ghana's beautiful hotels with different locations in East Legon, Cantonments etc.."));
        items.add(new Items(R.drawable.embassy, "Cozy Properties Ltd","Cozy Properties Limited is one of Ghana's beautiful hotels apartments in The Gallerty @ East Legon and Embassy Gardens at Cantonments closer to the American Embassy in Ghana. If you want to by a property they are still the right people to contact."));
        items.add(new Items(R.drawable.aurora, "Aurora Apartments","Aurora Apartments is one of Ghana's beautiful hotels located behind the Flag staff House of Ghana"));



// gets the listView and populates it with the items array adapter we created earlier
        ListView listView = view.findViewById(R.id.hotelsListContents);
        ItemsArrayAdapter itemsAdapter = new ItemsArrayAdapter(getContext(), items);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//          when an item is clicked all the indicated attributes of the item clicked
//              are passed to a new item details intent
                Items hotelsItem = (Items) parent.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), ItemsDetails.class);
                intent.putExtra(getResources().getString(R.string.intentshort), hotelsItem.getshortItemDescription());
                intent.putExtra(getResources().getString(R.string.intentlong), hotelsItem.getlongItemDescription());
                intent.putExtra(getResources().getString(R.string.intentsimage), hotelsItem.getItemImage());


                startActivity(intent);
            }
        });

        return view;
    }
}

