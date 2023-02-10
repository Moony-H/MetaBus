package com.moonyh.domain.algorithm

import kotlin.math.min

object BoyerMooreTextSearch {
    fun search(string: String, text: String):Boolean{
//        val hash= skipTable(string, text)
//        val m=text.length
//        val n=string.length
//        var i=m-1
//        var j=m-1
//        val result= arrayListOf<Int>()
//
//        while(i<n){
//            if(string[i]==text[j]){
//                if(j==0)
//                    result.add(i+1)
//                i-=1
//                j-=1
//            }else{
//                i+=m- min(j,hash[string[i]]!!+1)
//                j=m-1
//            }
//        }
        if(text in string){
            return true
        }
        return false
    }

    private fun skipTable(text:String,pattern:String):HashMap<Char,Int>{
        val hashMap=HashMap<Char,Int>()
        for(i in text.toList().distinct())
            hashMap[i]=pattern.lastIndexOf(i)
        return hashMap
    }
}