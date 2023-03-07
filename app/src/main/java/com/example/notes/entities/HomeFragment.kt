package com.example.notes.entities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.notes.R
import com.example.notes.adapter.NotesAdapter
import com.example.notes.database.NotesDatabase
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment() {
    var selectedcolor = "fdbe3b"

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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {

        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notesRecyclerView.setHasFixedSize(true)

        notesRecyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        launch {
            context?.let {
                var notes = NotesDatabase.getDatabase(it).noteDao().getAllNotes()
                notesRecyclerView.adapter = NotesAdapter(notes)
            }
        }



        imageAddNoteMain.setOnClickListener {

            replaceFragment(CreateNoteFragment(),false)

        }
    }
    fun replaceFragment(fragment: Fragment, istranstion:Boolean){
        val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frame_layout, fragment).commit()
        Toast.makeText(
            activity,"Success.",
            Toast.LENGTH_SHORT).show()


        if (istranstion){
            fragmentTransaction.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)

        }

    }


    }
