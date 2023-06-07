//[app](../../../index.md)/[org.mjdev.balldontlie.model.convert](../index.md)/[TeamConverter](index.md)/[TeamConverter](-team-converter.md)

# TeamConverter

[androidJvm]\
constructor(supplier: (id: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) -&gt; [Team](../../org.mjdev.balldontlie.model/-team/index.md)? = { id -&gt;
        MyObjectBox.builder().build().boxFor&lt;Team&gt;().get(id)
    })
