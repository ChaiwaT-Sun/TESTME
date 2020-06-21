package com.example.learn.testme.Interface

import android.view.View

interface ItemClickLIstener {
    fun onClick(view: View?, position: Int, isLongClick: Boolean)
}