package al.bruno.sportify.di

import al.bruno.sportify.ui.authentication.AuthViewModel
import al.bruno.sportify.ui.home.EventViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<AuthViewModel> { AuthViewModel(get(), get(), get()) }
    viewModel<EventViewModel> { EventViewModel(get(), get(), get()) }
}