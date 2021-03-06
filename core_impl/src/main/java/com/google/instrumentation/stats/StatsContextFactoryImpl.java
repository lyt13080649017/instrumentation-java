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

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Native Implementation of {@link StatsContextFactory}.
 */
final class StatsContextFactoryImpl extends StatsContextFactory {
  static final StatsContextImpl DEFAULT = new StatsContextImpl(new HashMap<String, String>(0));

  /**
   * Deserializes a {@link StatsContextImpl} from a serialized {@code CensusContextProto}.
   *
   * <p>The encoded tags are of the form: {@code <tag prefix> + 'key' + <tag delim> + 'value'}*
   */
  @Override
  public StatsContextImpl deserialize(InputStream input) throws IOException {
    return StatsSerializer.deserialize(input);
  }

  @Override
  public StatsContext getDefault() {
    return DEFAULT;
  }
}
