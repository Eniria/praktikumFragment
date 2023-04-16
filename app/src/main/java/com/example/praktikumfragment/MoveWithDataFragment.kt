package com.example.praktikumfragment
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
class MoveWithDataFragment : Fragment() {
    companion object{
        var EXTRA_NAME = "extra_name"
        var EXTRA_AGE = "extra_age"
    }
    var receivedName : String? =null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_move_with_data, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val  tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvAge = view.findViewById<TextView>(R.id.tv_age)
        val btnMoveActivity = view.findViewById<Button>(R.id.btn_move_activity)
        val btnOpenDialog = view.findViewById<Button>(R.id.btn_open_dialog)

        if(savedInstanceState !== null){
            val nameFromBundle  = savedInstanceState.getString(EXTRA_NAME)
            receivedName = nameFromBundle
        }
        if (arguments != null){
            val receivedAge = arguments?.getInt(EXTRA_AGE)
            tvName.text = receivedName
            tvAge.text = receivedAge.toString()
        }
        btnMoveActivity.setOnClickListener {
            val intent = Intent(requireActivity(),ExampleActivity::class.java)
            startActivity(intent)
        }
        btnOpenDialog.setOnClickListener {
            val makananDialogFragment = MakananDialogFragment()
            val  fragManager = childFragmentManager
            makananDialogFragment.show(fragManager, MakananDialogFragment::class.java.simpleName)
        }
    }
    internal var dialogListener : MakananDialogFragment.onOptionDialogListener =
        object : MakananDialogFragment.onOptionDialogListener{
            override fun onOptionSelected(text: String) {
                Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
            }
        }
}