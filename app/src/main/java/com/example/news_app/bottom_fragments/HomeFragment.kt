package com.example.news_app.bottom_fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.news_app.R
import com.example.news_app.adapters.HorizontalAdapter
import com.example.news_app.adapters.MainAdapter
import com.example.news_app.adapters.ViewPagerAdapter
import com.example.news_app.databinding.FragmentHomeBinding
import com.example.news_app.databinding.ItemTabBinding
import com.example.news_app.utils.Status
import com.example.news_app.viewmodels.UserViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    lateinit var binding: FragmentHomeBinding
    lateinit var horizontalAdapter: HorizontalAdapter
    private val TAG = "HomeFragment"
    lateinit var userViewModel: UserViewModel
    val tabArray = arrayOf(
        "Technology",
        "Entertainment",
        "Health",
        "Arts",
        "Sport"
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        setSearch()
        setViewPager()
        setRv()


        return binding.root
    }

    private fun setRv() {
        GlobalScope.launch(Dispatchers.Main) {
            userViewModel.getWord("general")
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
                               horizontalAdapter = HorizontalAdapter(it.data.data)
                                binding.itemsRv.adapter = horizontalAdapter


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

    private fun setViewPager() {
        val viewPager = binding.viewPager2
        val tabLayoutgl =  binding.tabLayoutgalvni

        val adapter = ViewPagerAdapter(tabArray,childFragmentManager, lifecycle)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayoutgl, viewPager) { tab, position ->
            val itemBinding = ItemTabBinding.inflate(layoutInflater)
            tab.customView = itemBinding.root
            itemBinding.titleTv.text = tabArray!![position]




            if (position == 0) {
                itemBinding.titleTv.setBackgroundResource(R.drawable.tab_item_back_selected)
                itemBinding.titleTv.setTextColor(Color.WHITE)

            } else {
                itemBinding.titleTv.setTextColor(Color.parseColor("#303236"))
                itemBinding.titleTv.setBackgroundResource(R.drawable.tab_item_back_unselected)
            }

            //Some implementation
        }.attach()



        binding.tabLayoutgalvni.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val itemTabBinding = ItemTabBinding.bind(tab?.customView!!)
                itemTabBinding.titleTv.setBackgroundResource(R.drawable.tab_item_back_selected)

                itemTabBinding.titleTv.setTextColor(Color.WHITE)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val itemTabBinding = ItemTabBinding.bind(tab?.customView!!)
                itemTabBinding.titleTv.setTextColor(Color.parseColor("#303236"))
                itemTabBinding.titleTv.setBackgroundResource(R.drawable.tab_item_back_unselected)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }

    private fun setSearch() {
        binding.search.setOnClickListener {
            binding.search.visibility = View.GONE
            binding.clear.visibility = View.VISIBLE
        }

        binding.clear.setOnClickListener {
            binding.clear.visibility = View.GONE
            binding.search.visibility = View.VISIBLE
            binding.etv.setText("")
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}