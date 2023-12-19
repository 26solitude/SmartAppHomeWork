package kr.ac.kumoh.s20161163.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class KpopMemeberViewModel() : ViewModel() {
    private val SERVER_URL = "https://port-0-s23w10backend-3yl7k2blonrwyx5.sel5.cloudtype.app/"
    private val kpopApi: KpopApi


    private val _memberList = MutableLiveData<List<KpopMember>>()
    val memberList: LiveData<List<KpopMember>>
        get() = _memberList

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        kpopApi = retrofit.create(KpopApi::class.java)
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                val response = kpopApi.getMembers()
                _memberList.value = response
            } catch (e: Exception) {
                Log.e("fetchData()", e.toString())
            }
        }
    }
}