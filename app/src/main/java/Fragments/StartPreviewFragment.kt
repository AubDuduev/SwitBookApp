package Fragments

import Activity.MainActivity
import Interfaces.MainNavigationInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.swiftbookapp.R
import com.example.swiftbookapp.databinding.BasketFragmnetBinding
import com.example.swiftbookapp.databinding.StartPreviewFragmentBinding

class StartPreviewFragment : Fragment() {

    private lateinit var btnBegin: Button
    private lateinit var binding : StartPreviewFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        this.binding = StartPreviewFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.createElements(view)
        this.btnBeginListener()
    }

    private fun createElements(view: View){
        this.btnBegin = binding.btnBegin
    }
    private fun btnBeginListener(){
        this.btnBegin.setOnClickListener {
            (activity as MainNavigationInterface).createAuthFragment()
        }
    }
}