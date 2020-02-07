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
public class HomeFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_layout, container, false);

//        create an array list and add custom details to it
        ArrayList<Items> items = new ArrayList<>();
        items.add(new Items(R.drawable.osu_castle, "Osu Castle", "Ghana is kwown with amazing natural resources"));
        items.add(new Items(R.drawable.kakum, "Adventure", "Are you curious to know more about how slavery want carried out in West Africa? If Yes, then join Accra Luxury Tour for a one-day memorable experience in Ghana’s historical region, the Central Region. The tour will equip you with the narratives of how slaves bought from Salaga Market in the former Northern Territory were traded right from Ancestral River Park before they are send to the castles.\n"));

        items.add(new Items(R.drawable.nkrumah, "Ecotourism","Indulge yourself in the breathtaking views of Ghana & Togoland atop mountain Afadjato, the highest mountain in Ghana. Do not miss our comprehensive historical tour of Cape Coast. A memorable visit to the slave dungeons , some castles of West Africa and museums chronicling the historical slave trades await you.\n" +
                "You could also visit the Volta Region to swim under the majestic Wli Waterfalls, explore aqua tourism of Ada and it’s environ, including the boat & canoe rides on Lake Volta. \n" +
                "Travel over 200 km to explore the Ashanti kingdom in Kumasi and if you are an animal lover, Safari tour to Mole Park will delight you.\n"));

        items.add(new Items(R.drawable.larabanga, "Larabanga Mosque","Lababanga Mosque was before the settlers without a sole builder, which was believed to be there centuries ago"));
        items.add(new Items(R.drawable.boti, "Boti Fall","A visit to the Boti Water Falls is an adventure you will never regret."));
        items.add(new Items(R.drawable.elephant, "Safari Tour","Mole National park is located in the Northen Region of Ghana, with an amazing Animals; Elephants, Dears, Crocodiles, Monkeys etc.. It will amaze you to in the seeing of an elephant called peoples friend, very friendly and down to earth"));
        items.add(new Items(R.drawable.paga, "Paga Crocodile Pond","If you are an animal lover, the Ghana is the right place to be"));
        items.add(new Items(R.drawable.zebra, "Animals","If you are an animal lover, the Ghana is the right place to be"));
        items.add(new Items(R.drawable.monkey, "Monkey Sanctuary","If you are an animal lover, the Ghana is the right place to be"));
        items.add(new Items(R.drawable.forest, "Forest","Great Vegetation, with natural air if you are the forest lover type"));
        items.add(new Items(R.drawable.dance, "Dance","Damba Festival is mostly celebrated by the people of the North, Tamale and Wa"));
        items.add(new Items(R.drawable.culture, "Culture","Ghana is full of Amazing cultural festivals, which attract people from different countries. Visit Ghana and take part in some of festivals, you will dance, drink and entertain yourself to the fullest. Ghana is noted to have rich cultural activities, the Ashanti regional capital, Kumasi. Yes, the Ashanti Kingdom is the biggest kingdom in Africa with it unique culture of excellence. The City has some unique ancient buildings with a greener environment. For a unique blend of historical and contemporary cultural experience, then join Accra Luxury Tour for a two-day cultural tour in Kumasi. Interesting places to visit\n" +
                "\n"));
        items.add(new Items(R.drawable.art, "Arts and Craft","Ghanaians are creative people using indigenous creative ideas to create things from wood, sand stones and others. You can find some of these creations at the Art Gallery"));



// gets the listView and populates it with the items array adapter we created earlier
        ListView listView = view.findViewById(R.id.homeListContents);
        ItemsArrayAdapter itemsAdapter = new ItemsArrayAdapter(getContext(), items);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                when an item is clicked all the indicated attributes of the item clicked
//                are passed to a new item details intent
                Items homeItem = (Items) parent.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), ItemsDetails.class);
                intent.putExtra(getResources().getString(R.string.intentshort), homeItem.getshortItemDescription());
                intent.putExtra(getResources().getString(R.string.intentlong), homeItem.getlongItemDescription());
                intent.putExtra(getResources().getString(R.string.intentsimage), homeItem.getItemImage());


                startActivity(intent);
            }
        });

        return view;
    }
}