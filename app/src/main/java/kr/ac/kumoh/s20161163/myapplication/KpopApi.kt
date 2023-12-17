package kr.ac.kumoh.s20161163.myapplication

import retrofit2.http.GET

interface KpopApi {
    @GET("member")
    suspend fun getMembers(): List<KpopMember>
}