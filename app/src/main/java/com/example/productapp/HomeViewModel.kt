package com.example.productapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.ResultWrapper
import com.example.domain.model.ProductsItem
import com.example.domain.usecase.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductUseCase: GetProductUseCase,
    @IoDispatcher private val ioDispatcher:CoroutineDispatcher
):ViewModel() ,ProductContract.ViewModel{

    private val _events =  MutableLiveData<ProductContract.Event>()
    override val events = _events

    private val _states = MutableStateFlow<ProductContract.State>(
        ProductContract.State.Loading
    )
    override val states = _states

    override fun invokeAction(action: ProductContract.Action) {
        when(action){
            is ProductContract.Action.LoadProduct->{
                loadProduct()
            }
        }
    }



    private fun loadProduct(){

        viewModelScope.launch(ioDispatcher) {

            val response = getProductUseCase.invoke().collect{response->
                when(response){
                    is ResultWrapper.Success->{
                        _states.emit(ProductContract.State.Success(response.data))
                    }
                    is ResultWrapper.ServerError ->{
                        _states.emit(ProductContract.State.Error(response.error.serverMessage))
                    }

                    is ResultWrapper.Error -> {
                        _states.emit(ProductContract.State.Error(response.error.localizedMessage))
                    }
                    ResultWrapper.Loading -> {
                        _states.emit(ProductContract.State.Loading)
                    }
                }
            }



        }

    }

}