package com.example.administrator.unreadedappicon;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button normal,unreaded;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        normal = findViewById(R.id.normal);
        unreaded = findViewById(R.id.unreaded);
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeIcon("com.example.administrator.unreadedappicon.MainActivity");
            }
        });
        unreaded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeIcon("com.example.administrator.unreadedappicon.MainAliasActivity");
            }
        });
    }

    public void changeIcon(String activityPath) {
        PackageManager pm = getPackageManager();
        pm.setComponentEnabledSetting(getComponentName(),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        pm.setComponentEnabledSetting(new ComponentName(this, activityPath),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);


        //重启桌面 加速显示
    }
}
