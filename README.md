# TouchRange
Android library to set touch range of the view
### Feature
- Set the view touch bounds
- Support multiple view

### Installation
Add this to your module `build.gradle` file:

    dependencies {
	    ...
        compile 'com.github.JiamingWu233:TouchRange:1.0.0-beta'
    }

Add this to your root `build.gradle` file (not your module `build.gradle` file) :

    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }

### How to use?
```
TouchRange.let(mBtn...)
                // easy to use, like css padding
                .bounds()//default value is 14dp
//                .bounds(24.0f) //left,top,right,bottom=24dp
//                .bounds(24.0f,30.0f) //left,right=24dp top,bottom=30dp
//                .bounds(24.0f,30.0f,24.0f) //left=24dp,top=30dp,right=24dp,bottom=0dp
//                .bounds(24.0f, 30.0f, 24.0f, 30.0f) //left=24dp,top=30dp,right=24dp,bottom=30dp
                .change();
```

## License
```text
Copyright 2017 Kaming

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

