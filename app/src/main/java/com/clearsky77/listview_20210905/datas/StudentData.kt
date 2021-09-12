package com.clearsky77.listview_20210905.datas

class StudentData(
    val name: String,
    val birthYear: Int,
    val address: String) {

//    이 사람의 나이를 계산
//    연도를 넣으면 -> 그 해의 나이를 계산

    fun getKoreanAge( year : Int ) : Int{
        //한국 나이 계산
        val koreanAge = year - this.birthYear + 1
        return koreanAge
    }
}