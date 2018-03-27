package com.strivestay.gridlayoutdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.view.Gravity;
import android.widget.TextView;
/**
 * GridLayout示例
 * @author StriveStay
 * @date 2018/3/27
 */
public class MainActivity extends AppCompatActivity {

    private String[] mStrings = {"0","AC","退格","/","*","7","8","9","—","4","5","6","+","1","2","3","=","%","0","."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // xml布局
//        setContentView(R.layout.activity_main);

        // 动态添加
        setContentView(R.layout.activity_main2);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.grid_layout);

        // 6行   4列
        gridLayout.setColumnCount(4);
        gridLayout.setRowCount(6);

        for (int i = 0; i < mStrings.length; i++) {
            TextView textView = new TextView(this);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width =0;
            params.height =0;

            if(i == 0){
                // 设置行列下标， 所占行列  ，比重
                // 对应： layout_row  , layout_rowSpan , layout_rowWeight
                // 如下代表： item坐标（0,0）， 占 1 行，比重为 3 ； 占 4 列，比重为 1
                params.rowSpec = GridLayout.spec(0,1,3f);
                params.columnSpec = GridLayout.spec(0,4,1f);

                textView.setGravity(Gravity.BOTTOM|Gravity.RIGHT);
            }else{
                // 设置行列下标，和比重
                params.rowSpec = GridLayout.spec((i+3)/4,1f);
                params.columnSpec = GridLayout.spec((i+3)%4,1f);

                // 背景
                textView.setBackgroundColor(Color.WHITE);

                // 字体颜色
                if("AC".equals(mStrings[i])){
                    textView.setTextColor(Color.parseColor("#f68904"));
                }

                if("=".equals(mStrings[i])){
                    textView.setBackgroundColor(Color.parseColor("#f68904"));
                    textView.setTextColor(Color.WHITE);
                    params.rowSpec = GridLayout.spec((i+3)/4,2,1f);
                }

                // 居中显示
                textView.setGravity(Gravity.CENTER);

                // 设置边距
                params.setMargins(2,2,2,2);
            }

            // 设置文字
            textView.setText(mStrings[i]);

            // 添加item
            gridLayout.addView(textView,params);
        }
    }
}
