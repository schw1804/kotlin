fun box(): String {
    fun foo(s: String) = s
    return (::foo).let { it("OK") }
}
