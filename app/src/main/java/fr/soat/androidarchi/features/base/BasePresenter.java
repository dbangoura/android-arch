package fr.soat.androidarchi.features.base;

public interface BasePresenter<V> {
    void onViewReady(V view);
    void onViewDone();
    V getView();
}
