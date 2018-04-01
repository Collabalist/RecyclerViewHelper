package collabalist.rvHelper.Callbacks;

/**
 *
 * @param <M> stands for Model class
 * @param <B> stands for Binder class
 */
public interface ItemBinder<M, B> {
    /**
     * onBind
     *
     * @param position
     * @param item
     * @param holder
     */
    void onBind(int position, M item, B holder);
}