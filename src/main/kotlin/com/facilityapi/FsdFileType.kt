package com.facilityapi

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object FsdFileType : LanguageFileType(FsdLanguage) {

    override fun getIcon(): Icon? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDefaultExtension(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDescription(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    const val EXTENSION = "fsd"
}