package ru.unfortunately.school.abstractionsunittestsandmore.presentation.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import ru.unfortunately.school.abstractionsunittestsandmore.data.model.InstalledPackageModel;
import ru.unfortunately.school.abstractionsunittestsandmore.data.repository.PackageInstallRepository;
import ru.unfortunately.school.abstractionsunittestsandmore.presentation.view.IMainActivity;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    private IMainActivity mMainActivity;

    @Mock
    private PackageInstallRepository mPackageInstallRepository;

    private MainPresenter mMainPresenter;


    @Before
    public void setUp() throws Exception{
        mMainPresenter = new MainPresenter(mMainActivity, mPackageInstallRepository);
    }

    @Test
    public void testLoadData() {
        mMainPresenter.loadData(true, 0);
        verify(mMainActivity).showProgress();
    }

    private List<InstalledPackageModel> createTestData(){
        List<InstalledPackageModel> testData = new ArrayList<>();
        testData.add(new InstalledPackageModel("Sberbank", "Package", null, false));
        testData.add(new InstalledPackageModel("Test", "TPackage", null, true));
        return testData;
    }
}