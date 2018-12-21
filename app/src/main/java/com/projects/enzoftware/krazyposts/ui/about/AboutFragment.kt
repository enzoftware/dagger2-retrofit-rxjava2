package com.projects.enzoftware.krazyposts.ui.about


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.projects.enzoftware.krazyposts.R
import com.projects.enzoftware.krazyposts.di.component.DaggerFragmentComponent
import com.projects.enzoftware.krazyposts.di.module.FragmentModule
import kotlinx.android.synthetic.main.fragment_about.*
import javax.inject.Inject

class AboutFragment : Fragment(), AboutContract.View {

    @Inject lateinit var presenter: AboutContract.Presenter
    private lateinit var rootView : View

    // FRAGMENT LIFECYCLE

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependency()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView =  inflater.inflate(R.layout.fragment_about, container, false)
        return  rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.subscribe()
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    // FRAGMENT FUNCTIONS

    fun newInstance(): AboutFragment {
        return AboutFragment()
    }

    private fun injectDependency() {
        val aboutComponent = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule())
            .build()

        aboutComponent.inject(this)
    }

    private fun initView() {
        presenter.loadMessage()
    }


    // IMPLEMENTATIONS OF INTERFACE PRESENTER

    override fun showProgress(show: Boolean) {
        if(show){
            progressBar.visibility = View.VISIBLE
        }else{
            progressBar.visibility = View.GONE
        }
    }

    override fun loadMessageSuccess(message: String) {
        aboutText.text = getString(R.string.about_text)
        aboutText.visibility = View.VISIBLE
    }


    // COMPANION OBJECT

    companion object {
        val TAG: String = "AboutFragment"
    }

}
