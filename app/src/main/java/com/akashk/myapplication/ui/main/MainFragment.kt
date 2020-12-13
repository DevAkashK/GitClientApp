package com.akashk.myapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.akashk.myapplication.R
import com.akashk.myapplication.model.GithubDataModel
import com.akashk.myapplication.model.ResultData
import com.akashk.myapplication.ui.adpater.RepositoryAdapter
import com.akashk.myapplication.ui.base.BaseFragment
import com.akashk.myapplication.utils.NoInternetException
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_fragment.*

@AndroidEntryPoint
class MainFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val mainViewModel by viewModels<MainViewModel>()

    private lateinit var repositoryAdapter: RepositoryAdapter

    private val repositoryObserver = Observer<ResultData<GithubDataModel>> { resultData ->

        when (resultData) {

            is ResultData.Loading -> {
                progressIndicator.visibility=VISIBLE
            }

            is ResultData.Success -> {
                progressIndicator.visibility=GONE
                val gitHubRepoList = resultData.data
                repositoryAdapter.submitList(gitHubRepoList)
            }

            is ResultData.Exception -> {

                handleAllErrors(resultData.exception!!)
                //Toast.makeText(context,"NO internet connectio",Toast.LENGTH_SHORT).show()
                progressIndicator.visibility=GONE
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        repositoryAdapter = RepositoryAdapter()
        repoRecyclerView.adapter = repositoryAdapter
        swipe_refresh.setOnRefreshListener(this)
        getDataAndSubscribeEvents()

        //removed when added the OnSwipeRefresh
        /* val repositories = mainViewModel.getRepositoriesList()

         repositories.observe(viewLifecycleOwner, Observer { resultData ->

             when (resultData) {

                 is ResultData.Loading -> {

                 }

                 is ResultData.Success -> {
                     val gitHubRepoList = resultData.data
                     repositoryAdapter.submitList(gitHubRepoList)
                 }

                 is ResultData.Failure -> {

                 }

                 is ResultData.Exception -> {

                 }
             }
         })*/

    }

    private fun getDataAndSubscribeEvents() {
        val repoData = mainViewModel.getRepositoriesList()
        repoData.observe(viewLifecycleOwner, repositoryObserver)
    }

    override fun onRefresh() {
        swipe_refresh.isRefreshing = false
        getDataAndSubscribeEvents()
    }

}