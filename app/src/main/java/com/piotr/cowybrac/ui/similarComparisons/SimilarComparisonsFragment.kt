package com.piotr.cowybrac.ui.similarComparisons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.piotr.cowybrac.R

class SimilarComparisonsFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.simmilar_comparisons, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)

        return root
    }
}