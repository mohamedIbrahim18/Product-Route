package com.example.productapp

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.domain.model.ProductsItem
import com.example.productapp.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    lateinit var viewModel: HomeViewModel
    lateinit var binding:ActivityHomeBinding

     var adapter = ProductAdapter(null)

    override fun onStart() {
        super.onStart()
        val window = window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.primary)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)


        viewModel.events.observe(this,::handleEvents)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.states.collect{
                    renderViewState(it)
                }
            }
        }


       viewModel.invokeAction(ProductContract.Action.LoadProduct)

        binding.recyclerView.adapter = adapter


        }

    private fun renderViewState(state: ProductContract.State) {
        when (state){
            is ProductContract.State.Success ->{
                bindProduct(state.products)
            }
            is ProductContract.State.Error ->{
                showError(state.message)
            }
            is ProductContract.State.Loading ->{
                showLoading()
            }
        }
    }

    private fun bindProduct(products: List<ProductsItem?>?) {
        binding.loadingView.isVisible=false
        binding.errorView.isVisible=false
        binding.recyclerView.isVisible=true
        adapter.bindCategories(products)
        Log.e("image",products?.get(1)?.imageCover?:"null ")
    }

    private fun showLoading() {
        binding.loadingView.isVisible=true
        binding.errorView.isVisible=false
        binding.recyclerView.isVisible=false
    }

    private fun showError(message: String) {
        binding.loadingView.isVisible=false
        binding.errorView.isVisible=true
        binding.recyclerView.isVisible=false
//        binding.errorMessage.text=message
        binding.tryAgainBt.setOnClickListener{
            viewModel.invokeAction(ProductContract.Action.LoadProduct)
        }
    }


    private fun handleEvents(event: ProductContract.Event) {

        when (event){
            is ProductContract.Event.NavigateToSubCategory ->{
                //TODO Navigate
            }
        }
    }
}
