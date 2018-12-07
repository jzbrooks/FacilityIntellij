package com.facilityapi

import com.facilityapi.psi.FsdTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class FsdSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(elementType: IElementType?): Array<TextAttributesKey> {
        return when (elementType) {
            FsdTypes.SERVICE, FsdTypes.DATA, FsdTypes.METHOD, FsdTypes.ERRORS, FsdTypes.ERRORS -> KEYWORD_KEYS
            FsdTypes.COMMENT -> COMMENT_KEYS
            TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS
            else -> EMPTY_KEYS
        }
    }

    override fun getHighlightingLexer(): Lexer = FsdFlexAdapter()

    companion object {
        val SEPARATOR = createTextAttributesKey(
            "FSD_SEPARATOR",
            DefaultLanguageHighlighterColors.OPERATION_SIGN
        )
        val KEYWORD = createTextAttributesKey(
            "FSD_KEYWORD",
            DefaultLanguageHighlighterColors.KEYWORD
        )
        val VALUE = createTextAttributesKey(
            "FSD_VALUE",
            DefaultLanguageHighlighterColors.STRING
        )
        val COMMENT = createTextAttributesKey(
            "FSD_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT
        )
        val BAD_CHARACTER = createTextAttributesKey(
            "FSD_BAD_CHARACTER",
            HighlighterColors.BAD_CHARACTER
        )

        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val SEPARATOR_KEYS = arrayOf(SEPARATOR)
        private val KEYWORD_KEYS = arrayOf<TextAttributesKey>(KEYWORD)
        private val VALUE_KEYS = arrayOf(VALUE)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
    }
}