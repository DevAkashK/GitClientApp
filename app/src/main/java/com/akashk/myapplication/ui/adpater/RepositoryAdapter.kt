package com.akashk.myapplication.ui.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.akashk.myapplication.R
import com.akashk.myapplication.model.DiffUtilGithubDataModelItem
import com.akashk.myapplication.model.GithubDataModelItem
import kotlinx.android.synthetic.main.list_item_repository.view.*

class RepositoryAdapter : ListAdapter<GithubDataModelItem, RepositoryAdapter.RepositoryViewHolder>(
    DiffUtilGithubDataModelItem()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_repository, parent, false)
        return RepositoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: GithubDataModelItem?) {
            itemView.tvRepoName.text = item?.name
            itemView.tvRepoDesc.text=item?.description
        }
    }
}