package com.example.markopoloandroid;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RecordListActivity extends AppCompatActivity implements RecordListAdapter.OnItemClickListener {

    private RecyclerView recyclerViewRecords;
    private RecordListAdapter adapter;
    private List<Record> recordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_list);

        recyclerViewRecords = findViewById(R.id.recyclerViewRecords);
        recyclerViewRecords.setLayoutManager(new LinearLayoutManager(this));

        // Initialize your record list
        recordList = new ArrayList<>();
        recordList.add(new Record("Title 1", "Category 1", "Description 1", "Location 1"));
        recordList.add(new Record("Title 2", "Category 2", "Description 2", "Location 2"));

        adapter = new RecordListAdapter(recordList, this);
        recyclerViewRecords.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Record record) {
        // Handle item click (e.g., open details screen)
        Intent intent = new Intent(this, RecordDetailsActivity.class);
        intent.putExtra("title", record.getTitle());
        intent.putExtra("category", record.getCategory());
        intent.putExtra("description", record.getDescription());
        intent.putExtra("location", record.getLocation());
        startActivity(intent);
    }
}