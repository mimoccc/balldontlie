//[app](../../../index.md)/[org.mjdev.balldontlie.base.helpers](../index.md)/[Ext](index.md)/[appViewModel](app-view-model.md)

# appViewModel

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

inline fun &lt;[VM](app-view-model.md) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)&gt; [appViewModel](app-view-model.md)(viewModelStoreOwner: [ViewModelStoreOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModelStoreOwner.html)? = null, crossinline initBlock: [VM](app-view-model.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}): [VM](app-view-model.md)

Extended functionality to avoid generation of view model with lifecycle which is not supported yet in compose preview.

Function generates mocked view model, which should call [isMock](is-mock.md) function and generate simplified mocked result for caller.

#### Return

[VM](app-view-model.md)

#### Parameters

androidJvm

| | |
|---|---|
| viewModelStoreOwner | View model store owner |
| initBlock | Init block |
| VM | Vm |
