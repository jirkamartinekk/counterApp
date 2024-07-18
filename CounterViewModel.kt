package com.example.counterapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel () : ViewModel() {
    private val _repository: CounterRepository = CounterRepository()
    //access repository using getCounter() function of count property
    private val _count = mutableStateOf(_repository.getCounter().count)

    //have to use immutable state to access _count value from private state
    val count : MutableState<Long> = _count

    fun increment(){
        _repository.incrementCounter()
        _count.value = _repository.getCounter().count
    }

    fun decrement(){
        _repository.decrementCounter()
        _count.value = _repository.getCounter().count
    }

}