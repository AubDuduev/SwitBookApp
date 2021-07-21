package Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import Fragments.AuthFragment
import Fragments.BasketFragment
import Fragments.ProductDetailFragment
import Fragments.StartPreviewFragment
import Interfaces.MainNavigationInterface
import com.example.swiftbookapp.R
import com.example.swiftbookapp.databinding.StartPreviewFragmentBinding

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

  override fun createProductDetail() {
   ProductDetailFragment().show(this.supportFragmentManager, "createProductDetail")
  }
  override fun popBackStack() {
    this.supportFragmentManager.popBackStack()
  }
  companion object {
    private const val BACK_STACK_ID = "BACK_STACK"
  }
}