package com.akashk.myapplication.model

import androidx.recyclerview.widget.DiffUtil

class DiffUtilGithubDataModelItem: DiffUtil.ItemCallback<GithubDataModelItem>() {

    override fun areItemsTheSame(
        oldItem: GithubDataModelItem,
        newItem: GithubDataModelItem
    ): Boolean {
        return newItem.id==oldItem.id
    }

    override fun areContentsTheSame(
        oldItem: GithubDataModelItem,
        newItem: GithubDataModelItem
    ): Boolean {

        return newItem==oldItem
    }
}