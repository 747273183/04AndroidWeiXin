package com.example.wanglin.a04androidweixin;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RegisteActivity extends AppCompatActivity {
    private EditText et_name;
    private EditText et_pwd;

    private Spinner sp_classname;
    private RadioGroup rg_sex;


    private CheckBox cb_net;
    private CheckBox cb_chat;
    private CheckBox cb_sleep;
    private CheckBox cb_book;

    private String className;
    private String sex = "男";
    private ArrayList<String> hobbys = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registe);


        et_name = (EditText) findViewById(R.id.et_name);
        et_pwd = (EditText) findViewById(R.id.et_pwd);

        sp_classname = (Spinner) findViewById(R.id.sp_classname);
        rg_sex = (RadioGroup) findViewById(R.id.rg_sex);


        cb_net = (CheckBox) findViewById(R.id.cb_net);
        cb_chat = (CheckBox) findViewById(R.id.cb_chat);
        cb_sleep = (CheckBox) findViewById(R.id.cb_sleep);
        cb_book = (CheckBox) findViewById(R.id.cb_book);


        //当班级下拉列表被选择时
        sp_classname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                className = ((TextView) view).getText().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //当性别被选中时
        rg_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton rb = (RadioButton) findViewById(checkedId);
                if (rb.isChecked()) {
                    sex = rb.getText().toString();
                }
            }
        });

        //上网
        cb_net.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String hobby = buttonView.getText().toString();
                if (isChecked) {
                    hobbys.add(hobby);
                } else {
                    hobbys.remove(hobby);
                }
            }
        });
        //聊天
        cb_chat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String hobby = buttonView.getText().toString();
                if (isChecked) {
                    hobbys.add(hobby);
                } else {
                    hobbys.remove(hobby);
                }
            }
        });
        //睡觉
        cb_sleep.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String hobby = buttonView.getText().toString();
                if (isChecked) {
                    hobbys.add(hobby);
                } else {
                    hobbys.remove(hobby);
                }
            }
        });
        //看书
        cb_book.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String hobby = buttonView.getText().toString();
                if (isChecked) {
                    hobbys.add(hobby);
                } else {
                    hobbys.remove(hobby);
                }
            }
        });

    }

    public void ok(View view) {

        //获得账号和密码
        String name = et_name.getText().toString();
        String pwd = et_pwd.getText().toString();

        String show_content = "账号：" + name;
        show_content = show_content + "\n密码：" + pwd;
        show_content = show_content + "\n班级：" + className;
        show_content = show_content + "\n性别：" + sex;
        show_content = show_content + "\n爱好：" + hobbys;

        Toast.makeText(RegisteActivity.this, show_content, Toast.LENGTH_SHORT).show();
    }

}