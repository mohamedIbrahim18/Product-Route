package com.example.productapp

import androidx.lifecycle.LiveData
import com.example.domain.model.Category
import com.example.domain.model.ProductsItem
import kotlinx.coroutines.flow.StateFlow

class ProductContract {

        interface ViewModel {
            val states: StateFlow<State>
            val events: LiveData<Event>
            fun invokeAction(action:Action)
        }

    sealed class State{
         object Loading : State()
         class Success(val products:List<ProductsItem?>?):State()
         class Error(val message:String):State()
    }
    sealed class Event{
        class NavigateToSubCategory() : Event()
    }
    sealed class Action{
        object LoadProduct:Action()
    }



}