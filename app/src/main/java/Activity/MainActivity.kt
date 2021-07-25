package Activity

import Fragments.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import Interfaces.MainNavigationInterface
import android.app.ProgressDialog.show
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.swiftbookapp.R
import com.example.swiftbookapp.databinding.StartPreviewFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity(), MainNavigationInterface {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    this.createStartPreviewFragment()
  }
  private fun createStartPreviewFragment(){
    this.supportFragmentManager
      .beginTransaction()
      .add(R.id.clMainActivityRoot, StartPreviewFragment())
      .commit()
  }

  override fun createAuthFragment(){
    supportFragmentManager
      .beginTransaction()
      .add(R.id.clMainActivityRoot, AuthFragment())
      .addToBackStack(BACK_STACK_ID)
      .commit()
  }

  override fun openBasketFragment(numberPhoneUser: String){
    supportFragmentManager
      .beginTransaction()
      .add( R.id.clMainActivityRoot, BasketFragment.newInstance(numberPhoneUser = numberPhoneUser))
      .addToBackStack(BACK_STACK_ID)
      .commit()
  }

  override fun createMenuFragment() {
    supportFragmentManager
      .beginTransaction()
      .add( R.id.clMainActivityRoot, MenuFragment())
      .addToBackStack(BACK_STACK_ID)
      .commit()

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