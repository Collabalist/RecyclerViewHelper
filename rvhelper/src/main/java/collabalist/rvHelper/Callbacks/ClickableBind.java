package collabalist.rvHelper.Callbacks;

import android.view.View;

public abstract class ClickableBind<M, B> implements ItemBinder<M, B> {

    /**
     * onClick
     *
     * @param view
     * @param model
     * @param position
     */
    public void onClick(View view, M model, int position) {

    }

    /**
     * onCheckedChange
     *
     * @param view
     * @param model
     * @param position
     */
    public void onCheckedChange(View view, M model, int position) {

    }
}