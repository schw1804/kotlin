sealed interface TestInterfaceA {
    @JsName("testOverloadString")
    fun testOverload(f: (String) -> Unit): String
    @JsName("testOverload")
    fun testOverload(f: (String, Int) -> Unit): String

    sealed interface TestInterfaceAB : TestInterfaceA {
        override fun testOverload(f: (String) -> Unit): String
        override fun testOverload(f: (String, Int) -> Unit): String
    }
}

internal sealed class TestClassA : TestInterfaceA {
    override fun testOverload(f: (String) -> Unit): String = "TestClassA::testOverload1"
    override fun testOverload(f: (String, Int) -> Unit): String = "TestClassA::testOverload2"

    class TestClassAB : TestClassA(), TestInterfaceA.TestInterfaceAB {
        override fun testOverload(f: (String) -> Unit): String = "TestClassAB::testOverload1"
        override fun testOverload(f: (String, Int) -> Unit): String = "TestClassAB::testOverload2"
    }
}

fun box() : String {
    val ab = TestClassA.TestClassAB()

    assertEquals("TestClassAB::testOverload1", ab.testOverload { _ -> })
    assertEquals("TestClassAB::testOverload2", ab.testOverload { _, _ -> })
    return "OK"
}
