//[app](../../../index.md)/[org.mjdev.balldontlie.database](../index.md)/[DAO](index.md)

# DAO

[androidJvm]\
class [DAO](index.md)(val context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : OrmLiteSqliteOpenHelper

Dao.

Database access object

## Constructors

| | |
|---|---|
| [DAO](-d-a-o.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html))<br>Create [DAO](index.md) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [close](index.md#842441913%2FFunctions%2F-912451524) | [androidJvm]<br>open override fun [close](index.md#842441913%2FFunctions%2F-912451524)() |
| [getConnectionSource](index.md#-971594878%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [getConnectionSource](index.md#-971594878%2FFunctions%2F-912451524)(): ConnectionSource |
| [getDao](index.md#-1147625822%2FFunctions%2F-912451524) | [androidJvm]<br>open fun &lt;[D](index.md#-1147625822%2FFunctions%2F-912451524) : Dao&lt;[T](index.md#-1147625822%2FFunctions%2F-912451524), *&gt;, [T](index.md#-1147625822%2FFunctions%2F-912451524) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [getDao](index.md#-1147625822%2FFunctions%2F-912451524)(p0: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[T](index.md#-1147625822%2FFunctions%2F-912451524)&gt;): [D](index.md#-1147625822%2FFunctions%2F-912451524) |
| [getDatabaseName](index.md#212460990%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [getDatabaseName](index.md#212460990%2FFunctions%2F-912451524)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getReadableDatabase](index.md#29782627%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [getReadableDatabase](index.md#29782627%2FFunctions%2F-912451524)(p0: [CharArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-array/index.html)): SQLiteDatabase<br>open fun [getReadableDatabase](index.md#610739883%2FFunctions%2F-912451524)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SQLiteDatabase<br>[androidJvm]<br>@[Synchronized](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-synchronized/index.html)<br>fun [getReadableDatabase](get-readable-database.md)(): SQLiteDatabase?<br>Get readable database. |
| [getRuntimeExceptionDao](index.md#513549003%2FFunctions%2F-912451524) | [androidJvm]<br>open fun &lt;[D](index.md#513549003%2FFunctions%2F-912451524) : RuntimeExceptionDao&lt;[T](index.md#513549003%2FFunctions%2F-912451524), *&gt;, [T](index.md#513549003%2FFunctions%2F-912451524) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [getRuntimeExceptionDao](index.md#513549003%2FFunctions%2F-912451524)(p0: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[T](index.md#513549003%2FFunctions%2F-912451524)&gt;): [D](index.md#513549003%2FFunctions%2F-912451524) |
| [getWritableDatabase](index.md#-1178113869%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [getWritableDatabase](index.md#-1178113869%2FFunctions%2F-912451524)(p0: [CharArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-array/index.html)): SQLiteDatabase<br>open fun [getWritableDatabase](index.md#2053263963%2FFunctions%2F-912451524)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SQLiteDatabase<br>[androidJvm]<br>@[Synchronized](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-synchronized/index.html)<br>fun [getWritableDatabase](get-writable-database.md)(): SQLiteDatabase?<br>Get writable database. |
| [onConfigure](index.md#-931568133%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [onConfigure](index.md#-931568133%2FFunctions%2F-912451524)(p0: SQLiteDatabase) |
| [onCreate](index.md#-1762427168%2FFunctions%2F-912451524) | [androidJvm]<br>override fun [onCreate](index.md#-1762427168%2FFunctions%2F-912451524)(p0: SQLiteDatabase)<br>[androidJvm]<br>open override fun [onCreate](on-create.md)(database: SQLiteDatabase?, connectionSource: ConnectionSource?)<br>On create. |
| [onDowngrade](index.md#1869763498%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [onDowngrade](index.md#1869763498%2FFunctions%2F-912451524)(p0: SQLiteDatabase, p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), p2: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [onOpen](index.md#-906167913%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [onOpen](index.md#-906167913%2FFunctions%2F-912451524)(p0: SQLiteDatabase) |
| [onUpgrade](index.md#-589439526%2FFunctions%2F-912451524) | [androidJvm]<br>override fun [onUpgrade](index.md#-589439526%2FFunctions%2F-912451524)(p0: SQLiteDatabase, p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), p2: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>[androidJvm]<br>open override fun [onUpgrade](on-upgrade.md)(database: SQLiteDatabase?, connectionSource: ConnectionSource?, oldVersion: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), newVersion: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>On upgrade. |
| [setWriteAheadLoggingEnabled](index.md#-698488903%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [setWriteAheadLoggingEnabled](index.md#-698488903%2FFunctions%2F-912451524)(p0: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [toString](index.md#-1430882723%2FFunctions%2F-912451524) | [androidJvm]<br>open override fun [toString](index.md#-1430882723%2FFunctions%2F-912451524)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [context](context.md) | [androidJvm]<br>val [context](context.md): [Context](https://developer.android.com/reference/kotlin/android/content/Context.html) |
| [isOpen](index.md#-294111691%2FProperties%2F-912451524) | [androidJvm]<br>val [isOpen](index.md#-294111691%2FProperties%2F-912451524): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [playerDao](player-dao.md) | [androidJvm]<br>val [playerDao](player-dao.md): Dao&lt;[Player](../../org.mjdev.balldontlie.model/-player/index.md), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;<br>Players data access property |
| [teamDao](team-dao.md) | [androidJvm]<br>val [teamDao](team-dao.md): Dao&lt;[Team](../../org.mjdev.balldontlie.model/-team/index.md), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;<br>Teams db access property |
