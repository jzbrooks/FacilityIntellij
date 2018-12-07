package com.facilityapi.psi

import com.facilityapi.FsdFileType
import com.facilityapi.FsdLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class FsdFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, FsdLanguage) {
    override fun getFileType(): FileType = FsdFileType
    override fun toString(): String = "Fsd File"
}