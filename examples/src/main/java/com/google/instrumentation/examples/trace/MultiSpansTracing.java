/*
 * Copyright 2017, Google Inc.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.instrumentation.examples.trace;

import com.google.instrumentation.trace.Span;
import com.google.instrumentation.trace.Tracer;

/** Example showing how to directly create a child {@link Span} and add annotations. */
public final class MultiSpansTracing {
  // Per class Tracer.
  private static final Tracer tracer = Tracer.getTracer();

  private static void doWork() {
    Span rootSpan = tracer.spanBuilder(null, "MyRootSpan").startSpan();
    rootSpan.addAnnotation("Annotation to the root Span before child is created.");
    Span childSpan = tracer.spanBuilder(rootSpan, "MyChildSpan").startSpan();
    childSpan.addAnnotation("Annotation to the child Span");
    childSpan.end();
    rootSpan.addAnnotation("Annotation to the root Span after child is ended.");
    rootSpan.end();
  }

  /** Main method. */
  public static void main(String[] args) {
    doWork();
  }
}
