package com.guleryigitcan.HepsiburadaCaseStudy.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.guleryigitcan.HepsiburadaCaseStudy.Comminicator
import com.guleryigitcan.HepsiburadaCaseStudy.R
import com.guleryigitcan.HepsiburadaCaseStudy.adapter.MyAdapter
import com.guleryigitcan.HepsiburadaCaseStudy.data.ItunesRetrofitFactory
import com.guleryigitcan.HepsiburadaCaseStudy.domain.viewModel.ProductViewModel
import com.guleryigitcan.HepsiburadaCaseStudy.model.ProductListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductListFragment : Fragment(),Comminicator {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val musicViewModel by viewModels<ProductViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_product_list, container, false)
        val searchEditText=view.findViewById<EditText>(R.id.searchEditText)
        val recyclerViewMusicList=view.findViewById<RecyclerView>(R.id.recycler_view_music_list)
        val musicButton=view.findViewById<Button>(R.id.music_search)
        val movieButton=view.findViewById<Button>(R.id.movie_search)
        val bookButton=view.findViewById<Button>(R.id.book_search)
        val appButton=view.findViewById<Button>(R.id.app_search)

        musicButton.isSelected=!musicButton.isSelected
        movieButton.isSelected=!movieButton.isSelected
        appButton.isSelected=!appButton.isSelected
        bookButton.isSelected=!bookButton.isSelected
        musicViewModel.searchList.observe(requireActivity()){ list->
            val adapter=MyAdapter(list,this@ProductListFragment)
            recyclerViewMusicList.adapter=adapter

        }




        musicButton.setOnClickListener{

            musicButton.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.buttonClicked))
            movieButton.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.button_bg))
            bookButton.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.button_bg))
            appButton.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.button_bg))

            recyclerViewMusicList.adapter=null
            musicButton.isSelected=true
            movieButton.isSelected=!movieButton.isSelected
            appButton.isSelected=!appButton.isSelected
            bookButton.isSelected=!bookButton.isSelected

            if(musicButton.isSelected){
                searchEditText.text=null

                searchEditText.addTextChangedListener(object :TextWatcher{
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    }

                    override fun afterTextChanged(p0: Editable?) {
                        if(musicButton.isSelected){
                            if(p0.toString().length>2){
                               // search(p0.toString(),"musicTrack")
                                musicViewModel.searchData(p0.toString(),"musicTrack")

                            }
                        }


                    }

                })

            }









        }
        movieButton.setOnClickListener{
            recyclerViewMusicList.adapter=null
            musicButton.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.button_bg))
            movieButton.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.buttonClicked))
            bookButton.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.button_bg))
            appButton.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.button_bg))



            searchEditText.text=null

                searchEditText.addTextChangedListener(object :TextWatcher{
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        movieButton.isSelected=true
                        musicButton.isSelected=!musicButton.isSelected
                        bookButton.isSelected=!bookButton.isSelected
                        appButton.isSelected=!appButton.isSelected


                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    }

                    override fun afterTextChanged(p0: Editable?) {
                        if(movieButton.isSelected){
                            if(p0.toString().length>2){
                                //search(p0.toString(),"movie")
                                musicViewModel.searchData(p0.toString(),"movie")
                            }
                        }


                    }

                })




        }

        bookButton.setOnClickListener {
            musicButton.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.button_bg))
            movieButton.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.button_bg))
            bookButton.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.buttonClicked))
            appButton.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.button_bg))

            searchEditText.text=null
            recyclerViewMusicList.adapter=null




            searchEditText.addTextChangedListener(object :TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    bookButton.isSelected=true
                    musicButton.isSelected=!musicButton.isSelected
                    movieButton.isSelected=!movieButton.isSelected
                    appButton.isSelected=!appButton.isSelected

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun afterTextChanged(p0: Editable?) {
                    if(bookButton.isSelected)
                    if(p0.toString().length>2){
                       // search(p0.toString(),"ebook")
                        musicViewModel.searchData(p0.toString(),"ebook")
                    }

                }

            })



        }

        appButton.setOnClickListener {

            musicButton.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.button_bg))
            movieButton.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.button_bg))
            bookButton.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.button_bg))
            appButton.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.buttonClicked))
            recyclerViewMusicList.adapter=null

            searchEditText.text=null
            searchEditText.addTextChangedListener(object :TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    bookButton.isSelected=!bookButton.isSelected
                    musicButton.isSelected=!musicButton.isSelected
                    movieButton.isSelected=!movieButton.isSelected
                    appButton.isSelected=true

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun afterTextChanged(p0: Editable?) {
                    if(appButton.isSelected){
                        if(p0.toString().length>2){
                            //search(p0.toString(),"software")
                            musicViewModel.searchData(p0.toString(),"software")
                        }
                    }


                }

            })




        }


        return view
    }

    fun search(p0:String, entity:String){

        val recyclerViewMusicList=view?.findViewById<RecyclerView>(R.id.recycler_view_music_list)
        ItunesRetrofitFactory.instance.service?.getSearch(entity,p0.toString())?.enqueue(object :Callback<ProductListModel>{
            override fun onResponse(
                call: Call<ProductListModel>?,
                response: Response<ProductListModel>?
            ) {
                val musicListModel= response?.body()

                val adapter= musicListModel?.results?.let { MyAdapter(it,this@ProductListFragment) }


                recyclerViewMusicList?.adapter=adapter

            }

            override fun onFailure(call: Call<ProductListModel>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })

    }

    override fun passData(trackId: Int) {
        val bundle = Bundle()
        bundle.putInt("trackId", trackId)

        val transaction = this.parentFragmentManager.beginTransaction()
        val frag2 = ProductDetailFragment()
        frag2.arguments = bundle


        transaction.replace(R.id.fragmentContainerView,frag2)
        transaction.addToBackStack(null)
        transaction.commit()


    }




}

