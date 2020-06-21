package com.example.learn.testme.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.etiennelenhart.eiffel.state.ViewState
import com.etiennelenhart.eiffel.viewmodel.StateViewModel
import com.example.learn.testme.App
import org.rewedigital.katana.Component
import org.rewedigital.katana.KatanaTrait


abstract class BaseActivity<S : ViewState> : AppCompatActivity(), KatanaTrait {

    override val component = Component(dependsOn = listOf(App.appComponent))

    protected abstract val viewModel: StateViewModel<S>

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        viewModel.observeState(this, ::onStateUpdated)
    }

    protected abstract fun onStateUpdated(state: S)
}