package ru.unfortunately.school.abstractionsunittestsandmore.presentation.presenter;

import java.lang.ref.WeakReference;
import java.util.List;

import androidx.annotation.NonNull;
import ru.unfortunately.school.abstractionsunittestsandmore.data.model.InstalledPackageModel;
import ru.unfortunately.school.abstractionsunittestsandmore.data.repository.PackageInstallRepository;
import ru.unfortunately.school.abstractionsunittestsandmore.presentation.view.IMainActivity;

public class MainPresenter {

    private WeakReference<IMainActivity> mMainActivityWeakReference;

    private PackageInstallRepository mPackageInstallRepository;

    public MainPresenter(@NonNull IMainActivity mainActivity, @NonNull PackageInstallRepository packageInstallRepository){
        mMainActivityWeakReference = new WeakReference<>(mainActivity);
        mPackageInstallRepository = packageInstallRepository;
    }

    public void loadData(){
        if(mMainActivityWeakReference.get() != null){
            mMainActivityWeakReference.get().showProgress();
        }
        List<InstalledPackageModel> data = mPackageInstallRepository.getData(true);

        if(mMainActivityWeakReference.get() != null){
            mMainActivityWeakReference.get().hideProgress();
            mMainActivityWeakReference.get().showData(data);
        }
    }
}
