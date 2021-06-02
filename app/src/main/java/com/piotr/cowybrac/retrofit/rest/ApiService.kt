package com.piotr.cowybrac.retrofit.rest

import com.piotr.cowybrac.retrofit.rest.restModel.Compare
import com.piotr.cowybrac.retrofit.util.Constants.Companion.COMPARES_URL
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface ApiService {

    @GET(COMPARES_URL)
    fun getCompares(): Observable<List<Compare>>
}