# SimpleWebWrapper

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SimpleWebWrapper-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/2694)

## What is SimpleWebWrapper?

SimpleWebWrapper is an Android library which helps you creating Wrappers for Webpages more easier.
You just have to configure the main things instead of coding them yourself.

## How to use SimpleWebWrapper?

### Gradle

SimpleWebWrapper is available via JitPack.

Add this to your root `build.gradle`:

```
 allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
 }
```

and this to your module `build.gradle`:

```
 dependencies {
        ...
        compile 'com.github.jlelse:SimpleWebWrapper:0.5'
    }
```

That's it!

### Usage in `Activity`

#### 1. Make your Activity extending `jlelse.simplewebwrapper.SimpleWebWrapperActivity`

```java
import jlelse.simplewebwrapper.SimpleWebWrapperActivity;

public class SampleActivity extends SimpleWebWrapperActivity {
```

For more information look at the SampleActivity. You can find it <a href="https://github.com/jlelse/SimpleWebWrapper/tree/master/sample">here</a>.

Btw: You can use all methods from the <a href="https://github.com/jlelse/SimpleUI">SimpleUI</a> library for more customization etc.

## Dependencies

SimpleWebWrapper is based on the <a href="https://github.com/jlelse/SimpleUI">SimpleUI</a> library.
So please look there for a detailed list of used dependencies.

## Credits

**Developer:** <a href="https://github.com/jlelse">jlelse</a>

## License

SimpleWebWrapper is licensed under the Apache 2.0 license

```
   Copyright 2015 Jan-Lukas Else

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```