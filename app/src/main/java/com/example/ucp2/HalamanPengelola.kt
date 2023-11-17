package com.example.ucp2

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucp2.ui.data.FormUiState
import com.example.ucp2.ui.data.SumberData.dosen

enum class HalamanPengelola {
    Home,
    Form,
    Detail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormPengajuan(
    viewModel: PengajuanViewModel = viewModel()
            navController: NavHostController = rememberNavController()
){
    Scaffold {innerPadding ->
        val  uiState by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = HalamanPengelola.Home.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(HalamanPengelola.Home.name){
                HalamanHome (
                    onNextButtonClicked = { navController.navigate(HalamanPengelola.Form.name)
                    })}
            composable(HalamanPengelola.Form.name){
                val  context = LocalContext.current
                HalamanForm(
                    dosenPilihan = dosen.map{id -> context.resources.getString(id)}
                            onSelectionChanged = {viewModel.setDosen(it)},
                    onPilihChanged = {viewModel.setDosen2(it)},
                    onSubmitButtonClicked = {
                        viewModel.setContact(it)
                        navController.navigate(HalamanPengelola.Detail.name)},
                        )}
                composable(
                    route = HalamanPengelola.Detail.name){
                    HalamanDetail(
                        orderUiState = uiState,
                        onCancelButtonClicked = {cancelOrderAndNavigateToForm(navController) }
                    )
                }
            }
        }

    }

private fun cancelOrderAndNavigateToForm(
    navController: NavHostController
){
    navController.popBackStack(HalamanPengelola.Form.name, inclusive = false)
}