package com.facilityapi

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

object FsdFileType : LanguageFileType(FsdLanguage) {

    override fun getIcon(): Icon? = IconLoader.getIcon("/icons/fsd.svg")

    override fun getName(): String = "Facility Service Definition"

    override fun getDefaultExtension(): String = EXTENSION

    override fun getDescription(): String = "Facility Service Definition Files"

    override fun getCharset(file: VirtualFile, content: ByteArray): String? = "UTF-8"

    const val EXTENSION = "fsd"
}