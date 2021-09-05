package com.clearsky77.listview_20210905.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.clearsky77.listview_20210905.R
import com.clearsky77.listview_20210905.datas.StudentData
import java.util.*
import kotlin.collections.ArrayList

class StudentAdapter(
    val mContext: Context, //어느 화면에
    val resId: Int, //
    val mList: ArrayList<StudentData>
) : ArrayAdapter<StudentData>(mContext, resId, mList) { //:는 상속이다

    // xml을 가져와서 코틀린단에서 활용하도록 가져와주는 도구 생성
    val mInflater = LayoutInflater.from(mContext)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView //임시로 한 줄에 해당하는 것을 만들어 줌.
        if (tempRow == null) {
            tempRow = mInflater.inflate(R.layout.student_list_item, null) // R이라는 것은 res 폴더다!
        }
        val row = tempRow!!
//        getView 작업의 결과물로 지정.
        val data = mList[position]
//        row의 내부에서 필요한 요소를 가져오자
        val nameTxt = row.findViewById<TextView>(R.id.nameText)
        val addressTxt = row.findViewById<TextView>(R.id.addressTxt)
        val ageTxt = row.findViewById<TextView>(R.id.ageTxt)
        nameTxt.text = data.name
        addressTxt.text = data.address

//      나이 계산
        val age = Calendar.getInstance().get(Calendar.YEAR) - data.birthYear +1
        ageTxt.text = "(${age}세)"

        return row
    }
}