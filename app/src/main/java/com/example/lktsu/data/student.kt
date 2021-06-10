package com.example.lktsu.data

import android.provider.BaseColumns


class Student private constructor() {
    object student : BaseColumns {
        const val TABLE_NAME = "student"
        val id: String = BaseColumns._ID
        const val COLUMN_FIO = "FIO"
        const val COLUMN_GROUP = "[group]"
        const val COLUMN_TEL1 = "tel1"
        const val COLUMN_TEL2 = "tel2"
        const val COLUMN_TEL3 = "tel3"
        const val COLUMN_EMAIL = "email"
    }
}