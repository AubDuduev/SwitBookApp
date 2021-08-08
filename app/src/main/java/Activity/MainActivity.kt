package Activity

import Fragments.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import Interfaces.MainNavigationInterface
import android.app.ProgressDialog.show
import android.content.Intent
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.swiftbookapp.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity(), MainNavigationInterface {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    this.createStartPreviewFragment()
    this.createHeader()
    this.toolBar()
  }
  private fun createStartPreviewFragment(){
    this.supportFragmentManager
      .beginTransaction()
      .add(R.id.flMenu, StartPreviewFragment())
      .commit()
  }
  private fun toolBar(){
    supportActionBar?.hide()
  }
  private fun createHeader(){
    supportFragmentManager
      .beginTransaction()
      .add(R.id.flHeader, MainHeaderFragment())
      .addToBackStack(BACK_STACK_ID)
      .commit()
  }
  override fun createAuthFragment(){
    supportFragmentManager
      .beginTransaction()
      .add(R.id.flMenu, AuthFragment())
      .addToBackStack(BACK_STACK_ID)
      .commit()
  }
  override fun openBasketFragment(numberPhoneUser: String){
    supportFragmentManager
      .beginTransaction()
      .add( R.id.flMenu, BasketFragment.newInstance(numberPhoneUser = numberPhoneUser))
      .addToBackStack(BACK_STACK_ID)
      .commit()
  }
  override fun pushBottomMenuActivity(){
    val intent = Intent(this, BottomMenuActivity::class.java)
    startActivity(intent)
  }
  override fun createProductDetail() {
    val dialog = ProductDetailFragment()
    dialog.show(this.supportFragmentManager, "createProductDetail")
  }
  override fun popBackStack() {
    this.supportFragmentManager.popBackStack()
  }
  companion object {
    private const val BACK_STACK_ID = "BACK_STACK"
  }
}