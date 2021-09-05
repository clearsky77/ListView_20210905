package com.clearsky77.listview_20210905

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.clearsky77.listview_20210905.adapters.StudentAdapter
import com.clearsky77.listview_20210905.datas.StudentData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val mStudentList = ArrayList<StudentData>()

    //변수만 만들고, 대입은 나중에
    lateinit var mAdapter: StudentAdapter //나중에 StudentAdepter 형태로 들어 올 것이다.

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

        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

//        리스트뷰 어댑터로 -> mAdapter가 역할을 하도록 연결시키자.
        studentListView.adapter = mAdapter

//        리스튜뷰의 각 줄이 눌렸을 때 이벤트 처리
        studentListView.setOnItemClickListener { adapterView, view, position, l ->

//            세번째 매개 변수: 어느 줄이 눌렸는지 줄 위치 알려줌.
            Log.d("리스트뷰 눌린 줄:",position.toString())

//            클릭된 사람의 이름을 토스트로 띄워보자
//            position을 가지고 클릭된 사람이 누구인가?

            var clickedStudent = mStudentList[position]

            Toast.makeText(this, clickedStudent.name, Toast.LENGTH_SHORT).show()

        }
    }
}