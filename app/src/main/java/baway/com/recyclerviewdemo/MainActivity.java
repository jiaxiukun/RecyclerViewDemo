package baway.com.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        //listview的形式展示
        linearLayoutManager = new LinearLayoutManager(this);
        //gridview的形式展示
        gridLayoutManager = new GridLayoutManager(this, 3);
        //可以通过SetSpanSizeLookUp来自定义每个item占的列数
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

            @Override
            public int getSpanSize(int position) {
                return 3 - position % 3;
            }
        });

          recyclerview.setLayoutManager(gridLayoutManager);
        //瀑布流的形式
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerview.setLayoutManager(staggeredGridLayoutManager);

          recyclerview.setLayoutManager(linearLayoutManager);
        MyAdapter myAdapter = new MyAdapter();
        recyclerview.setAdapter(myAdapter);


        // GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);

    }

    public void onClick(View v) {
        //切换布局
        RecyclerView.LayoutManager layoutManager = recyclerview.getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        //if和e因为elseif是有先后顺序的，先判断范围小的，然后再判断范围大的，因为Gridlayoutmanager是继承LinearlayoutManager,
        //所以它本质也是Linearlayoutmanager,所以不能先判断是否是LinearLayoutMnanger,因为Linearlayoutmanager范围大
        if (layoutManager instanceof GridLayoutManager) {
            recyclerview.setLayoutManager(linearLayoutManager);
        } else if (layoutManager instanceof LinearLayoutManager) {
            recyclerview.setLayoutManager(gridLayoutManager);
        }
    }
}
