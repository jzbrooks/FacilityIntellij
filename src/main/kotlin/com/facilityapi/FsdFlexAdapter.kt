package com.facilityapi

import com.intellij.lexer.FlexAdapter

class FsdFlexAdapter : FlexAdapter(FsdLexer(null))