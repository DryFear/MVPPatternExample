package ru.unfortunately.school.abstractionsunittestsandmore.presentation.view;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.unfortunately.school.abstractionsunittestsandmore.R;
import ru.unfortunately.school.abstractionsunittestsandmore.data.model.InstalledPackageModel;
import ru.unfortunately.school.abstractionsunittestsandmore.data.repository.PackageInstallRepository;
import ru.unfortunately.school.abstractionsunittestsandmore.presentation.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    private static final String TAG = "SOMETAG!!!!";
    private RecyclerView mRecyclerView;
    private FrameLayout mProgressFrameLayout;
    private MainPresenter mMainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        providePresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMainPresenter.loadData();
    }

    private void providePresenter() {
        PackageInstallRepository packageInstallRepository =
                new PackageInstallRepository(this);
        mMainPresenter = new MainPresenter(this, packageInstallRepository);
    }

    private void initViews() {
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        mRecyclerView = findViewById(R.id.recycler_view);
        mProgressFrameLayout = findViewById(R.id.progress_frame_layout);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void showProgress() {
        mProgressFrameLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressFrameLayout.setVisibility(View.GONE);
    }

    @Override
    public void showData(@NonNull List<InstalledPackageModel> models) {
        PackageInstalledAdapter adapter = new PackageInstalledAdapter(models);
        mRecyclerView.setAdapter(adapter);
    }
}
