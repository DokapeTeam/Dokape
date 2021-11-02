package com.dokapegroup.dokape.mappers.base

interface NullableInputListMapper<I, O> : Mapper<List<I>?, List<O>>

internal class NullableInputListMapperImpl<I, O>(
    private val mapper: Mapper<I, O>
) : NullableInputListMapper<I, O> {
    override fun invoke(input: List<I>?) = input?.map(mapper).orEmpty()
}
