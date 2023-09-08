package dev.lizainslie.saku.demo.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.lizainslie.saku.common.components.SakuTable
import dev.lizainslie.saku.common.components.SakuText
import dev.lizainslie.saku.common.theme.SakuTheme

data class Person(
    val name: String,
    val age: Int,
    val email: String
)

@Composable
fun ExampleTable() {
    val people = listOf(
        Person("Taint Man Andrew", 90, "andrewtate@smalldickenergy.com"),
    )

    Box(Modifier.width(400.dp).height(200.dp)) {
        SakuTable(
            modifier = Modifier.matchParentSize(),
            columnCount = 3, rowCount = 11,
            cellContent = { columnIndex, rowIndex ->
                when (columnIndex) {
                    0 -> {
                        if (rowIndex == 0) SakuText("Name", style = SakuTheme.typography.button)
                        else SakuText(people[rowIndex - 1].name)
                    }

                    1 -> {
                        if (rowIndex == 0) SakuText("Age", style = SakuTheme.typography.button)
                        else SakuText(people[rowIndex - 1].age.toString())
                    }

                    2 -> {
                        if (rowIndex == 0) SakuText("Email", style = SakuTheme.typography.button)
                        else SakuText(people[rowIndex - 1].email)
                    }
                }
            }
        )
    }
}