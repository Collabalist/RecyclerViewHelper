package collabalist.rvHelper.Helper;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import java.util.ArrayList;

import collabalist.rvHelper.Callbacks.ItemBinder;
import collabalist.rvHelper.Callbacks.ClickableBind;


public class RvAdapter<M, B> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    int res;
    ArrayList<M> list;
    public RecyclerView recyclerView;
    ClickHelper clickHelper;
    public ItemBinder itemBinder;
    Context mContext;

    /**
     * RvAdapter Constructor
     *
     * @param context
     * @param res
     * @param recyclerView
     */
    public RvAdapter(Context context, int res, RecyclerView recyclerView) {
        this.res = res;
        this.mContext = context;
        this.recyclerView = recyclerView;
        clickHelper = new ClickHelper(this.recyclerView, this);
    }

    /**
     * setListing
     *
     * @param listing
     * @return RvAdapter
     */
    public RvAdapter setListing(ArrayList<M> listing) {
        this.list = listing;
        return this;
    }


    int[] clickableIds;

    /**
     * setClickableViews
     *
     * @param ids
     * @return ClickHelper
     */
    public ClickHelper setClickableViews(int... ids) {
        this.clickableIds = ids;
        return clickHelper;
    }

    int[] checkableIds;

    /**
     * setCheckableView
     *
     * @param ids
     * @return ClickHelper
     */
    public ClickHelper setCheckableView(int... ids) {
        this.checkableIds = ids;
        return clickHelper;
    }

    /**
     * build
     *
     * @param itemBinder
     */
    public void build(ItemBinder itemBinder) {
        this.itemBinder = itemBinder;
        this.recyclerView.setAdapter(this);
    }

    /**
     * onCreateViewHolder
     *
     * @param parent
     * @param viewType
     * @return ViewHolder
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext).inflate(res, parent, false);
        final SimpleViewHolder viewHolder = new SimpleViewHolder(rootView);
        if (itemBinder instanceof ClickableBind) {
            if (clickableIds != null) {
                for (int clickableId : clickableIds) {
                    if (viewHolder.binding.getRoot().findViewById(clickableId) == null) {
                        Log.e("RvHelper", "Resource " + clickableId + " not Exist.");
                    } else
                        viewHolder.binding.getRoot().findViewById(clickableId).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ((ClickableBind) itemBinder).onClick(view, list.get(viewHolder.getAdapterPosition()),
                                        viewHolder.getAdapterPosition());
                            }
                        });
                }
            }
            if (checkableIds != null) {
                for (int checkableID : checkableIds) {
                    View view = viewHolder.binding.getRoot().findViewById(checkableID);
                    if (view == null) {
                        Log.e("RvHelper", "Resource " + checkableID + " not Exist.");
                    } else {
                        if (view instanceof CompoundButton) {
                            ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                                    ((ClickableBind) itemBinder).onCheckedChange(compoundButton,
                                            list.get(viewHolder.getAdapterPosition()),
                                            viewHolder.getAdapterPosition());
                                }
                            });
                        }
                    }
                }
            }
        }
        return viewHolder;
    }

    /**
     * onBindViewHolder
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        itemBinder.onBind(holder.getAdapterPosition(), list.get(position), (B) ((SimpleViewHolder) holder).binding);
    }

    /**
     * getItemCount
     *
     * @return list.size();
     */
    @Override
    public int getItemCount() {
        return list.size();
    }


    class SimpleViewHolder extends RecyclerView.ViewHolder {
        public ViewDataBinding binding;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}