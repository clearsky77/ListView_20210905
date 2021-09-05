package com.clearsky77.listview_20210905.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.clearsky77.listview_20210905.datas.StudentData

class StudentAdapter(
    val mContext: Context, //어느 화면에
    val resId: Int, //
    val mList: ArrayList<StudentData> ) : ArrayAdapter<StudentData>(mContext, resId, mList){ //:는 상속이다
}