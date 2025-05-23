package edu.cnt.developer.profe.tabs

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import edu.cnt.developer.profe.R

class TabsActivity: AppCompatActivity(), TabLayoutMediator.TabConfigurationStrategy {

    lateinit var viewPager: ViewPager2
    lateinit var tabLayout: TabLayout
    lateinit var adapterTabs: AdapterTabs

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MYAPP", "TabsActivity: onCreate: start")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)

        this.viewPager = findViewById(R.id.viewPagerTabs)
        this.tabLayout = findViewById(R.id.tabLayoutTabs)
        this.adapterTabs = AdapterTabs(this)
        this.viewPager.adapter = this.adapterTabs
        TabLayoutMediator(tabLayout, viewPager, this).attach()
        Log.d("MYAPP", "TabsActivity: onCreate: finish")
    }

    override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
        tab.text = "VISTA ${position+1}"
        Log.d("MYAPP", "TabsActivity: onConfigureTab: position = ${position}")
    }
}