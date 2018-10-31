package io.techery.sample.multi;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.techery.celladapter.Cell;
import io.techery.celladapter.select.SelectableCellAdapter;
import io.techery.celladapter.select.mode.MultiSelectionManager;
import io.techery.sample.DividerItemDecoration;
import io.techery.sample.R;

public class MultiChoiceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SelectableCellAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this));

        MultiSelectionManager multiSelectionManager = new MultiSelectionManager();
        adapter = new SelectableCellAdapter(this, multiSelectionManager);
        adapter.registerCell(MultiChoiceModel.class, MultiChoiceCell.class, new Cell.Listener<MultiChoiceModel>() {
            @Override
            public void onCellClicked(MultiChoiceModel multiChoiceModel) {

            }
        });
        recyclerView.setAdapter(adapter);

        List items = new ArrayList();
        for (int i = 0; i <= 33; i++) {
            items.add(new MultiChoiceModel(String.format("Multi select %d", i)));
        }

        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }
}