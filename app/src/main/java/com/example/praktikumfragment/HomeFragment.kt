package com.example.praktikumfragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnMoveFragment: Button = view.findViewById(R.id.btn_move_fragment)
        btnMoveFragment.setOnClickListener {
            val moveFragment = MoveFragment()
            val fragManager = parentFragmentManager
            fragManager.beginTransaction().apply {
                replace(
                    R.id.fragment_container,
                    moveFragment,
                    MoveFragment::class.java.simpleName
                )
                addToBackStack(null )
                commit()
            }
        }
    }
}