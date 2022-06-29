package com.example.biologi

import android.app.Dialog
import android.content.Context
import android.view.ViewGroup
import kotlinx.android.synthetic.main.popup.*

fun Context.showSingleButtonWarningDialog(
    title: String,
    content: String,
    buttonText: String,
    isCancelable: Boolean = true,
    onClicked: () -> Unit = { kotlin.run {} }
) {
    Dialog(this).apply {
        setContentView(R.layout.popup)
        setCancelable(isCancelable)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        popUpSingleWarningTitle.text = title
        popUpSingleWarningContent.text = content
        popUpSingleWarningButton.text = buttonText
        popUpSingleWarningButton.setOnClickListener {
            dismiss()
            onClicked()
        }
    }.show()
}