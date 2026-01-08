package com.example.worldexplorer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class mainActivity extends AppCompatActivity {

    ListView listView;

    String[] names = {
            "Saudi Arabia",
            "Italy",
            "Japan",
            "Sudan",
            "Brazil",
            "France"
    };

    int[] images = {
            R.drawable.sa,
            R.drawable.it,
            R.drawable.ja,
            R.drawable.sud,
            R.drawable.br,
            R.drawable.fr
    };

    String[] info = {
            // Saudi Arabia
            "Saudi Arabia is known for its rich history, cultural heritage, and economic influence. "
                    + "It is home to Islam’s holiest cities, Mecca and Medina. The country is famous for its vast deserts, "
                    + "including the Rub’ al Khali (Empty Quarter), one of the largest sand deserts in the world. "
                    + "Saudi Arabia is a major global oil producer and plays a key role in world energy markets. "
                    + "Through Vision 2030, the Kingdom is rapidly developing in tourism, technology, and entertainment.",

            // Italy
            "Italy is famous for its art, architecture, and fascinating history. It was the center of the Roman Empire "
                    + "and the birthplace of the Renaissance. Italy is known for amazing food such as pizza, pasta, and gelato. "
                    + "The country is also home to luxury fashion brands, supercars like Ferrari and Lamborghini, and landmarks "
                    + "such as the Colosseum, the Leaning Tower of Pisa, and Venice’s canals.",

            // Japan
            "Japan is a world leader in technology, robotics, and innovation. It offers a unique blend of traditional culture "
                    + "and modern life. Japan is famous for anime, manga, sushi, samurai history, and cherry blossoms. "
                    + "It is known for cleanliness, punctuality, and advanced transportation such as the Shinkansen bullet train. "
                    + "Landmarks like Mount Fuji and ancient temples show Japan's cultural depth.",

            // Sudan
            "Sudan is rich in ancient history and archaeological treasures, with more pyramids than Egypt. "
                    + "It is home to the Nile River, fertile lands, and unique Nubian heritage. Sudan has a long history of "
                    + "trade, agriculture, and traditional crafts. Its cultural diversity includes many languages, traditions, "
                    + "and musical styles across the country.",

            // Brazil
            "Brazil is famous for its vibrant culture, music, and natural beauty. It is home to carnival, samba, "
                    + "and legendary football players. Brazil contains the Amazon Rainforest, the largest rainforest on Earth, "
                    + "known for its rich biodiversity. Cities like Rio de Janeiro are known for beaches, mountains, and the "
                    + "Christ the Redeemer statue.",

            // France
            "France is known for its art, literature, fashion, and gourmet cuisine. It is home to iconic landmarks such as "
                    + "the Eiffel Tower, the Louvre Museum, and Notre-Dame Cathedral. France has played a major role in world "
                    + "culture, philosophy, and science. It is also famous for luxury goods, beautiful architecture, and "
                    + "high-quality wine from its vineyards."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                names
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(mainActivity.this, countrydetailActivity.class);
                i.putExtra("name", names[position]);
                i.putExtra("image", images[position]);
                i.putExtra("info", info[position]);
                startActivity(i);
            }
        });
    }
}