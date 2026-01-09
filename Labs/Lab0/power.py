# Lab 0 Part II D
def power(base, exponent):
    """
    Computes base raised to the power of exponent.

    :param base: int or float
    :param exponent: non-negative integer
    :return: base ** exponent
    """
    result = 1
    for _ in range(exponent):
        result *= base
    return result
