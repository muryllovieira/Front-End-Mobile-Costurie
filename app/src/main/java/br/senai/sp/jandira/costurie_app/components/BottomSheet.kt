package br.senai.sp.jandira.costurie_app.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(
    title: String,
    scaffoldState: BottomSheetScaffoldState,
    parentContent: @Composable () -> Unit,
    offset: Dp = 0.dp,
    sheetContent: @Composable () -> Unit
) {
    val courotineScope = rememberCoroutineScope()
    val dismiss = {
        courotineScope.launch {
            scaffoldState.bottomSheetState.collapse()
        }
    }
    val onCloseButtonAction ={dismiss()}

    BackHandler(enabled = scaffoldState.bottomSheetState.isExpanded) {dismiss()}

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetElevation = 0.dp,
        sheetContent = {
                       BottomSheetContentTemplate(title, onCloseButtonAction, offset, sheetContent)
        },
        sheetPeekHeight = 64.dp,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    ) {
        parentContent()
    }
}

@Composable
fun BottomSheetContentTemplate(
    title: String,
    onCloseButtonAction: () -> Job,
    headerOffSet: Dp,
    sheetContent: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(unbounded = false)
            .wrapContentHeight(unbounded = true)
            .padding(8.dp)
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            BottomSheetHeader(title, headerOffSet, onCloseButtonAction)
            sheetContent()
        }
    }
}
@Composable
private fun BottomSheetHeader(title: String, headerOffSet: Dp, onCloseButtonAction: () -> Job) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = headerOffSet,
                bottom = 16.dp
                ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "teste",
            fontSize = 32.sp,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.SemiBold
        )
    }
}
