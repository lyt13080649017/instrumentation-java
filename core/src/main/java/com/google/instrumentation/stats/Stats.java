/*
 * Copyright 2016, Google Inc.
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

package com.google.instrumentation.stats;

import com.google.instrumentation.common.Provider;

/**
 * {@link Stats}.
 */
public final class Stats {
  private static final StatsManager statsManager = Provider.newInstance(
      "com.google.instrumentation.stats.StatsManagerImpl", null);

  /**
   * Returns the default {@link StatsContextFactory}.
   */
  public static StatsContextFactory getStatsContextFactory() {
    return statsManager.getStatsContextFactory();
  }

  /**
   * Returns the default {@link StatsManager}.
   */
  public static StatsManager getStatsManager() {
    return statsManager;
  }

  // VisibleForTesting
  Stats() {
    throw new AssertionError();
  }
}
