package org.mjdev.balldontlie.base.network

import kotlinx.coroutines.flow.Flow

interface NetworkConnectivityService {

    val networkStatus: Flow<NetworkStatus>

}