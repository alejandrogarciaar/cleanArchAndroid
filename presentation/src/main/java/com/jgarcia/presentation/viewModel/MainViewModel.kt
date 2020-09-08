package com.jgarcia.presentation.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jgarcia.domain.model.Category
import com.jgarcia.domain.model.ProductPreview
import com.jgarcia.domain.util.Result
import com.jgarcia.usecases.GetCurrentCategories
import com.jgarcia.usecases.GetProductsByCategory
import com.jgarcia.usecases.GetProductsByQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel @ViewModelInject constructor(
    private val getProductsByQuery: GetProductsByQuery,
    private val getProductsByCategory: GetProductsByCategory,
    private val getCurrentCategories: GetCurrentCategories
) : ViewModel() {

    private val productsLiveData: MutableLiveData<Result<List<ProductPreview>>> = MutableLiveData()
    private val productsByCategoryLiveData: MutableLiveData<Result<List<ProductPreview>>> = MutableLiveData()
    private val categoriesLiveData: MutableLiveData<Result<List<Category>>> = MutableLiveData()

    fun getProductList(): LiveData<Result<List<ProductPreview>>> = productsLiveData

    fun getProductsByCategoryList(): LiveData<Result<List<ProductPreview>>> = productsByCategoryLiveData

    fun getCategoriesList(): LiveData<Result<List<Category>>> = categoriesLiveData

    fun searchByTerm(query: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                productsLiveData.postValue(Result.Loading)
                val currentProducts = getProductsByQuery.invoke(query)
                productsLiveData.postValue(currentProducts)
            }
        }
    }

    fun getProductByCategoryId(categoryId: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                productsByCategoryLiveData.postValue(Result.Loading)
                val currentProductsByCategory = getProductsByCategory.invoke(categoryId)
                productsByCategoryLiveData.postValue(currentProductsByCategory)
            }
        }
    }

    fun getCategories() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                categoriesLiveData.postValue(Result.Loading)
                val categoriesList = getCurrentCategories.invoke()
                categoriesLiveData.postValue(categoriesList)
            }
        }
    }
}