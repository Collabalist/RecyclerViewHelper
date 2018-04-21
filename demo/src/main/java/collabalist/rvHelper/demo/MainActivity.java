package collabalist.rvHelper.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import collabalist.rvHelper.Callbacks.ClickableBind;
import collabalist.rvHelper.Callbacks.ItemBinder;
import collabalist.rvHelper.RvHelper;
import collabalist.rvHelper.demo.databinding.ItemRvBinding;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<CustomItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        list.add(new CustomItem("Name1", "1"));
        list.add(new CustomItem("Name2", "2"));
        list.add(new CustomItem("Name3", "3"));
        list.add(new CustomItem("Name4", "4"));
        list.add(new CustomItem("Name5", "5"));
        list.add(new CustomItem("Name6", "6"));
        list.add(new CustomItem("Name7", "7"));
        list.add(new CustomItem("Name8", "8"));
        list.add(new CustomItem("Name9", "9"));
        list.add(new CustomItem("Name10", "10"));
        list.add(new CustomItem("Name11", "11"));

//        RvHelper.with(MainActivity.this)
//                .into(recyclerView)
//                .setListingOrientation(RvHelper.VERTICAL, false)
//                .setLayoutRes(R.layout.item_rv)
//                .setListing(list)
//                .build(new ItemBinder<CustomItem, ItemRvBinding>() {
//                    /**
//                     * onBind
//                     *
//                     * @param position
//                     * @param item
//                     * @param holder
//                     */
//                    @Override
//                    public void onBind(int position, CustomItem item, ItemRvBinding holder) {
//                        holder.name.setText(item.name);
//                        holder.age.setText(item.age);
//                    }
//                });

        RvHelper.with(MainActivity.this)
                .into(recyclerView)
                .setListingOrientation(RvHelper.VERTICAL, false)
                .setLayoutRes(R.layout.item_rv)
                .setListing(list)
                .setClickableViews(R.id.plus, R.id.minus)
                .build(new ClickableBind<CustomItem, ItemRvBinding>() {

                    @Override
                    public void onBind(int position, CustomItem item, ItemRvBinding holder) {
                        holder.name.setText(item.name);
                        holder.age.setText(item.age);
                    }

                    @Override
                    public void onClick(View view, CustomItem model, int position) {
                        switch (view.getId()) {
                            case R.id.minus:
                                list.remove(position);
                                recyclerView.getAdapter().notifyItemRemoved(position);
                                break;
                            case R.id.plus:
                                list.add(position, model);
                                recyclerView.getAdapter().notifyItemInserted(position);
                                break;
                        }
                    }
                });
    }
}
