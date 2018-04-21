# RecyclerView Helper


# **RecyclerView Helper**

It is a simple Library which helps to reduce a bunch of code.

- No need to create Extra View Holders
- No need to create seperate Adapters
- No need to maintail any extra click callbacks
## **What to do then..?**
- Just create view xml's with data binding
- That's it.

**Installation**
Add it in your root build.gradle at the end of repositories:

    allprojects {
        repositories {
                   ...
                   maven { url 'https://jitpack.io' }
        }
    }

Add the dependency

    dependencies {
             compile 'com.github.Collabalist:RecyclerViewHelper:0.2'
    }


## **Usage**
- Without any click



   ```
 RvHelper.with(MainActivity.this)
            .into(recyclerView)
            .setListingOrientation(RvHelper.VERTICAL, 
                  false)
            .setLayoutRes(R.layout.item_rv)
            .setListing(list)
            .build(
              new ItemBinder<CustomItem, ItemRvBinding>() {
                /**
                 * onBind
                 *
                 * @param position
                 * @param item
                 * @param holder
                 */
                @Override
               public void onBind(int position,
                  CustomItem item, ItemRvBinding holder) {
                    holder.name.setText(item.name);
                    holder.age.setText(item.age);
                }
            });
```


- With click events


             RvHelper.with(MainActivity.this)
            .into(recyclerView)
            .setListingOrientation(RvHelper.VERTICAL, false)
            .setLayoutRes(R.layout.item_rv)
            .setListing(list)
            .setClickableViews(R.id.plus, R.id.minus)
            .build(new ClickableBind<CustomItem, ItemRvBinding>() {@Override
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



****
## **To-Do**
[ ] Multi view binding
[ ] include View Margin @Deepak S
