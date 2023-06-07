//[app](../../../index.md)/[org.mjdev.balldontlie.base.helpers](../index.md)/[Ext](index.md)/[collectAsState](collect-as-state.md)

# collectAsState

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[T](collect-as-state.md) : [R](collect-as-state.md), [R](collect-as-state.md)&gt; Flow&lt;[T](collect-as-state.md)&gt;.[collectAsState](collect-as-state.md)(initial: [R](collect-as-state.md), context: [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) = EmptyCoroutineContext): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[R](collect-as-state.md)&gt;

Function collects data from flow to an state value. This function is only extended for edit mode, as preview does not call suspended functions when in preview.

#### Return

[State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)

#### Receiver

Flow

#### Parameters

androidJvm

| | |
|---|---|
| initial | Initial |
| context | Context |
| T | T |
| R | R |
