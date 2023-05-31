package org.mjdev.moneta.base.viewmodel

import java.lang.RuntimeException

class ViewModelError(message: String) : RuntimeException(message)