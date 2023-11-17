package com.example.ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.ucp2.ui.data.FormUiState

@Composable
fun HalamanDetail(
    orderUiState: FormUiState,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    val  items = listOf(
        Pair(stringResource(id = R.string.nama), orderUiState.nama),
        Pair(stringResource(id = R.string.nim), orderUiState.nim),
        Pair(stringResource(id = R.string.konsentrasi),orderUiState.konsentrasi),
        Pair(stringResource(id = R.string.judul), orderUiState.judul)
    )
    Column (
        modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
    ){
        items.forEach{item ->
            Text(text = item.first.toString())
            Text(text = item.second.toString())
        }
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
        Row (
            modifier = Modifier
                .weight(1f, false)
                .padding(dimensionResource(R.dimen.padding_medium))
        ){

        }
    }
}