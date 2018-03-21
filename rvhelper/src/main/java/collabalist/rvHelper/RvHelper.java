package collabalist.rvHelper;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import collabalist.rvHelper.Helper.RvAdapter;


/**
 * Created by deepak on 15/3/18.
 */

public class RvHelper {
    public static int VERTICAL = 1, HORIZONTAL = 2, GRID = 3, STAGGERED_VERTICAL = 4, STAGGERED_HORIZONTAL = 5;

    Context mContext;
    RecyclerView recyclerView;

    /**
     * Constructor
     *
     * @param context
     */
    public RvHelper(Context context) {
        this.mContext = context;
    }

    /**
     * with
     *
     * @param context
     * @return RvHelper
     */
    public static RvHelper with(Context context) {
        return new RvHelper(context);
    }

    public RvHelper into(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        return this;
    }

    /**
     * setListingOrientation
     *
     * @param type
     * @param reverseListing
     * @return RvHelper
     */
    public RvHelper setListingOrientation(int type, boolean reverseListing) {
        if (this.recyclerView != null && this.mContext != null) {
            switch (type) {
                case 1:
                    this.recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext,
                            LinearLayoutManager.VERTICAL,
                            reverseListing));
                    break;
                case 2:
                    this.recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext,
                            LinearLayoutManager.HORIZONTAL,
                            reverseListing));
                    break;
                default:
                    this.recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext,
                            LinearLayoutManager.VERTICAL,
                            reverseListing));
                    break;
            }
        }
        return this;
    }

    /**
     * setGridOrientation
     *
     * @param type
     * @param numOfColumn
     * @param reverseLayout
     * @return RvHelper
     */
    public RvHelper setGridOrientation(int type, int numOfColumn, boolean reverseLayout) {
        if (this.recyclerView != null && this.mContext != null) {
            switch (type) {
                case 3:
                    this.recyclerView.setLayoutManager(new GridLayoutManager(this.mContext,
                            numOfColumn,
                            GridLayoutManager.DEFAULT_SPAN_COUNT,
                            reverseLayout));
                    break;
                case 4:
                    this.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(numOfColumn,
                            StaggeredGridLayoutManager.VERTICAL));
                    break;
                case 5:
                    this.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(numOfColumn,
                            StaggeredGridLayoutManager.HORIZONTAL));
                    break;
                default:
                    this.recyclerView.setLayoutManager(new GridLayoutManager(this.mContext,
                            numOfColumn,
                            GridLayoutManager.DEFAULT_SPAN_COUNT,
                            reverseLayout));
                    break;
            }
        }
        return this;
    }

    /**
     * setLayoutRes
     *
     * @param res
     * @return RvAdapter
     */
    public RvAdapter setLayoutRes(int res) {
        RvAdapter adapter = new RvAdapter(this.mContext, res, this.recyclerView);
        return adapter;
    }

}
