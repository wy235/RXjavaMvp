package com.example.rxjavademo.touchEvent.scroview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.rxjavademo.R;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ScroViewActivity extends AppCompatActivity {

    private SimpAdapter adapter = null;
    private SimpAdapter adapter1 = null;
    private List<Object> list = new ArrayList<>();

    @BindView(R.id.mRecycleView)
    CustomRecycleView mRecycleView;
    @BindView(R.id.mRecycleView1)
    CustomRecycleView mRecycleView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scro_view);
        ButterKnife.bind(this);
        for (int i = 0; i < 16; i++) {
            list.add(new Object());
        }
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(manager);
        adapter = new SimpAdapter();
        mRecycleView.setAdapter(adapter);


        adapter.replaceData(list);

        adapter1 = new SimpAdapter();
        mRecycleView1.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView1.setAdapter(adapter1);
        adapter1.replaceData(list);
    }
}
