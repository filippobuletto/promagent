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

package io.promagent.hookcontext;

public class HookContext {

    private final MetricsStore metricsStore;
    private final TypeSafeThreadLocal threadLocal;

    public HookContext(MetricsStore metricsStore, TypeSafeThreadLocal threadLocal) {
        this.metricsStore = metricsStore;
        this.threadLocal = threadLocal;
    }

    public MetricsStore getMetricsStore() {
        return metricsStore;
    }

    public TypeSafeThreadLocal getThreadLocal() {
        return threadLocal;
    }
}
