package androidviewdemo.example.com.demo;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recycleView;
    private NavigationView navigationView;

    private List<String> mDatas = new ArrayList<String>();

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initData();
        navigationView = (NavigationView) findViewById(R.id.navigation);
        recycleView = (RecyclerView) findViewById(R.id.recycleView);
        recycleView.setLayoutManager(new GridLayoutManager(MainActivity2.this, 3));
        recycleView.setAdapter(new RecycleViewAdapter(mDatas, MainActivity2.this));

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navItem1:
                        Toast.makeText(MainActivity2.this,"用户信息",Toast.LENGTH_LONG).show();
                        break;

                    case R.id.navItem2:
                        Toast.makeText(MainActivity2.this,"充值记录",Toast.LENGTH_LONG).show();

                        break;
                    case R.id.navItem3:
                        Toast.makeText(MainActivity2.this,"我的收藏",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.navItem4:
                        Toast.makeText(MainActivity2.this,"浏览记录",Toast.LENGTH_LONG).show();
                        break;

                    default:
                        break;
                }
                return true;
            }
        });

        navigationView.setItemIconTintList(null);

        navigationView.setItemTextColor(getResources().getColorStateList(R.drawable.nav_menu_text_color, null));

    }

    private void initData() {
        for (int i = 0; i < 21; i++) {
            mDatas.add("第" + i + "个条目");
        }

    }

}
