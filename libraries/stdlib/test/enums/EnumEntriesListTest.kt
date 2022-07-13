/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package test.enums

import kotlin.enums.EnumEntriesList
import kotlin.test.*
import test.collections.behaviors.listBehavior
import test.collections.compare

class EnumEntriesListTest {

    enum class EmptyEnum

    enum class NonEmptyEnum {
        A, B, C
    }

    @Test
    fun testForEmptyEnum() {
        val list = EnumEntriesList(EmptyEnum::values)
        assertTrue(list.isEmpty())
        assertEquals(0, list.size)
        assertFalse { list is MutableList<*> }
        assertFailsWith<IndexOutOfBoundsException> { list[0] }
        assertFailsWith<IndexOutOfBoundsException> { list[-1] }
        for (e in list) {
            fail()
        }
    }

    @Test
    fun testEmptyEnumBehaviour() {
        val list = EnumEntriesList(EmptyEnum::values)
        compare(EmptyEnum.values().toList(), list) { listBehavior() }
    }

    @Test
    fun testForEnum() {
        val list = EnumEntriesList(NonEmptyEnum::values)
        val goldenCopy = NonEmptyEnum.values().toList()
        assertEquals(goldenCopy, list)
        assertFalse { list is MutableList<*> }
        for ((idx, e) in goldenCopy.withIndex()) {
            assertEquals(e, list[e.ordinal])
            assertEquals(idx, list.indexOf(e))
            assertEquals(e, list[idx])
        }
        assertFailsWith<IndexOutOfBoundsException> { list[-1] }
        assertFailsWith<IndexOutOfBoundsException> { list[goldenCopy.size] }
    }

    @Test
    fun testyEnumBehaviour() {
        val list = EnumEntriesList(NonEmptyEnum::values)
        compare(NonEmptyEnum.values().toList(), list) { listBehavior() }
    }
}
