package com.example.notes.util

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.notes.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_create_note.*
import kotlinx.android.synthetic.main.fragment_notes_bottom.*


class NoteBottomSheetFragment : BottomSheetDialogFragment() {
    var  selectedColor = "#fdbe3b"



    companion object{
        fun newInstance(): NoteBottomSheetFragment{
        val args =Bundle()
            val fragment = NoteBottomSheetFragment()
            fragment.arguments = args
            return fragment

        }
    }
    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)

        val view = LayoutInflater.from(context).inflate(R.layout.fragment_notes_bottom, null)
        dialog.setContentView(view)

        val param = (view.parent as View).layoutParams as CoordinatorLayout.LayoutParams

        val behavior = param.behavior

        if (behavior is BottomSheetBehavior<*>) {
            behavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onSlide(bottomSheet: View, slideOffset: Float) {

                }

                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    var state = ""
                    when (newState) {
                        BottomSheetBehavior.STATE_DRAGGING -> {
                            state = "DRAGGING"
                        }
                        BottomSheetBehavior.STATE_SETTLING -> {
                            state = "SETTLING"
                        }
                        BottomSheetBehavior.STATE_EXPANDED -> {
                            state = "EXPANDED"
                        }
                        BottomSheetBehavior.STATE_COLLAPSED -> {
                            state = "COLLAPSED"
                        }
                        BottomSheetBehavior.STATE_HIDDEN -> {
                            state = "HIDDEN"
                             
                            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
                        }

                    }
                }
            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_notes_bottom,container,false)

         }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()

    }




    private fun setListener() {
        fNote1.setOnClickListener() {

            imgNote1.setImageResource(R.drawable.ic_check)
            imgNote2.setImageResource(R.drawable.note_color_2)
            imgNote3.setImageResource(R.drawable.note_color_3)
            imgNote4.setImageResource(R.drawable.note_color_4)
            imgNote5.setImageResource(R.drawable.note_color_5)
            imgNote6.setImageResource(R.drawable.note_color_6)
            selectedColor = "#fdbe3b"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action", "Yellow")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }
        fNote2.setOnClickListener {

            imgNote1.setImageResource(R.drawable.note_color_1)
            imgNote2.setImageResource(R.drawable.ic_check)
            imgNote3.setImageResource(R.drawable.note_color_3)
            imgNote4.setImageResource(R.drawable.note_color_4)
            imgNote5.setImageResource(R.drawable.note_color_5)
            imgNote6.setImageResource(R.drawable.note_color_6)
            selectedColor = "#ff4842"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action", "Red")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }
        fNote3.setOnClickListener() {

            imgNote1.setImageResource(R.drawable.note_color_1)
            imgNote2.setImageResource(R.drawable.note_color_2)
            imgNote3.setImageResource(R.drawable.ic_check)
            imgNote4.setImageResource(R.drawable.note_color_4)
            imgNote5.setImageResource(R.drawable.note_color_5)
            imgNote6.setImageResource(R.drawable.note_color_6)
            selectedColor = "#3a52fc"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action", "Purple")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }
        fNote4.setOnClickListener() {

            imgNote1.setImageResource(R.drawable.note_color_1)
            imgNote2.setImageResource(R.drawable.note_color_2)
            imgNote3.setImageResource(R.drawable.note_color_3)
            imgNote4.setImageResource(R.drawable.ic_check)
            imgNote5.setImageResource(R.drawable.note_color_5)
            imgNote6.setImageResource(R.drawable.note_color_6)
            selectedColor = "#ae3b76"

            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action", "Maroon")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }
        fNote5.setOnClickListener() {

            imgNote1.setImageResource(R.drawable.note_color_1)
            imgNote2.setImageResource(R.drawable.note_color_2)
            imgNote3.setImageResource(R.drawable.note_color_3)
            imgNote4.setImageResource(R.drawable.note_color_4)
            imgNote5.setImageResource(R.drawable.ic_check)
            imgNote6.setImageResource(R.drawable.note_color_6)
            selectedColor = "#ffffff"


            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action", "White")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)

        }
        fNote6.setOnClickListener() {

            imgNote1.setImageResource(R.drawable.note_color_1)
            imgNote2.setImageResource(R.drawable.note_color_2)
            imgNote3.setImageResource(R.drawable.note_color_3)
            imgNote4.setImageResource(R.drawable.note_color_4)
            imgNote5.setImageResource(R.drawable.note_color_5)
            imgNote6.setImageResource(R.drawable.ic_check)
            selectedColor = "#0aebaf"


            val intent = Intent("bottom_sheet_action")
            intent.putExtra("action", "Green")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)


        }



    }


}
