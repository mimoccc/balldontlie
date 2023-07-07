package org.mjdev.balldontlie.base.network

import android.net.ConnectivityManager
import android.net.Network

class ConectivityCallback(
    val trySend: (data: NetworkStatus) -> Unit
) : ConnectivityManager.NetworkCallback() {

    override fun onAvailable(network: Network) {
        trySend(NetworkStatus.Connected(network))
    }

    override fun onUnavailable() {
        trySend(NetworkStatus.Disconnected)
    }

    override fun onLost(network: Network) {
        trySend(NetworkStatus.Disconnected)
    }

}