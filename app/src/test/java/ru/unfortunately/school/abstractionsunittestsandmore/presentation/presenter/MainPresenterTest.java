package ru.unfortunately.school.abstractionsunittestsandmore.presentation.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import ru.unfortunately.school.abstractionsunittestsandmore.data.repository.PackageInstallRepository;
import ru.unfortunately.school.abstractionsunittestsandmore.presentation.view.IMainActivity;

import static org.junit.Assert.*;

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
        mMainPresenter.loadData();

        Mockito.verify(mMainActivity).showProgress();
    }
}