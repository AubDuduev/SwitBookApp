package Interfaces

interface MainNavigationInterface {

  fun openBasketFragment(numberPhoneUser: String)
  fun createAuthFragment()
  fun popBackStack()
  fun createProductDetail()
  fun pushBottomMenuActivity()
}