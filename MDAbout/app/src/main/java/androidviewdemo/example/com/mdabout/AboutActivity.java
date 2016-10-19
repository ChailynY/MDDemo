package androidviewdemo.example.com.mdabout;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class AboutActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    private RecyclerView recycleView;

    private List<String> mDatas =new ArrayList<String>();
    private CoordinatorLayout parentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        initData();
        initView();

    }

    private void initData() {
        for (int i =0;i<22;i++){
            mDatas.add("第"+i+"个条目");
        }

    }

    private void initView() {

        parentView = (CoordinatorLayout) findViewById(R.id.parentView);
//        recycleView= (RecyclerView) findViewById(R.id.recycleView);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mCollapsingToolbarLayout.setTitle(getString(R.string.app_name));

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        recycleView.setLayoutManager(new GridLayoutManager(MainActivity.this,3));
//        recycleView.setAdapter(new RecycleViewAdapter(mDatas,MainActivity.this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.menu_share:

                //这里使用的是系统的
             /*   Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"share");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                MainActivity.this.startActivity(
                        Intent.createChooser(intent, "share"));*/

                Snackbar.make(parentView, "hahahaah", Snackbar.LENGTH_INDEFINITE).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
