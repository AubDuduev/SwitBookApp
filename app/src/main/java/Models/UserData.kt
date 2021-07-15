package Models

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class UserData(name: String, number: String): Serializable {

  public var number = number
  public var name   = name
}