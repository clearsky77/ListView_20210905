package com.clearsky77.listview_20210905

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clearsky77.listview_20210905.datas.StudentData

class MainActivity : AppCompatActivity() {
    val mStudentList = ArrayList<StudentData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //임시방편: 코드에 타이핑해서 추가

        mStudentList.add(StudentData("김첫째", 1988, "서울시 동대문구"))
        mStudentList.add(StudentData("김이이", 1988, "서울시 동대문구"))
        mStudentList.add(StudentData("김삼삼", 1988, "서울시 동대문구"))
        mStudentList.add(StudentData("김사사", 1988, "서울시 동대문구"))
        mStudentList.add(StudentData("김오오", 1988, "서울시 동대문구"))
        mStudentList.add(StudentData("김육육", 1988, "서울시 동대문구"))
        mStudentList.add(StudentData("김칠칠", 1988, "서울시 동대문구"))
        mStudentList.add(StudentData("김팔팔", 1988, "서울시 동대문구"))
        mStudentList.add(StudentData("김구구", 1988, "서울시 동대문구"))


    }
}