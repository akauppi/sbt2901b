# sbt2901b

Sample repo for [sbt issue 2901](https://github.com/sbt/sbt/issues/2901).

This is a Scala 2.11 project that tries to use a source dependency that can cross-compile for both 2.11 and 2.12 (default).


## As Scala 2.12

In `build.sbt`:

```
scalaVersion := "2.12.1"
val tag = "0.0.0"
```

```
$ sbt run
...
A says: Hi, world!
```

That's fine.

## As Scala 2.11

In `build.sbt`:

```
scalaVersion := "2.11.8"
val tag = "0.0.0"
```

```
$ sbt run
...
[warn] 	::::::::::::::::::::::::::::::::::::::::::::::
[warn] 	::          UNRESOLVED DEPENDENCIES         ::
[warn] 	::::::::::::::::::::::::::::::::::::::::::::::
[warn] 	:: default#sbt2901a_2.11;0.1-SNAPSHOT: not found
[warn] 	::::::::::::::::::::::::::::::::::::::::::::::
[warn] 
[warn] 	Note: Unresolved dependencies path:
[warn] 		default:sbt2901a_2.11:0.1-SNAPSHOT
[warn] 		  +- default:sbt2901b_2.11:0.1-SNAPSHOT
sbt.ResolveException: unresolved dependency: default#sbt2901a_2.11;0.1-SNAPSHOT: not found
...
```

### Workaround 1

```
$ sbt +update
$ sbt run
...
A says: Hi, world!
```

It seems the `sbt +update` (update for all cross-compiled Scala versions) does something that lets `sbt` find the right dependency.

### Workaround 2

In `build.sbt`:

```
scalaVersion := "2.11.8"
val tag = "0.0.0-2.11"
```

```
$ sbt run
...
A says: Hi, world!
```

## Problem

The possibility of referring to a source repository is handy, if one cannot publish binary artefacts for some reason.

However, currently cross-compiling dependencies are not really supported. Both of the above workarounds work, but are either not obvious (`sbt +update`), or need manual steps (maintaining two source tags).

Will be interesting to hear `sbt` maintainers' points on this.

