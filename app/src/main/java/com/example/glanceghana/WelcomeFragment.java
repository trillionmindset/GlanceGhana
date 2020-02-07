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
public class WelcomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.welcome_layout, container, false);
        //        create an array list and add custom details to it
        ArrayList<Items> items = new ArrayList<>();
        items.add(new Items(R.drawable.akwaaba, "Akwaaba\n" +
                "Akwaaba \"is a term that will greet you everywhere you go in Ghana.\n" + "Ghana is known for the hospitality and friendliness of its people.\n" +
                "\n" + "Ghana offers a fascinating cultural experience that link the pass to present in a colorful way.\n" +
                "The centuries - old monuments along shores attain to Europe's, trading links with Africa and the Trans-Atlantic slave Trade.\n" +
                "\n" + "Nature lovers will be amazed at richness of the wildlife, which include elphants, monkeys, birds, butterflies and breathtaking views of varied landscape and unspoilt sandy beaches.\n" +
                "\n" + "Akwaaba to the golden experience. Explore Ghana, immerse yourself in our traditions and lifestyles.\n" +
                "\n" + "Have fun."));


        // gets the listView and populates it with the items array adapter we created earlier
        ListView listView = view.findViewById(R.id.welcomeListContents);
        ItemsArrayAdapter itemsAdapter = new ItemsArrayAdapter(getContext(), items);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//          when an item is clicked all the indicated attributes of the item clicked
//              are passed to a new item details intent
                Items welcomeItem = (Items) parent.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), ItemsDetails.class);
                intent.putExtra(getResources().getString(R.string.intentshort), welcomeItem.getshortItemDescription());
                intent.putExtra(getResources().getString(R.string.intentlong), welcomeItem.getlongItemDescription());
                intent.putExtra(getResources().getString(R.string.intentsimage), welcomeItem.getItemImage());

                startActivity(intent);
            }
        });

        return view;
    }
}