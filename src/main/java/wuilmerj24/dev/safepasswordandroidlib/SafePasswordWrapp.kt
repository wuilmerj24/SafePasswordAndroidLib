package wuilmerj24.dev.safepasswordandroidlib

open class SafePasswordWrapp {
    fun generatePasswordWrapp(
        length: ULong,
        uppercase: Boolean,
        numbers: Boolean,
        symbols: Boolean
    ): String{
        return generatePassword(
            length,
            uppercase,
            numbers,
            symbols
        )
    }

    fun checkStrengthWrappp(password: String): PasswordStrength{
        return checkStrength(password)
    }
}