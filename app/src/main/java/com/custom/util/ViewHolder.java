package com.custom.util;

import android.util.SparseArray;
import android.view.View;

/**
 * ViewHolder模式二次优化
 * 
 * @author frj
 * 
 */
public class ViewHolder {

	/**
	 * 
	 * @param view
	 *            布局文件的View
	 * @param id
	 *            控件的Id
	 * @return 控件的View
	 */
	public static <T extends View> T get(View view, int id) {
		SparseArray<View> array = (SparseArray<View>) view.getTag();
		if (array == null) {
			array = new SparseArray<View>();
			view.setTag(array);
		}
		View childView = array.get(id);
		if (childView == null) {
			childView = view.findViewById(id);
			array.put(id, childView);
		}
		return (T) childView;
	}
}
