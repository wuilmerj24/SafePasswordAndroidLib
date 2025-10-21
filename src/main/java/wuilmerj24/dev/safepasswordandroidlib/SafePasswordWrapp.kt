package wuilmerj24.dev.safepasswordandroidlib

open class SafePasswordWrapp {

    fun generatePasswordWrapp(
        length: Int,
        uppercase: Boolean,
        numbers: Boolean,
        symbols: Boolean
    ): String{
        return generatePassword(
            length.toLong(),
            uppercase,
            numbers,
            symbols
        )
    }

    fun checkStrengthWrapp(password: String): PasswordStrength{
        return checkStrength(password)
    }
}