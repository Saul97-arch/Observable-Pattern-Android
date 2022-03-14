package br.com.iteris.myapplication

interface Subject {
    fun register(observer: Observer?)
    fun unregister(observer: Observer?)
    fun notifyObservers()
}