package com.piotr.cowybrac.retrofit.rest

import com.piotr.cowybrac.retrofit.rest.restModel.Compare
import com.piotr.cowybrac.retrofit.util.Constants.Companion.COMPARISONS_URL
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface ApiService {

    @GET(COMPARISONS_URL)
    fun getComparisons(): Observable<List<Compare>>
}