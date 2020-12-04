package com.example.xuanfukuang;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("警告");
        builder.setMessage("世界上最遥远的距离是没有网");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("点了确定");
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("点了取消");
            }
        });

        builder.show();

    }

    //点击按钮弹出一个单选对话框
    public void click2(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择您喜欢的课程");
        final String items[] = {"android", "ios", "c", "C++", "html", "C#"};

//-1代表没有条目被选中
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //1.把选中的条目取出来
                String item = items[which];

                Toast.makeText(getApplicationContext(),item.toString(),Toast.LENGTH_LONG).show();


                //2.然后把对话框关闭
                dialog.dismiss();



            }
        });


        builder.show();


    }


    //多选对话框
    public void click3(View view) {
        System.out.println("点击了");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("请选择你喜欢吃的水果");

        final String items[] = {"香蕉", "黄瓜", "冬瓜", "哈密瓜", "梨", "柚子"};

        final boolean [] checkedItems ={true,false,false,false,false,true};

        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });

        //把选中的挑选出来
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuffer sb = new StringBuffer();
                //把选中的条目的数据取出来
                for (int i = 0; i <checkedItems.length ; i++) {
                    //判断下选中的
                    if(checkedItems[i]){
                        String fruit = items[i];
                        sb.append(fruit+"");
                    }
                    Toast.makeText(getApplicationContext(),sb.toString(),Toast.LENGTH_LONG).show();
                    //2.然后把对话框关闭
                    dialog.dismiss();
                }
            }
        });


        builder.show();
    }

    //进度加载框
    public void click4(View view) {

        final ProgressDialog dialog = new ProgressDialog(this);

        dialog.setTitle("正在玩命加载中...");
        //设置一下进度条的样式
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        //创建一个子线程
        new Thread(){
            @Override
            public void run() {
                //设置进度条的最大值
                dialog.setMax(100);

                //设置当前进度
                for (int i = 0; i <=100 ; i++) {
                    dialog.setProgress(i);
                    //睡眠一会儿
                    SystemClock.sleep(50);
                }
                //关闭对话框
                dialog.dismiss();
            }
        }.start();

        dialog.show();
    }


}
