package com.google.firebase.example.makeitso.ui.todolist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TodoListScreen(viewModel: TodoListViewModel = hiltViewModel()) {
    val uiState = viewModel.uiState.collectAsState()
}