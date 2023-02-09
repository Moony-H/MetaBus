package com.moonyh.domain.algorithm

import kotlin.math.min

object BoyerMooreTextSearch {
    fun search(text: String, string: String):ArrayList<Int>{
        val hash= skipTable(text, string)
        val m=string.length
        val n=text.length
        var i=m-1
        var j=m-1
        val result= arrayListOf<Int>()

        while(i<n){
            if(text[i]==string[j]){
                if(j==0)
                    result.add(i+1)
                i-=1
                j-=1
            }else{
                i+=m- min(j,hash[text[i]]!!+1)
                j=m-1
            }
        }
        return result
    }

    private fun skipTable(text:String,pattern:String):HashMap<Char,Int>{
        val hashMap=HashMap<Char,Int>()
        for(i in text.toList().distinct())
            hashMap[i]=pattern.lastIndexOf(i)
        return hashMap
    }
}