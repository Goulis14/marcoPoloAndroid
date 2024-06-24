package com.example.markopoloandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecordDetailsActivity extends AppCompatActivity {

    private TextView tvTitle;
    private TextView tvCategory;
    private TextView tvDescription;
    private Button btnViewLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_details);

        // Initialize views
        tvTitle = findViewById(R.id.tvTitle);
        tvCategory = findViewById(R.id.tvCategory);
        tvDescription = findViewById(R.id.tvDescription);
        btnViewLocation = findViewById(R.id.btnViewLocation);

        // Get data from the intent
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String category = intent.getStringExtra("category");
            String description = intent.getStringExtra("description");
            final String location = intent.getStringExtra("location");

            // Set data to the views
            if (title != null) {
                tvTitle.setText(title);
            }
            if (category != null) {
                tvCategory.setText(category);
            }
            if (description != null) {
                tvDescription.setText(description);
            }

            // Show location button if location is available
            if (location != null && !location.isEmpty()) {
                btnViewLocation.setVisibility(View.VISIBLE);
                btnViewLocation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Open location in Google Maps
                        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(location));
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        if (mapIntent.resolveActivity(getPackageManager()) != null) {
                            startActivity(mapIntent);
                        }
                    }
                });
            }
        }
    }
}