package com.example.news_app.bottom_fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.news_app.R
import com.example.news_app.adapters.MainAdapter
import com.example.news_app.databinding.FragmentGlavniBinding
import com.example.news_app.databinding.FragmentHomeBinding
import com.example.news_app.utils.Status
import com.example.news_app.viewmodels.UserViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GlavniFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GlavniFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Int? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var binding: FragmentGlavniBinding
    lateinit var userViewModel: UserViewModel
    lateinit var mainAdapter: MainAdapter
    private val TAG = "GlavniFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGlavniBinding.inflate(layoutInflater, container, false)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)




//        GlobalScope.launch(Dispatchers.Main) {
//            userViewModel.getWord("fuck")
//                .observe(viewLifecycleOwner) {
//
//
//
//
//
//
//                    when (it.status) {
//                        Status.LOADING -> {
//
//                        }
//
//                        Status.ERROR -> {
//
//                            Log.d(TAG, "onCreateView: ${it.message}")
//                            Toast.makeText(
//                                binding.root.context,
//                                "Word not found",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
//
//                        Status.SUCCESS -> {
//
//                            try {
//
//
//                                Log.d(TAG, "onCreateView: ${it.data!!.data}")
//
//
//                            }catch (e:java.lang.Exception){
//                                Toast.makeText(
//                                    binding.root.context,
//                                    "Word not found",
//                                    Toast.LENGTH_SHORT
//                                ).show()
//                            }
//
//
//
//
//
//
//                        }
//                    }
//
//
//
//                }}

















        if (param1 == 0){
                    GlobalScope.launch(Dispatchers.Main) {
            userViewModel.getWord("technology")
                .observe(viewLifecycleOwner) {






                    when (it.status) {
                        Status.LOADING -> {

                        }

                        Status.ERROR -> {

                            Log.d(TAG, "onCreateView: ${it.message}")
                            Toast.makeText(
                                binding.root.context,
                                "Word not found",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        Status.SUCCESS -> {

                            try {


                                Log.d(TAG, "onCreateView: ${it.data!!.data}")
                                mainAdapter = MainAdapter(it.data.data)
                                binding.rvKurs.adapter = mainAdapter


                            }catch (e:java.lang.Exception){
                                Toast.makeText(
                                    binding.root.context,
                                    "Word not found",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }






                        }
                    }



                }}
        }


        if (param1 == 1){
            GlobalScope.launch(Dispatchers.Main) {
                userViewModel.getWord("entertainment")
                    .observe(viewLifecycleOwner) {






                        when (it.status) {
                            Status.LOADING -> {

                            }

                            Status.ERROR -> {

                                Log.d(TAG, "onCreateView: ${it.message}")
                                Toast.makeText(
                                    binding.root.context,
                                    "Word not found",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            Status.SUCCESS -> {

                                try {


                                    Log.d(TAG, "onCreateView: ${it.data!!.data}")
                                    mainAdapter = MainAdapter(it.data.data)
                                    binding.rvKurs.adapter = mainAdapter


                                }catch (e:java.lang.Exception){
                                    Toast.makeText(
                                        binding.root.context,
                                        "Word not found",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }






                            }
                        }



                    }}
        }


        if (param1 == 2){
            GlobalScope.launch(Dispatchers.Main) {
                userViewModel.getWord("health")
                    .observe(viewLifecycleOwner) {






                        when (it.status) {
                            Status.LOADING -> {

                            }

                            Status.ERROR -> {

                                Log.d(TAG, "onCreateView: ${it.message}")
                                Toast.makeText(
                                    binding.root.context,
                                    "Word not found",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            Status.SUCCESS -> {

                                try {


                                    Log.d(TAG, "onCreateView: ${it.data!!.data}")
                                    mainAdapter = MainAdapter(it.data.data)
                                    binding.rvKurs.adapter = mainAdapter


                                }catch (e:java.lang.Exception){
                                    Toast.makeText(
                                        binding.root.context,
                                        "Word not found",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }






                            }
                        }



                    }}
        }
        
        


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GlavniFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int, param2: String) =
            GlavniFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}