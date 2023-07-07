package org.mjdev.balldontlie.base.network

import android.net.Network

sealed class NetworkStatus {

    object Unknown: NetworkStatus()

    class Connected(val network: Network): NetworkStatus()

    object Disconnected: NetworkStatus()

}