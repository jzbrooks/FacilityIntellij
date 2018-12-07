package com.facilityapi.parser

import com.facilityapi.FsdFlexAdapter
import com.facilityapi.FsdLanguage
import com.facilityapi.psi.FsdFile
import com.facilityapi.psi.FsdTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class FsdParserDefinition : ParserDefinition {
    val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
    val COMMENTS = TokenSet.create(FsdTypes.COMMENT)
    val FILE = IFileElementType(FsdLanguage)

    override fun createParser(project: Project?): PsiParser = FsdParser()

    override fun createFile(viewProvider: FileViewProvider): PsiFile = FsdFile(viewProvider)

    override fun getStringLiteralElements(): TokenSet = TokenSet.create(FsdTypes.STRING)

    override fun getFileNodeType(): IFileElementType = FILE

    override fun createLexer(project: Project?): Lexer = FsdFlexAdapter()

    override fun createElement(node: ASTNode?): PsiElement = FsdTypes.Factory.createElement(node)

    override fun getCommentTokens(): TokenSet = COMMENTS

    override fun getWhitespaceTokens(): TokenSet = WHITE_SPACES

    override fun spaceExistenceTypeBetweenTokens(
        left: ASTNode?,
        right: ASTNode?
    ): ParserDefinition.SpaceRequirements = ParserDefinition.SpaceRequirements.MAY
}