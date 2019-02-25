package com.ht.app.base.utils;

/**
 * Created by ydd on 2017/4/20.
 */

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;

public class UIUtil {
    /**
     * 在activity 查找View
     *
     * @param context
     * @param id
     * @return
     */

    @SuppressWarnings("unchecked")
    public static <T extends View> T find(Activity context, int id) {
        return (T) context.findViewById(id);
    }

    /**
     * 在View中查找View
     *
     * @param view
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T extends View> T find(View view, int id) {
        return (T) view.findViewById(id);
    }

    /**
     * 在View中查找View ,并缓存 ViewHold,
     *
     * @param view
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T extends View> T get(View view, int id) {
        SparseArray<View> viewList = (SparseArray<View>) view.getTag();
        if (viewList == null) {
            viewList = new SparseArray<View>();
            view.setTag(viewList);
        }
        View childView = viewList.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewList.put(id, childView);
        }
        return (T) childView;
    }

}
