package me.xiu.xiu.campusvideo.work.presenter.fragment;

import me.xiu.xiu.campusvideo.common.Presenter;
import me.xiu.xiu.campusvideo.work.viewer.fragment.ClassifyViewer;

/**
 * Created by felix on 16/3/20.
 */
public class ClassifyPresenter extends Presenter<ClassifyViewer> {
    private static final String TAG = "ClassifyPresenter";

    public ClassifyPresenter(ClassifyViewer viewer) {
        super(viewer);
    }

    public void loadClassify() {
//        subscribe(Observable
//                .create(new Observable.OnSubscribe<Classify>() {
//                    @Override
//                    public void call(Subscriber<? super Classify> subscriber) {
//                        try {
//                            ClassifyDao classifyDao = DatabaseHelper.getDao(DaoAlias.CLASSIFY);
//
//                            subscriber.onNext(classifyDao.queryBuilder().where().eq(Classify.FIELD_NAME, "电影").queryForFirst());
//
//                            Classify classify = new Classify(1, "电影", "1212");
//                            classifyDao.createIfNotExists(classify);
//
//                        } catch (Exception e) {
//                            subscriber.onError(e);
//                        }
//                        subscriber.onCompleted();
//                    }
//                })
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<Classify>() {
//                    @Override
//                    public void call(Classify classify) {
//                        if (classify != null) {
//                            Toast.makeText(getViewer().getContext(), classify.getName(), Toast.LENGTH_LONG).show();
//                        }
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        Logger.w(TAG, throwable);
//                    }
//                }));
    }
}
