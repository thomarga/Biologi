package com.example.biologi

import android.app.Dialog
import android.content.Context
import android.os.Build
import android.text.Html
import android.text.Spanned
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

fun String?.spannedHtml(): Spanned = when {
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.N ->
        Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
    else -> Html.fromHtml(this)
}