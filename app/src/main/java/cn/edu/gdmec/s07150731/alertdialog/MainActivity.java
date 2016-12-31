package cn.edu.gdmec.s07150731.alertdialog;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1= (TextView) this.findViewById(R.id.textView);
        Button btn1= (Button) findViewById(R.id.button);
        Button btn2= (Button) findViewById(R.id.button2);
        Button btn3= (Button) findViewById(R.id.button3);
        Button btn4= (Button) findViewById(R.id.button4);
        Button btn5= (Button) findViewById(R.id.button5);
        Button btn6= (Button) findViewById(R.id.button6);
        Button btn7= (Button) findViewById(R.id.button7);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;

                }

            }
        };
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
    }
    public void dialog1(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确定退出吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listenter1= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog,int which) {
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    dialog.dismiss();
                    MainActivity.this.finish();
                } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listenter1);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listenter1);
        dialog.show();

    }
    public void dialog2() {
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你平时忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener listenter2 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "";
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        str="平时轻松";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str="平时很忙";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str="平时一般";
                        break;
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"不忙",listenter2);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"忙碌",listenter2);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"一般",listenter2);
        dialog.show();
    }
    public void dialog3(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入");
        dialog.setMessage("你平时忙吗");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tedit=new EditText(this);
        dialog.setView(tedit);
        DialogInterface.OnClickListener listenter3=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是："+tedit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listenter3);
        dialog.show();
    }
    public void dialog4(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bselect[]=new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mlistenter=new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bselect[which]=isChecked;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,null,mlistenter);
        dialog=builder.create();
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener listenter4=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了：";
                for (int i=0;i<bselect.length;i++) {
                    if (bselect[i]) {
                        str=str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listenter4);
        dialog.show();
    }
    public void dialog5(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bselect[]=new boolean[item.length];
        DialogInterface.OnClickListener slistenter= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                bselect[which]=true;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,slistenter);
        dialog=builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener listenter5= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了：";
                for (int i=0;i<item.length;i++) {
                    if (bselect[i]) {
                        str = str + "\n" + item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listenter5);
        dialog.show();
    }
    public void dialog6(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bselect[]=new boolean[item.length];
        DialogInterface.OnClickListener slistenter= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了："+item[which];
                tv1.setText(str);
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setItems(item,slistenter);
        dialog=builder.create();
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener listenter6= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listenter6);
        dialog.show();
    }
    public void dialog7(){
        LayoutInflater inflater=getLayoutInflater();
        View layout=inflater.inflate(R.layout.diydialog,null);
        final EditText tedit= (EditText) findViewById(R.id.textView);
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener listenter7= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是："+tedit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listenter7);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listenter7);
        dialog.show();
    }
}

