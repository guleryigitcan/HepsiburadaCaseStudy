package com.guleryigitcan.HepsiburadaCaseStudy.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.guleryigitcan.HepsiburadaCaseStudy.MainActivity
import com.guleryigitcan.HepsiburadaCaseStudy.R
import com.guleryigitcan.HepsiburadaCaseStudy.domain.viewModel.ProductViewModel


class ProductDetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val musicViewModel by viewModels<ProductViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_product_detail, container, false)
        val artwork100=view.findViewById<ImageView>(R.id.artwork_url)
        val artistName=view.findViewById<TextView>(R.id.artistName_text_detail)
        val collectionName=view.findViewById<TextView>(R.id.collectionName_text_detail)
        val collectionPrice=view.findViewById<TextView>(R.id.collectionPrice_text_detail)
        val releaseDate=view.findViewById<TextView>(R.id.releaseDate_text_detail)
        val description=view.findViewById<TextView>(R.id.description_text_detail)

        val backArrowbutton=view.findViewById<Button>(R.id.back_button)
        backArrowbutton.setOnClickListener {
            startActivity(Intent(requireContext(),MainActivity::class.java))



        }

        val id=arguments?.getInt("trackId")
        musicViewModel.getData(id.toString())
        musicViewModel.getList.observe(requireActivity()){list->
            Glide.with(requireContext())
                .load(list[0]?.artworkUrl100)
                .circleCrop()
                .into(artwork100)
            artistName.text= list[0].artistName
            releaseDate.text=list[0].releaseDate

            if(list[0].kind=="ebook"){


                collectionPrice.text=list[0].price.toString()+"$"
                releaseDate.text=list[0].releaseDate
                description.text=list[0].description

            }
            else if(list[0].kind=="software"){

                collectionName.text= list[0].trackName
                collectionPrice.text=list[0].price.toString()+"$"
                description.text=list[0].releaseNotes

            }else if(list[0].kind=="feature-movie"){
                description.text=list[0].longDescription
                collectionName.text= list[0].trackName
                collectionPrice.text=list[0].collectionPrice.toString()+"$"

            }
            else{
                collectionName.text= list[0].collectionName
                collectionPrice.text=list[0].collectionPrice.toString()+"$"
            }


        }




        return view
    }




}