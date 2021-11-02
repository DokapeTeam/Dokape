package com.dokapeteam.dokape.mappers.base

interface NullableOutputListMapper<I, O> : Mapper<List<I>, List<O>?>

internal class NullableOutputListMapperImpl<I, O>(
    private val mapper: Mapper<I, O>
) : NullableOutputListMapper<I, O> {
    override fun invoke(input: List<I>) = if (input.isEmpty()) null else input.map(mapper)
}
