//[app](../../../index.md)/[org.mjdev.balldontlie.base.helpers](../index.md)/[Ext](index.md)/[mockViewModel](mock-view-model.md)

# mockViewModel

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

inline fun &lt;[VM](mock-view-model.md)&gt; [mockViewModel](mock-view-model.md)(repository: [IRepository](../../org.mjdev.balldontlie.repository.def/-i-repository/index.md) = MockRepository): [VM](mock-view-model.md)

Mock view model generation function.

In this case is used reflection, as there are no another possibility.

Function generate mocked view model, mainly with [MockRepository](../../org.mjdev.balldontlie.repository.impl/-mocked-repository/-companion/-mock-repository.md) as a input.

#### Return

[VM](mock-view-model.md)

#### Parameters

androidJvm

| | |
|---|---|
| VM | Vm |
