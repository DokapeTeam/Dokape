package com.dokapegroup.dokape.mappers.base

interface ListMapper<I, O> : Mapper<List<I>, List<O>>

class ListMapperImpl<I, O>(private val mapper: Mapper<I, O>) : ListMapper<I, O> {
    override fun invoke(input: List<I>) = input.map(mapper)
}
