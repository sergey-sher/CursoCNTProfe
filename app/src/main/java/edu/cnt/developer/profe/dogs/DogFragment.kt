package edu.cnt.developer.profe.dogs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import edu.cnt.developer.profe.R

class DogFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val itemDog = inflater.inflate(R.layout.fragment_dog, container, false)
        val urlFoto = arguments?.getString("URL_PHOTO")
        val photoCounterText = arguments?.getString("COUNTER_TEXT")

        val imageDog = itemDog.findViewById<ImageView>(R.id.imageViewDogsPhoto)
        val textDog = itemDog.findViewById<TextView>(R.id.textViewDogsPhotoNumber)

        textDog.text = photoCounterText
        Picasso.get().load(urlFoto).into(imageDog)

        return itemDog
    }
}