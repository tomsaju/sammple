package draft.vysh.vysakhdraft;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class TabActivity extends AppCompatActivity {

    private android.widget.ImageView banneriv;
    private android.support.v7.widget.Toolbar toolbar;
    private android.support.design.widget.TabLayout detailPageTab;
    private android.widget.TextView descriptiontext;
    private android.support.design.widget.CollapsingToolbarLayout collapsibletoolbar;
    private android.support.v4.view.ViewPager container;
    private android.support.design.widget.FloatingActionButton addexpenseButton;
    private PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        this.addexpenseButton = (FloatingActionButton) findViewById(R.id.addexpenseButton);
        this.container = (ViewPager) findViewById(R.id.container);
        this.collapsibletoolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsibletoolbar);
        this.descriptiontext = (TextView) findViewById(R.id.description_text);
        this.detailPageTab = (TabLayout) findViewById(R.id.detailPageTab);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.banneriv = (ImageView) findViewById(R.id.banner_iv);



        adapter = new PagerAdapter(getSupportFragmentManager(), 3);

        //Adding adapter to pager
        this.container.setAdapter(adapter);
        this.container.setOffscreenPageLimit(3);
        //this.container.setOnPageChangeListener(this);
        //Adding onTabSelectedListener to swipe views
       // this.detailPageTab.setOnTabSelectedListener(this);
        this.detailPageTab.setupWithViewPager(this.container);
    }
}
