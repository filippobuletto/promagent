// Copyright 2017 The Promagent Authors
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package io.promagent.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Thread local map that can be used to store context information, like the URL path of the current HTTP request.
 * <p/>
 *
 * TODO:
 * The maven module promagent-metrics has a misleading name. It is not only for metrics, but for everything
 * that is shared across hook classes, like for example this ThreadLocal.
 * Maybe we can merge Metrics and Context and create some HookContext that contains metrics and other things.
 */
public class Context {

    private static final ThreadLocal<Map<String, Object>> threadLocal = ThreadLocal.withInitial(HashMap::new);

    public static final Key<String> SERVLET_HOOK_METHOD = new Key<>("servlet.hook.method");
    public static final Key<String> SERVLET_HOOK_PATH = new Key<>("servlet.hook.path");
    public static final Key<Set<String>> JDBC_HOOK_QUERY = new Context.Key<>("jdbc.hook.query");

    public static class Key<T> {

        final String keyString;

        private Key(String keyString) {
            this.keyString = keyString;
        }
    }

    public static <T> void put(Key<T> key, T value) {
        threadLocal.get().put(key.keyString, value);
    }

    public static <T> Optional<T> get(Key<T> key) {
        return Optional.ofNullable((T) threadLocal.get().get(key.keyString));
    }

    public static void clear(Key... keys) {
        for (Key key : keys) {
            threadLocal.get().remove(key.keyString);
        }
    }
}