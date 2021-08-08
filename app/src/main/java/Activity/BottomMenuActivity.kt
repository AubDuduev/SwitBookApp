package Activity

import Fragments.*
import Helpers.ViewPagerAdapter
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.swiftbookapp.R
import com.example.swiftbookapp.databinding.BottomMenuActivityBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator



class BottomMenuActivity: AppCompatActivity() {

  lateinit var binding: BottomMenuActivityBinding
  private val tabLayoutNames = listOf<String>("Все", "Фаст фуд", "Дисерт")
  private lateinit var viewPager: ViewPager2
  private lateinit var tabLayout: TabLayout
  private lateinit var bottomMenu: BottomNavigationView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    this.initBinding()
    this.toolBar()
    this.createBottomMenu()
    this.createMenuViewPage()
    this.createTabLayout()
    this.subscriberScrollPager()
  }
  private fun initBinding(){
    this.binding = BottomMenuActivityBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)
  }
  private fun toolBar(){
    supportActionBar?.hide()
  }
  private fun createBottomMenu(){
    this.bottomMenu = findViewById<BottomNavigationView>(R.id.bnmMain)
    bottomMenu.setOnNavigationItemReselectedListener {
      when (it.itemId) {

        R.id.bmFavorite -> {
          this.createFavoriteViewPage()
          Log.d("TAG", "createFavoriteViewPage")
        }
        R.id.bmMenu -> {
          this.createMenuViewPage()
          Log.d("TAG", "createMenuViewPage")
        }
        else -> {

        }
      }
    }
  }
  private fun createMenuViewPage(){
    this.viewPager = findViewById<ViewPager2>(R.id.vpMain)
    this.viewPager.adapter = ViewPagerAdapter(this).apply {
      addFragment(ListProductsFragment())
      addFragment(FastFoodFragment())
      addFragment(DessertFragment())
    }
  }
  private fun createFavoriteViewPage(){
    this.viewPager = findViewById<ViewPager2>(R.id.vpMain)
    this.viewPager.adapter = ViewPagerAdapter(this).apply {
      addFragment(AllMenuFragment())
      addFragment(DessertFragment())
      addFragment(FastFoodFragment())
    }
  }
  private fun createTabLayout(){
    this.tabLayout = findViewById<TabLayout>(R.id.tlMain)
    TabLayoutMediator(this.tabLayout,  this.viewPager){ tab, position ->
      tab.text = this.tabLayoutNames[position]
    }.attach()
  }
  private fun subscriberScrollPager(){
    this.binding.vpMain.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
      override fun onPageScrollStateChanged(state: Int) {
        super.onPageScrollStateChanged(state)
      }
      override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        super.onPageScrolled(position, positionOffset, positionOffsetPixels)
      }
      override fun onPageSelected(position: Int) {
        super.onPageSelected(position)
      }
    })
  }
  companion object {
    private const val BACK_STACK_ID = "BACK_STACK_TWO"
  }
}

