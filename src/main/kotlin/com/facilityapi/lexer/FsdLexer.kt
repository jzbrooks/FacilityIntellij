package com.facilityapi.lexer

import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.FlexLexer
import com.intellij.psi.tree.IElementType

class FsdLexer : FlexAdapter(FsdFlexLexer())

// todo: Replace with JFlex defined grammar
class FsdFlexLexer : FlexLexer {
    override fun yystate(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTokenStart(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun advance(): IElementType {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reset(buf: CharSequence?, start: Int, end: Int, initialState: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun yybegin(state: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTokenEnd(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
