package com.beelancrp.bmwmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.beelancrp.bmwmvp.adapter.MainAdapter;
import com.beelancrp.bmwmvp.model.MainModel;
import com.beelancrp.bmwmvp.presenter.MainPresenter;
import com.beelancrp.bmwmvp.view.IMainView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainView{

    @BindView(R.id.main_list_view)
    ListView listView;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadNews();
    }

    @Override
    public void onNewsLoaded(@NotNull List<MainModel> list) {
        listView.setAdapter(new MainAdapter(this, list));
    }

    @Override
    public void onMoreNewsLoaded() {

    }

    @Override
    public void onLoadError() {
        Toast.makeText(this, "ERROR LOADING", Toast.LENGTH_LONG).show();
    }
}
