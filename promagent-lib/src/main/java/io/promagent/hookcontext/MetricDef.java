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

import io.prometheus.client.Collector;
import io.prometheus.client.CollectorRegistry;

import java.util.function.Function;

public class MetricDef<T extends Collector> {

    private final String metricName;
    private final Function<CollectorRegistry, T> producer;

    public MetricDef(String metricName, Function<CollectorRegistry, T> producer) {
        this.metricName = metricName;
        this.producer = producer;
    }

    String getMetricName() {
        return metricName;
    }

    Function<CollectorRegistry, T> getProducer() {
        return producer;
    }
}
