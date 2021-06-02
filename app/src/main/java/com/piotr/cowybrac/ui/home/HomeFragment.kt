package com.piotr.cowybrac.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.ValueCallback
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.piotr.cowybrac.R
import com.piotr.cowybrac.recyclerAdapters.HomeRecyclerAdapter
import com.piotr.cowybrac.retrofit.rest.ApiClient
import com.piotr.cowybrac.retrofit.rest.ApiService
import com.piotr.cowybrac.retrofit.rest.restModel.Compare
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val myAdapter by lazy{ HomeRecyclerAdapter()}
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById<RecyclerView>(R.id.home_recycler)
        layoutManager = LinearLayoutManager(requireContext())
        setupRecyclerView()
        val compositeDisposable = CompositeDisposable()
        val apiClient = ApiClient()
        compositeDisposable.add(
            apiClient.getApiService(requireContext()).getCompares()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({response -> onResponse(response)},{t -> onFailure(t)})
        )
        CoroutineScope(IO).launch{
            //getTitle()
        }
    }
    private fun onFailure(t: Throwable){
        Log.d("RESTERR", t.message.toString())
    }

    private fun onResponse(response: List<Compare>){
        myAdapter.setData(response)
    }
    private fun setupRecyclerView(){
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = layoutManager
    }
    private suspend fun getTitle() {
        val connection: Connection.Response? = Jsoup.connect("https://allegro.pl/oferta/zestaw-lampka-rowerowa-led-przod-optima450-usb-tyl-10504495646")
                .userAgent("Chrome/90.0.4430.212")
                .referrer("https://allegro.pl/oferta/zestaw-lampka-rowerowa-led-przod-optima450-usb-tyl-10504495646")
                .header("Accept-Language", "en-US")
                .execute()
        val doc = connection!!.parse()
        val element = doc.getElementsByTag("h1")
        Log.d("WEB", element.toString())
    }
}