package al.bruno.sportify.ui

import android.os.Bundle
import android.os.Parcel
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import al.bruno.sportify.ui.home.EventViewModel
import al.bruno.sportify.ui.signin.AuthViewModel
import al.bruno.sportify.ui.signin.SignIn
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val authViewModel: AuthViewModel by viewModels()
    private val eventViewModel: EventViewModel by viewModels()

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authViewModel.auth()
        authViewModel.success.observe(this) {
            if (it) {
                setContent { AnnualLeave({ showDatePicker() }, eventViewModel, authViewModel) }
            } else {
                setContent { SignIn(authViewModel) }
            }
        }
    }

    private fun showDatePicker() {
        val constraints =  CalendarConstraints
            .Builder()
            .setValidator(object : CalendarConstraints.DateValidator {
                override fun describeContents(): Int {
                    TODO("Not yet implemented")
                }

                override fun writeToParcel(p0: Parcel, p1: Int) {
                    TODO("Not yet implemented")
                }

                override fun isValid(date: Long): Boolean {
                    return true
                }

            })
            .build()
        val picker = MaterialDatePicker
            .Builder
            .datePicker()
            .setCalendarConstraints(constraints)
            .build()
        picker.show(supportFragmentManager, picker.toString())
        picker.addOnPositiveButtonClickListener {
            eventViewModel.startDate = picker.headerText
        }
    }
}
