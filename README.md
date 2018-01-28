# sbt2901b

Sample repo for [sbt issue 2901](https://github.com/sbt/sbt/issues/2901).

This is a Scala project that tries to use a source dependency that can cross-compile for both 2.11 and 2.12 (default).


## As Scala 2.12

In `build.sbt`:

```
scalaVersion := "2.12.4"
val tag = "0.0.1"
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
val tag = "0.0.1"
```

```
$ sbt run
...
[error] (update) sbt.librarymanagement.ResolveException: unresolved dependency: default#sbt2901a_2.11;0.0.1: not found
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


