package com.example.uiwidgettest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;  //ListView子项布局的id

    /**
     * 重写了父类的一组构造函数， 用于将上下文、 ListView子项布局的id和数据都传递进来。
     * @param context
     * @param textViewResourceId
     * @param objects
     */
    public FruitAdapter(Context context, int textViewResourceId,
                        List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    /**
     * 这个方法在每个子项被滚动到屏幕内的时候会被调用。
     * 获得Fruit类的对象，将其相关的内容显示到屏幕
     * @param position
     * @param convertView ：用于将之前加载好的布局进行缓存， 以便之后可以进行重用。
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position); //得到当前项的Fruit实例
        View view;  //是
        ViewHolder viewHolder;
        //如果没有该列表项的view的缓存，新建一个，关联viewHolder
        if (convertView == null) {
            /*
            * 第一个参数：要加载的布局文件的id， 这里我们传入resourceId，即ListView子项布局的id
              第二个参数：给加载好的布局再添加一个父布局，
              第三个参数：指定成false ， 表示只让我们在父布局中声明的layout 属性生效， 但不会为这个View添加父布局，
              因为一旦View有了父布局之后， 它就不能再添加到ListView中了。*/
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent,
                    false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById
                    (R.id.fruit_image);  //列表子项中的imageView
            viewHolder.fruitName = (TextView) view.findViewById (R.id.fruit_name); //列表子项中的textView
            view.setTag(viewHolder); // 将ViewHolder存储在View中，下次要用可以直接getTag，不用再findById了
        }
        //如果有该列表项的view的缓存，直接用
        else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }
        //设置要显示的图片和文字，当前fruit实例
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }
    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }
}