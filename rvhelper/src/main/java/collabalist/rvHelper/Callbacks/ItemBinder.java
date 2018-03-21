package collabalist.rvHelper.Callbacks;

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