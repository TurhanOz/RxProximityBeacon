# Android RxProximityBeacon
[![Build Status](https://travis-ci.org/TurhanOz/RxProximityBeacon.svg?branch=master)](https://travis-ci.org/TurhanOz/RxProximityBeacon)
[![Maven Central](https://img.shields.io/badge/maven--central-0.0.1-blue.svg)](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22rxproximitybeacon%22)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-RxProximityBeacon-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/2745)
[![Stories in Ready](https://badge.waffle.io/TurhanOz/RxProximityBeacon.png?label=ready&title=Ready)](https://waffle.io/TurhanOz/RxProximityBeacon)
[![Gitter](https://badges.gitter.im/TurhanOz/RxProximityBeacon.svg)](https://gitter.im/TurhanOz/RxProximityBeacon?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

A simple android library that lets you easily query against the [Proximity Beacon REST Api](https://developers.google.com/beacons/proximity/reference/rest/) in a Reactive manner.

This library has been developed using Retrofit2 and RxJava. It also integrates relevant unit tests and a sample application.

### Motivation
Google has provided a [sample application](https://github.com/google/beacon-platform) to illustrate how to interact with the Proximity Beacon API.
I'd like to thanks Google for his effort but I may admit that I'm not very fan of that sample code (huge classes, no seperation on concern, relying on AsyncTask requests...) Lot's of 'stuff' that I wish were avoided when providing open source code.

So I decided to create this library, using RxJava and providing clean Unit Tests (partial so far).

## Usage

### From Maven Central

Library releases are available on Maven Central; you can add dependencies as follow :

**Gradle**

```groovy
compile 'com.turhanoz.android.rxproximitybeacon:0.0.1@aar'
```
**Maven**

```xml
<dependency>
  <groupId>com.turhanoz.android</groupId>
  <artifactId>rxproximitybeacon</artifactId>
  <version>0.0.1</version>
  <type>aar</type>
</dependency>
```

### Supported Android SDK

You can use this library for apps starting from android 2.3.3 (gingerbread /API 10) to android 6 (marshmallow / API 23)

```
minSdkVersion 10
targetSdkVersion 23
```

### Usage
Each [Collection defined in the API documentation](https://developers.google.com/beacons/proximity/reference/rest/) has been isolated into a dedicated interface.
```java
// Get an instance of the service you are interested in
RetrofitClient client = new RetrofitClient(oauth2Token);
BeaconsAttachmentService attachmentService = client.getAttachmentService();

// query against the service you want (example of request: listing attachments)
public void listAttachments(String beaconName) {
    String nameSpacedType = "*/*";
    attachmentService.list(beaconName, nameSpacedType)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .unsubscribeOn(Schedulers.newThread())
            .subscribe(new Observer<BeaconAttachmentList>() {
                @Override
                public void onCompleted() {}

                @Override
                public void onError(Throwable e) {}

                @Override
                public void onNext(BeaconAttachmentList beaconAttachmentList) {}
            });
}

```

The sample application has to be customized and has a testing purpose only, intended for developer.
Indeed, oauth2Token and raw beacon configuration have been hard coded (so you have to change them manually in the sample).

### TODO
Anyone who would like to contribute is more than welcome :)
- update sample to get rid of hardcoded stuff (like oauth2Token, using [RxGoogleAuthentication](https://github.com/TurhanOz/RxGoogleAuthentication) or [GoogleSignIn](https://developers.google.com/identity/sign-in/android/start) ?)
- enhance UnitTest to validate integrity of pojo binding (while json serializing/deserializing)
- add Service tests (Beacon, BeaconInfo, Attachment, Diagnostic, Namespace) based on what's already started.
- use client.setAuthenticator() instead of AuthorizationInterceptor ?

License
-------

    Copyright 2015 Turhan OZ

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
