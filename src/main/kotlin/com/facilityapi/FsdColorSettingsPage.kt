package com.facilityapi

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

class FsdColorSettingsPage : ColorSettingsPage {

    override fun getIcon(): Icon? = IconLoader.getIcon("/icons/fsd.svg")

    override fun getHighlighter(): SyntaxHighlighter = FsdSyntaxHighlighter()

    override fun getDemoText(): String = "/// Example service for widgets.\n" +
        "[http(url: \"http://local.example.com/v1\")]\n" +
        "[csharp(namespace: Facility.ExampleApi)]\n" +
        "service ExampleApi\n" +
        "{\n" +
        "\t/// Gets widgets.\n" +
        "\t[http(method: GET, path: \"/widgets\")]\n" +
        "\tmethod getWidgets\n" +
        "\t{\n" +
        "\t\t/// The query.\n" +
        "\t\t[http(from: query, name: \"q\")]\n" +
        "\t\tquery: string;\n" +
        "\n" +
        "\t\t/// The limit of returned results.\n" +
        "\t\tlimit: int32;\n" +
        "\n" +
        "\t\t/// The sort field.\n" +
        "\t\tsort: WidgetField;\n" +
        "\n" +
        "\t\t/// True to sort descending.\n" +
        "\t\tdesc: boolean;\n" +
        "\n" +
        "\t\t/// The maximum weight.\n" +
        "\t\t[obsolete]\n" +
        "\t\tmaxWeight: double;\n" +
        "\t}:\n" +
        "\t{\n" +
        "\t\t/// The widgets.\n" +
        "\t\twidgets: Widget[];\n" +
        "\n" +
        "\t\t/// The total number of widgets.\n" +
        "\t\ttotal: int64;\n" +
        "\n" +
        "\t\t/// The total weight.\n" +
        "\t\t[obsolete]\n" +
        "\t\ttotalWeight: double;\n" +
        "\n" +
        "\t\t/// The pending job.\n" +
        "\t\t[http(from: body, code: 202)]\n" +
        "\t\tjob: WidgetJob;\n" +
        "\t}\n" +
        "\n" +
        "\t/// Creates a new widget.\n" +
        "\t[http(method: POST, path: \"/widgets/\", code: 201)]\n" +
        "\tmethod createWidget\n" +
        "\t{\n" +
        "\t\t/// The widget to create.\n" +
        "\t\t[http(from: body)]\n" +
        "\t\twidget: Widget;\n" +
        "\t}:\n" +
        "\t{\n" +
        "\t\t/// The created widget.\n" +
        "\t\t[http(from: body)]\n" +
        "\t\twidget: Widget;\n" +
        "\t}\n" +
        "\n" +
        "\t/// Gets the specified widget.\n" +
        "\t[http(method: GET, path: \"/widgets/{id}\")]\n" +
        "\tmethod getWidget\n" +
        "\t{\n" +
        "\t\t/// The widget ID.\n" +
        "\t\tid: string;\n" +
        "\n" +
        "\t\t[http(from: header, name: \"If-None-Match\")]\n" +
        "\t\tifNoneMatch: string;\n" +
        "\t}:\n" +
        "\t{\n" +
        "\t\t/// The requested widget.\n" +
        "\t\t[http(from: body)]\n" +
        "\t\twidget: Widget;\n" +
        "\n" +
        "\t\t[http(from: header)]\n" +
        "\t\teTag: string;\n" +
        "\n" +
        "\t\t[http(from: body, code: 304)]\n" +
        "\t\tnotModified: boolean;\n" +
        "\t}\n" +
        "\n" +
        "\t/// Deletes the specified widget.\n" +
        "\t[http(method: DELETE, path: \"/widgets/{id}\", code: 204)]\n" +
        "\tmethod deleteWidget\n" +
        "\t{\n" +
        "\t\t/// The widget ID.\n" +
        "\t\tid: string;\n" +
        "\t}:\n" +
        "\t{\n" +
        "\t}\n" +
        "\n" +
        "\t/// Edits widget.\n" +
        "\t[http(method: POST, path: \"/widgets/{id}\")]\n" +
        "\tmethod editWidget\n" +
        "\t{\n" +
        "\t\t/// The widget ID.\n" +
        "\t\tid: string;\n" +
        "\n" +
        "\t\t/// The operations.\n" +
        "\t\tops: object[];\n" +
        "\n" +
        "\t\t/// The new weight.\n" +
        "\t\t[obsolete]\n" +
        "\t\tweight: double;\n" +
        "\t}:\n" +
        "\t{\n" +
        "\t\t/// The edited widget.\n" +
        "\t\t[http(from: body, code: 200)]\n" +
        "\t\twidget: Widget;\n" +
        "\n" +
        "\t\t/// The pending job.\n" +
        "\t\t[http(from: body, code: 202)]\n" +
        "\t\tjob: WidgetJob;\n" +
        "\t}\n" +
        "\n" +
        "\t/// Gets the specified widgets.\n" +
        "\t[http(method: POST, path: \"/widgets/get\")]\n" +
        "\tmethod getWidgetBatch\n" +
        "\t{\n" +
        "\t\t/// The IDs of the widgets to return.\n" +
        "\t\tids: string[];\n" +
        "\t}:\n" +
        "\t{\n" +
        "\t\t/// The widget results.\n" +
        "\t\tresults: result<Widget>[];\n" +
        "\t}\n" +
        "\n" +
        "\t/// Gets the widget weight.\n" +
        "\t[obsolete]\n" +
        "\t[http(method: GET, path: \"/widgets/{id}/weight\")]\n" +
        "\tmethod getWidgetWeight\n" +
        "\t{\n" +
        "\t\t/// The widget ID.\n" +
        "\t\tid: string;\n" +
        "\t}:\n" +
        "\t{\n" +
        "\t\t/// The widget weight.\n" +
        "\t\tvalue: double;\n" +
        "\t}\n" +
        "\n" +
        "\t/// Gets a widget preference.\n" +
        "\t[http(method: GET, path: \"/prefs/{key}\")]\n" +
        "\tmethod getPreference\n" +
        "\t{\n" +
        "\t\t/// The preference key.\n" +
        "\t\tkey: string;\n" +
        "\t}:\n" +
        "\t{\n" +
        "\t\t/// The preference value.\n" +
        "\t\t[http(from: body)]\n" +
        "\t\tvalue: Preference;\n" +
        "\t}\n" +
        "\n" +
        "\t/// Sets a widget preference.\n" +
        "\t[http(method: PUT, path: \"/prefs/{key}\")]\n" +
        "\tmethod setPreference\n" +
        "\t{\n" +
        "\t\t/// The preference key.\n" +
        "\t\tkey: string;\n" +
        "\n" +
        "\t\t/// The preference value.\n" +
        "\t\t[http(from: body)]\n" +
        "\t\tvalue: Preference;\n" +
        "\t}:\n" +
        "\t{\n" +
        "\t\t/// The preference value.\n" +
        "\t\t[http(from: body)]\n" +
        "\t\tvalue: Preference;\n" +
        "\t}\n" +
        "\n" +
        "\t/// Demonstrates the default HTTP behavior.\n" +
        "\tmethod notRestful\n" +
        "\t{\n" +
        "\t}:\n" +
        "\t{\n" +
        "\t}\n" +
        "\n" +
        "\tmethod kitchen\n" +
        "\t{\n" +
        "\t\tsink: KitchenSink;\n" +
        "\t}:\n" +
        "\t{\n" +
        "\t}\n" +
        "\n" +
        "\t/// Custom errors.\n" +
        "\terrors ExampleApiErrors\n" +
        "\t{\n" +
        "\t\t/// The user is not an administrator.\n" +
        "\t\t[http(code: 403)]\n" +
        "\t\tNotAdmin,\n" +
        "\t}\n" +
        "\n" +
        "\t/// A widget.\n" +
        "\tdata Widget\n" +
        "\t{\n" +
        "\t\t/// A unique identifier for the widget.\n" +
        "\t\tid: string;\n" +
        "\n" +
        "\t\t/// The name of the widget.\n" +
        "\t\tname: string;\n" +
        "\n" +
        "\t\t/// The weight of the widget.\n" +
        "\t\t[obsolete]\n" +
        "\t\tweight: double;\n" +
        "\t}\n" +
        "\n" +
        "\t/// A widget job.\n" +
        "\tdata WidgetJob\n" +
        "\t{\n" +
        "\t\t/// A unique identifier for the widget job.\n" +
        "\t\tid: string;\n" +
        "\t}\n" +
        "\n" +
        "\t/// A preference.\n" +
        "\tdata Preference\n" +
        "\t{\n" +
        "\t\t[csharp(name: \"IsBoolean\")]\n" +
        "\t\tboolean: boolean;\n" +
        "\n" +
        "\t\tbooleans: boolean[];\n" +
        "\n" +
        "\t\tdouble: double;\n" +
        "\n" +
        "\t\tdoubles: double[];\n" +
        "\n" +
        "\t\tinteger: int32;\n" +
        "\n" +
        "\t\tintegers: int32[];\n" +
        "\n" +
        "\t\tstring: string;\n" +
        "\n" +
        "\t\tstrings: string[];\n" +
        "\n" +
        "\t\tbytes: bytes;\n" +
        "\n" +
        "\t\tbyteses: bytes[];\n" +
        "\n" +
        "\t\twidgetField: WidgetField;\n" +
        "\n" +
        "\t\twidgetFields: WidgetField[];\n" +
        "\n" +
        "\t\twidget: Widget;\n" +
        "\n" +
        "\t\twidgets: Widget[];\n" +
        "\n" +
        "\t\tresult: result<Widget>;\n" +
        "\n" +
        "\t\tresults: result<Widget>[];\n" +
        "\n" +
        "\t\tbigInteger: int64;\n" +
        "\n" +
        "\t\tbigIntegers: int64[];\n" +
        "\n" +
        "\t\tdecimal: decimal;\n" +
        "\n" +
        "\t\tdecimals: decimal[];\n" +
        "\n" +
        "\t\terror: error;\n" +
        "\n" +
        "\t\terrors: error[];\n" +
        "\n" +
        "\t\tobject: object;\n" +
        "\n" +
        "\t\tobjects: object[];\n" +
        "\n" +
        "\t\tnamedStrings: map<string>;\n" +
        "\n" +
        "\t\tnamedWidgets: map<Widget>;\n" +
        "\t}\n" +
        "\n" +
        "\t/// Identifies a widget field.\n" +
        "\tenum WidgetField\n" +
        "\t{\n" +
        "\t\t/// The 'id' field.\n" +
        "\t\tid,\n" +
        "\n" +
        "\t\t/// The 'name' field.\n" +
        "\t\tname,\n" +
        "\n" +
        "\t\t/// The 'weight' field.\n" +
        "\t\t[obsolete]\n" +
        "\t\tweight,\n" +
        "\t}\n" +
        "\n" +
        "\t/// An obsolete DTO.\n" +
        "\t[obsolete]\n" +
        "\tdata ObsoleteData\n" +
        "\t{\n" +
        "\t\tunused: boolean;\n" +
        "\t}\n" +
        "\n" +
        "\t/// An obsolete enum.\n" +
        "\t[obsolete]\n" +
        "\tenum ObsoleteEnum\n" +
        "\t{\n" +
        "\t\tunused,\n" +
        "\t}\n" +
        "\n" +
        "\tdata KitchenSink\n" +
        "\t{\n" +
        "\t\t[obsolete, proto(id: 1)]\n" +
        "\t\toldField: string;\n" +
        "\t}\n" +
        "}\n" +
        "\n" +
        "# ExampleApi\n" +
        "\n" +
        "Additional service remarks.\n" +
        "\n" +
        "## Heading\n" +
        "\n" +
        "Use a primary heading to indicate the member name.\n" +
        "\n" +
        "# getWidgets\n" +
        "\n" +
        "Additional method remarks.\n" +
        "\n" +
        "# Widget\n" +
        "\n" +
        "Additional DTO remarks.\n" +
        "\n" +
        "## Heading\n" +
        "\n" +
        "Only top-level headings need to match a member name.\n" +
        "\n" +
        "# WidgetField\n" +
        "\n" +
        "Additional enum remarks.\n"

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? {
        return null
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "Facility Service Definition"
    }

    companion object {
        private val DESCRIPTORS = arrayOf(
            AttributesDescriptor("Key", FsdSyntaxHighlighter.KEYWORD),
            AttributesDescriptor("Comment", FsdSyntaxHighlighter.COMMENT),
            AttributesDescriptor("Value", FsdSyntaxHighlighter.VALUE)
        )
    }
}