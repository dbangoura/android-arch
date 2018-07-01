package fr.soat.androidarchi.features.base;

public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V> {

    private V view;

    @Override
    public void onViewReady(V view) {
        this.view = view;
    }

    @Override
    public void onViewDone() {
        this.view = null;
    }

    @Override
    public V getView() {
        return view;
    }
}
