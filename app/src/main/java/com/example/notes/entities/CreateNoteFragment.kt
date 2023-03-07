package com.example.notes.entities

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.Button
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.notes.R
import com.example.notes.database.NotesDatabase
import com.example.notes.util.NoteBottomSheetFragment
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_create_note.*
import kotlinx.android.synthetic.main.activity_create_note.view.*
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*


class CreateNoteFragment : BaseFragment() {
    var currentDate: String? = null
    var selectedColor = "#fdbe3b"
    var selectedImage = ""





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_create_note, container, false)
    }

    companion object {

        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(
            myBroadcastReceiver, IntentFilter("bottom_sheet_action")
        )

        val sdf =SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        currentDate = sdf.format(Date())

        textDateTime.text = currentDate

        imageSave.setOnClickListener(){
        saveNote()

        }
        imageBack.setOnClickListener(){
        replaceFragment(HomeFragment(),false)
        }

        imgmore.setOnClickListener(){
         var noteBottomSheetFragment = NoteBottomSheetFragment()
            noteBottomSheetFragment.show(requireActivity().supportFragmentManager,"Note Bottom Sheet Fragment")
        }

    }

    private fun saveNote() {
        if (inputNoteTitle.text.isNullOrEmpty()) {
            Toast.makeText(context, "Title is Required", Toast.LENGTH_SHORT).show()
        } else if (inputNoteSubtitle.text.isNullOrEmpty()) {
            Toast.makeText(context, "Note Subtitle is Required", Toast.LENGTH_SHORT).show()
        } else if (inputNote.text.isNullOrEmpty()) {
            Toast.makeText(context, "Note Required", Toast.LENGTH_SHORT).show()
        } else {

            launch {
                var notes = Notes()
                notes.title = inputNoteTitle.text.toString()
                notes.subtitle = inputNoteSubtitle.text.toString()
                notes.noteText = inputNote.text.toString()
                notes.dateTime = currentDate
                notes.color = selectedColor
                notes.imagePath = selectedImage.toString()

                context.let {
                    NotesDatabase.getDatabase(it!!).noteDao().insertNote(notes)
                    inputNoteTitle.setText("")
                    inputNoteSubtitle.setText("")
                    inputNote.setText("")
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment, istranstion:Boolean){
        val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()

        if (istranstion){
            fragmentTransaction.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)

        }
        fragmentTransaction.replace(R.id.frame_layout,fragment).addToBackStack(fragment.javaClass.simpleName).commit()
    }

    private val myBroadcastReceiver : BroadcastReceiver = object :BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {

            var actionColor = p1!!.getStringExtra("action")
            Toast.makeText(
                activity, "Success.",
                Toast.LENGTH_SHORT
            ).show()
            when (actionColor!!) {
                "Yellow" -> {
                    selectedColor = p1.getStringExtra("selectedColor")!!
                    viewSubtitleIndicator.setBackgroundColor(Color.parseColor(selectedColor))
                }
                "Red" -> {
                    selectedColor = p1.getStringExtra("selectedColor")!!
                    viewSubtitleIndicator.setBackgroundColor(Color.parseColor(selectedColor))
                }
                "Purple" -> {
                    selectedColor = p1.getStringExtra("selectedColor")!!
                    viewSubtitleIndicator.setBackgroundColor(Color.parseColor(selectedColor))
                }
                "Maroon" -> {
                    selectedColor = p1.getStringExtra("selectedColor")!!
                    viewSubtitleIndicator.setBackgroundColor(Color.parseColor(selectedColor))
                }
                "White" -> {
                    selectedColor = p1.getStringExtra("selectedColor")!!
                    viewSubtitleIndicator.setBackgroundColor(Color.parseColor(selectedColor))
                }
                "Green" -> {
                    selectedColor = p1.getStringExtra("selectedColor")!!
                    viewSubtitleIndicator.setBackgroundColor(Color.parseColor(selectedColor))
                }
                else -> {
                    selectedColor = p1.getStringExtra("selectedColor")!!
                    viewSubtitleIndicator.setBackgroundColor(Color.parseColor(selectedColor))
                }
            }
        }
    }


    override fun onDestroy() {
        LocalBroadcastManager.getInstance((requireContext())).unregisterReceiver(myBroadcastReceiver)
        super.onDestroy()
    }
}

