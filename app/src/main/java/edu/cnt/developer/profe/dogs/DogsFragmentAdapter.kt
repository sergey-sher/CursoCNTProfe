package edu.cnt.developer.profe.dogs

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class DogsFragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    var dogsList: DogsList? = null

    override fun getItemCount(): Int {
        return dogsList!!.message.size ?: 5
    }

    override fun createFragment(position: Int): Fragment {
        var dogFragment = DogFragment()
        val urlPhoto = dogsList?.message?.get(position)
        val localPosition = position + 1
        val textToRead = "${localPosition} de ${dogsList?.message?.size}"

        var bundle = Bundle()
        bundle.putString("URL_PHOTO", urlPhoto)
        bundle.putString("COUNTER_TEXT", textToRead)
        dogFragment.arguments = bundle

        return dogFragment
    }

}