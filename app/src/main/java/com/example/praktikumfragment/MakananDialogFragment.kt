package com.example.praktikumfragment
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment
class MakananDialogFragment : DialogFragment() {
    private var dialoglistener : onOptionDialogListener? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_makanan_dialog, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCancel : Button = view.findViewById(R.id.btn_cancel)
        val btnSelect : Button = view.findViewById(R.id.btn_cancel)
        val rgMakanan : RadioGroup = view.findViewById(R.id.rg_makanan)
        val rbNasiGoreng : RadioButton = view.findViewById(R.id.rb_nasi_goreng)
        val rbNasiPadang : RadioButton = view.findViewById(R.id.rb_nasi_padang)
        val rbNasiTelur : RadioButton = view.findViewById(R.id.rb_nasi_Telur)
        btnSelect.setOnClickListener {
            val selectedRadioButtonId =rgMakanan.checkedRadioButtonId
            if(selectedRadioButtonId != -1){
                val makanan : String = when(selectedRadioButtonId){
                    R.id.rb_nasi_goreng ->rbNasiGoreng.text.toString()
                    R.id.rb_nasi_padang ->rbNasiPadang.text.toString()
                    R.id.rb_nasi_Telur ->rbNasiTelur.text.toString()
                    else ->""
                }
                dialoglistener?.onOptionSelected(makanan)
                dialog?.dismiss()
            }
        }
        btnCancel.setOnClickListener {
            dialog?.cancel()
        }
    }
    interface  onOptionDialogListener{
        fun onOptionSelected(text: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment = parentFragment
        if(fragment is MoveWithDataFragment){
            this.dialoglistener = fragment.dialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.dialoglistener = null
    }
}