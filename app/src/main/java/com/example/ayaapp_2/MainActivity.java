package com.example.ayaapp_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ImageView artworkImage;
    private TextView artworkTitle, artworkArtist;
    private Button prevButton, nextButton;

    private int currentIndex = 0;

    private int[] images = {R.drawable.art1, R.drawable.art2, R.drawable.art3}; // Добавь свои изображения
    private String[] titles = {"Песец", "Енот", "Выдра"};
    private String[] artists = {"Красивое белое «пальто» арктической лисицы может навести на мысль, что это нежное и  избалованное существо.",
            "Еноты могут быть самыми симпатичными зверями из тех, что когда-либо рылись в мусорных баках.",
            "Хотя в дикой природе выдры - хищники, они уже заработали репутацию забавных, эмоциональных и крайне фотогеничных милашек.»"};

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        artworkImage = findViewById(R.id.artworkImage);
        artworkTitle = findViewById(R.id.artworkTitle);
        artworkArtist = findViewById(R.id.artworkArtist);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);

        updateArtwork();

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex > 0) {
                    currentIndex--;
                    updateArtwork();
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex < images.length - 1) {
                    currentIndex++;
                    updateArtwork();
                }
            }
        });
    }
    private void updateArtwork() {
        artworkImage.setImageResource(images[currentIndex]);
        artworkTitle.setText(titles[currentIndex]);
        artworkArtist.setText(artists[currentIndex]);
    }
}





