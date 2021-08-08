package Fragments

import Activity.MainActivity
import Helpers.ViewPagerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.swiftbookapp.databinding.MenuFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class MenuFragment : Fragment() {

  lateinit var binding: MenuFragmentBinding
  private val tabLayoutNames = listOf<String>("Все", "Фаст фуд", "Дисерт")

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    this.binding = MenuFragmentBinding.inflate(inflater, container, false)
    return this.binding.root
  }
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    this.createViewPage()
    this.subscriberScrollPager()
    this.createTabLayout()
  }
  private fun createViewPage(){
    val activityMain = this.activity as? MainActivity
    this.binding.vpMain.adapter = ViewPagerAdapter(activityMain!!).apply {
      addFragment(AllMenuFragment())
      addFragment(FastFoodFragment())
      addFragment(DessertFragment())
    }
  }
  private fun createTabLayout(){
    TabLayoutMediator(this.binding.tlMain, this.binding.vpMain){ tab, position ->
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

    const val USER_DATA_KEY = "USER_DATA"

    fun newInstance(): MenuFragment {
      val fragment = MenuFragment()
      return fragment
    }
  }
}