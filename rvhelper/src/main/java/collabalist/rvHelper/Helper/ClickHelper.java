package collabalist.rvHelper.Helper;

import android.support.v7.widget.RecyclerView;

import collabalist.rvHelper.Callbacks.ClickableBind;


/**
 * Created by deepak on 15/3/18.
 */

public class ClickHelper {
    RecyclerView recyclerView;
    RvAdapter adapter;

    /**
     * Constructor
     *
     * @param recyclerView
     * @param adapter
     */
    public ClickHelper(RecyclerView recyclerView, RvAdapter adapter) {
        this.recyclerView = recyclerView;
        this.adapter = adapter;

    }

    /**
     * build
     *
     * @param binder
     */
    public void build(ClickableBind binder) {
        adapter.itemBinder = binder;
        this.recyclerView.setAdapter(this.adapter);
    }
}
