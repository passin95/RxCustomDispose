/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.passin.rxdispose.android;

import me.passin.rxdispose.LifecycleProvider;

/**
 * Lifecycle events that can be emitted by Activity.
 */
public interface ActivityLifecycle extends LifecycleProvider<String> {

    String GROUP = ActivityLifecycle.class.getCanonicalName();

    String CREATE = GROUP + "CREATE";
    String START = GROUP + "START";
    String RESUME = GROUP + "RESUME";
    String PAUSE = GROUP + "PAUSE";
    String STOP = GROUP + "STOP";
    String DESTROY = GROUP + "DESTROY";
}
