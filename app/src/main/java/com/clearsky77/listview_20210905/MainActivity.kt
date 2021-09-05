package com.clearsky77.listview_20210905

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.clearsky77.listview_20210905.adapters.StudentAdapter
import com.clearsky77.listview_20210905.datas.StudentData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val mStudentList = ArrayList<StudentData>()

    //변수만 만들고, 대입은 나중에
    lateinit var mAdapter: StudentAdapter //나중에 StudentAdepter 형태로 들어 올 것이다.
    //이렇게 만드는 이유는 초기화를 나중에 해줘야 에러가 나지 않기 때문

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
            //세번째 매개 변수: 어느 줄이 눌렸는지 줄 위치 알려줌.
            Log.d("리스트뷰 눌린 줄:",position.toString())
            // 클릭된 사람의 이름을 토스트로 띄워보자
            // position을 가지고 클릭된 사람이 누구인가?
            var clickedStudent = mStudentList[position]
            Toast.makeText(this, clickedStudent.name, Toast.LENGTH_SHORT).show()
        }

//        리스튜뷰의 아이템 길게 눌렀을 때
        studentListView.setOnItemLongClickListener { adapterView, view, position, l ->
            val clickedStudent = mStudentList[position]
            //누가 길게 눌렸는지 토스트 출력.
//            Toast.makeText(this, "${clickedStudent.name}이(가) 길게 눌림.", Toast.LENGTH_SHORT).show()

//            경고창. 진짜 삭제할 것인지 확인 -> 확인 눌렀을 때만 삭제.
            val alert = AlertDialog.Builder(this)
            alert.setTitle("학생 삭제 확인")
            alert.setMessage("${clickedStudent.name}을(를) 삭제하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialogInterface, i ->
//                확인을 누르면 실행할 부분
            //목록(mStudentList)에서 제거 => 리스트뷰에서도 빠지게.
            mStudentList.remove(clickedStudent)
//            리스트 뷰의 어댑터에 변경 사항을 공지해줘야한다. 아니면 에러.
            mAdapter.notifyDataSetChanged()
            })
            alert.setNegativeButton("취소",null)
            alert.show()

            //마지막에 결과로 true/false 지정 필요
            return@setOnItemLongClickListener true //false를 하면 롱클릭 실행 후 그냥 클릭도 실행된다.
        }

    }
}